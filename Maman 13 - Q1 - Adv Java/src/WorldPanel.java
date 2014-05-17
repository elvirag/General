
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class WorldPanel extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5515271562836636528L;
	private GridLayout _worldLayout;
	protected RobotArray _roboarray;
	protected Robutton[][] _robotsMatrix;


	public WorldPanel(){
		super();
		_roboarray = new RobotArray();
		_robotsMatrix = new Robutton[Main.get_Width() /  Main.ROBOT_SIZE][Main.get_Height() /  Main.ROBOT_SIZE];
		this.setPreferredSize(new Dimension(Main.get_Width(), Main.get_Height()));
		_worldLayout = new GridLayout( _robotsMatrix.length, _robotsMatrix[0].length ,0,0);
		this.setLayout(_worldLayout);

		for (int i = 0; i < _robotsMatrix.length ; i++)
			for (int j = 0; j < _robotsMatrix[0].length ; j++){
				Robutton temp = new Robutton(new Point(i,j));
				_robotsMatrix[i][j] = temp;						
				temp.setPreferredSize(new Dimension(Main.ROBOT_SIZE, Main.ROBOT_SIZE));
				this.add(temp);
				temp.addMouseListener(this);
			}	
	}

	public Robutton getRobutton(Point selectedRobot){
		if (selectedRobot.getX() < 0 || selectedRobot.getY() < 0 || 
				selectedRobot.getX() > _robotsMatrix[0].length          ||
				selectedRobot.getY() > _robotsMatrix.length )
			return null;
		return _robotsMatrix[(int) selectedRobot.getX()][(int) selectedRobot.getY()];
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		Robutton currRobot = (Robutton) e.getComponent();

		if (currRobot.getText().isEmpty()){

			Direction direct = null;
			String direcString = null;
			String robotPrompt = "Please input direction of robot:\n(Up, Down, Right or Left only)";
			String robotErrorPromt = "Wrong input. " + robotPrompt;

			do {
				direcString = JOptionPane.showInputDialog(robotPrompt);
				if (direcString == null){
					currRobot = null;
					break;
				}
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
					currRobot = null;
					break;
				default:
					robotPrompt = robotErrorPromt;
				}
			}
			while (direct == null);

			Robot thisRobot = new Robot(direct);
			try {
			Main._robotsWorld.addRobot(thisRobot, currRobot.getLocation());
			currRobot.setText(thisRobot.toString());
			}
			catch(NullPointerException npe){
				RobotArray.FreeID(thisRobot);
				currRobot = null;
			}
		}
		else {
			Main._actionsPanel.setSelectedRobot(currRobot.getLocation());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {}


	@Override
	public void mouseExited(MouseEvent e) {}


	@Override
	public void mousePressed(MouseEvent e) {}


	@Override
	public void mouseReleased(MouseEvent e) {}

}
