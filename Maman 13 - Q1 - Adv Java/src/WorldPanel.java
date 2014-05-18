
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This is the class that sets the robot buttons.<br>
 * This class holds a lot of information:<br>
 * The robots world cross-referenced with the buttons matrix that creates the GUI of the robots world.<br>
 * Also, the robot array, so I can follow up on IDs.<br>
 */
public class WorldPanel extends JPanel implements MouseListener{

	private static final long serialVersionUID = -5515271562836636528L; //some serial
	protected RobotArray _roboarray; //the robot array so I can follow up on the IDs
	protected Robutton[][] _robotsMatrix; //the button matrix

	/**
	 * The constructor.<br>
	 * It initializes the robot array, the robot matrix,<br>
	 * sets the layout of the panel.<br>
	 * Then it adds buttons to the empty matrix,<br>
	 * sets the size of those buttons and puts them in a 2D array to look after the locations<br>
	 * for cross-referencing. Adds a mouse listener to each button.<br>
	 */
	public WorldPanel(){
		super();
		_roboarray = new RobotArray(); //initializing the robots array (for IDs)
		//initializing robot array - button matrix
		_robotsMatrix = new Robutton[Main.get_Width() /  Main.ROBOT_SIZE][Main.get_Height() /  Main.ROBOT_SIZE];
		//setting size of panel
		this.setPreferredSize(new Dimension(Main.get_Width(), Main.get_Height()));
		//setting panel layout
		this.setLayout(new GridLayout(_robotsMatrix[0].length, _robotsMatrix.length ,0,0));

		//Adding buttons to matrix
		for (int i = 0; i < _robotsMatrix.length ; i++){
			for (int j = 0; j < _robotsMatrix[0].length ; j++){
				Robutton temp = new Robutton(new Point(i,j)); // adding a button at a point in the matrix
				_robotsMatrix[i][j] = temp;	//putting the robot in the matrix of information - for cross-referencing				
				temp.setPreferredSize(new Dimension(Main.ROBOT_SIZE, Main.ROBOT_SIZE)); //setting preferred size of button
				this.add(temp); //adding the button to the panel
				temp.addMouseListener(this); //adding a mouse listener to it
			}	
		}
	}

	/**
	 * Getting a button from the matrix.
	 * @param selectedRobot - the point where the robot is or isn't
	 * @return - the robot in the location
	 */
	public Robutton getRobutton(Point selectedRobot){
		if (selectedRobot.getX() < 0 || selectedRobot.getY() < 0 || 
				selectedRobot.getX() >= _robotsMatrix[0].length   ||
				selectedRobot.getY() >= _robotsMatrix.length )
			return null; //if robot doesn't exist
		//return the robot in the requested point(location)
		return _robotsMatrix[(int) selectedRobot.getX()][(int) selectedRobot.getY()]; 
	}

	/**
	 * The class the does all the actions - all the actions buttons respond here.<br>
	 * It moves, deletes, turns left & right.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		//Gets the button (robot) that was clicked
		Robutton currRobot = (Robutton) e.getComponent();
		//If there is no robot 
		if (currRobot.getText().isEmpty()){
			Direction direct = null;//getting a direction
			String direcString = null; //getting a string the represents the direction
			String robotPrompt = "Please input direction of robot:\n(Up, Down, Right or Left only)"; //that's written in the dialog to add a robot
			String robotErrorPromt = "Wrong input. " + robotPrompt; //what's written after a mistake in directions

			do {//try to do it until you get it
				direcString = JOptionPane.showInputDialog(robotPrompt); //gets the string from this
				if (direcString == null){ //Check if the user inputed something
					currRobot = null;//the direction can't be filled
					break;//just return. Let the user select another one (maybe he got confused and did not mean to click here)
				}//testing by the possible directions
				switch(direcString){
				case "up":
					direct = Direction.UP;
					break;
				case "down":
					direct = Direction.DOWN;
					break;
				case "right":
					direct = Direction.RIGHT;
					break;
				case "left":
					direct = Direction.LEFT;
					break;
				case "":
					currRobot = null; //same, user was confused.
					break;
				default:
					robotPrompt = robotErrorPromt; //the prompt changes so the user may pay better attention.
				}
			}//till direction is filled or user cancels adding action.
			while (direct == null);
			//If there is a direction, initialize a robot
			Robot thisRobot = new Robot(direct);
			try {//try to add it to the robots world matrix
				Main._robotsWorld.addRobot(thisRobot, currRobot.getbuttonLocation());
				currRobot.setText(thisRobot.toString());////and to set the text on this button to the text of the new robot
			}//if not succeeded - free the ID of this robot, so other robot may use it
			catch(NullPointerException npe){
				RobotArray.FreeID(thisRobot);
				currRobot = null;
			}
		}
		else {//else, robot exists so set the selection to him
			Main._actionsPanel.setSelectedRobot(currRobot.getbuttonLocation());
		}
	}
	//All those functions are not needed.
	@Override
	public void mouseEntered(MouseEvent e){}
	@Override
	public void mouseExited(MouseEvent e){}
	@Override
	public void mousePressed(MouseEvent e){}
	@Override
	public void mouseReleased(MouseEvent e){}
}