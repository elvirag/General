import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This Class does action on selected robots.
 * It checks if a robot was selected and then performs the actions.
 * It checks if robots don't move off the panel or not run onto other robots.
 */
public class ActionsPanel extends JPanel implements MouseListener{

	private static final long serialVersionUID = -969652273342908891L;//some serial

	private Point _selectedRobot;//keeps a selected robot
	private Color orig;//keeps the oroginal color of the buttons

	//the action buttons
	protected JButton move;
	protected JButton left;
	protected JButton right;
	protected JButton delete;

	//The text on those buttons
	private final String BTN_RIGHT = "Turn Right", BTN_MOVE = "Move",
			BTN_LEFT = "Turn Left", BTN_DELETE = "Delete";

	/**
	 * The constructor.<br>
	 * Initializes the action panel, sets layout,<br>
	 * assigns text to buttons and determines the original color from one of them.<br>
	 * Adds those buttons to the panel and adds the mouse listener to each.
	 */
	public ActionsPanel() {
		super();
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		move = new JButton(BTN_MOVE);
		left = new JButton(BTN_LEFT);
		right = new JButton(BTN_RIGHT);
		delete = new JButton(BTN_DELETE);

		orig = move.getBackground();

		this.add(move);
		this.add(left);
		this.add(right);
		this.add(delete);

		move.addMouseListener(this);
		left.addMouseListener(this);
		right.addMouseListener(this);
		delete.addMouseListener(this);
	}

	/**
	 * This method sets selected point. It's a little rough, but it's the only way, I think.<br>
	 * The robot buttons lose focus when clicking on action buttons anyway and when moving the robot,<br>
	 * ans the robot button does not change focus.<br>
	 * Changing it's focus is more complicated for me than to just color all the buttons<br>
	 * in the original color and to re-color the selected in pink again.<br>
	 * @param currRobot - the currently selected robot
	 */
	public void setSelectedRobot(Point currRobot) {
		for (int i = 0 ; i < Main._worldPanel._robotsMatrix.length ; i++)
			for (int j = 0 ; j < Main._worldPanel._robotsMatrix[0].length ; j++)
				Main._worldPanel._robotsMatrix[i][j].setBackground(orig); //setting all the buttons to original color

		Main._worldPanel.getRobutton(currRobot).setBackground(Color.PINK); //Setting the selected to pink
		_selectedRobot = new Point(currRobot); //Assigning the current robot to be selected.
	}

	//Getter of selected robot
	public Point getSelectedRobot(){
		return new Point(_selectedRobot);
	}

	/**
	 * If mouse is clicked on one of the buttons of the actions,<br>
	 * it checks if there is a selected robot. Can only happen in the beginning,<br>
	 * when there is no selected robot or if robot has been deleted.<br>
	 * Then it performs the actions stated on the button<br>
	 * (moving only if not going out of the bounds of the world<br>
	 * or another robot does not stand in the way).<br>
	 */
	@Override
	public void mouseClicked(MouseEvent e) {

		JButton temp = (JButton) e.getComponent(); // a button to compare the event & store it

		if (_selectedRobot == null){ // If no robot is selected, present a message to the user
			JOptionPane.showMessageDialog(null,
					"You have to select a robot first. Please try again.",
					"No selection", JOptionPane.WARNING_MESSAGE);
		}
		else {
			//this is for moving the robot.
			if (temp.getText().equals(BTN_MOVE) ){
				Point newLocation = null;
				newLocation = Main._robotsWorld.moveRobot(_selectedRobot);

				if (newLocation != null){ //If robot can be moved, move it and delete the former information. Set the new point to be the selected point
					Main._worldPanel.getRobutton(_selectedRobot).setText(""); // deleting content from previous location
					Main._worldPanel.getRobutton(_selectedRobot).setBackground(orig); //setting the color to not selected
					Main._worldPanel.getRobutton(newLocation).setText(Main._robotsWorld.getRobot(newLocation).toString()); //setting robot text to new location
					Main._worldPanel.getRobutton(newLocation).setBackground(Color.PINK); //setting new robot to selected
					_selectedRobot = newLocation;//setting selected point to new location of robot
				}
			}

			//this is for turning right
			if (temp.getText().equals(BTN_LEFT) )
				if (Main._robotsWorld.turnRobotLeft(_selectedRobot))
					Main._worldPanel.getRobutton(_selectedRobot).setText(Main._robotsWorld.getRobot(_selectedRobot).toString());

			//this is for turning right
			if (temp.getText().equals(BTN_RIGHT) )
				if (Main._robotsWorld.turnRobotRight(_selectedRobot))
					Main._worldPanel.getRobutton(_selectedRobot).setText(Main._robotsWorld.getRobot(_selectedRobot).toString());

			//this is for deleting robot
			if (temp.getText().equals(BTN_DELETE) ){
				Main._worldPanel.getRobutton(_selectedRobot).setBackground(orig);//deleting background change
				Main._robotsWorld.removeRobot(_selectedRobot);//deleting robot from robots world
				Main._worldPanel.getRobutton(_selectedRobot).setText(""); //deleting the text on the button
				_selectedRobot = null; //deleting the selection remembered by the panel.
			}
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
