import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class ActionsPanel extends JPanel implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -969652273342908891L;

	private Point _selectedRobot;
	private Color orig;

	protected JButton move;
	protected JButton right;
	protected JButton left;
	protected JButton delete;
	private final String BTN_RIGHT = "Turn Right", BTN_MOVE = "Move",
			BTN_LEFT = "Turn Left", BTN_DELETE = "Delete";


	public ActionsPanel() {
		super();
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		move = new JButton(BTN_MOVE);
		right = new JButton(BTN_RIGHT);
		left = new JButton(BTN_LEFT);
		delete = new JButton(BTN_DELETE);

		orig = move.getBackground();

		this.add(move);
		this.add(right);
		this.add(left);
		this.add(delete);

		move.addMouseListener(this);
		right.addMouseListener(this);
		left.addMouseListener(this);
		delete.addMouseListener(this);
	}

	public void setSelectedRobot(Point currRobot) {
		for (int i = 0 ; i < Main._worldPanel._robotsMatrix.length ; i++)
			for (int j = 0 ; j < Main._worldPanel._robotsMatrix[0].length ; j++)
				Main._worldPanel._robotsMatrix[i][j].setBackground(orig);

		Main._worldPanel.getRobutton(currRobot).setBackground(Color.PINK);
		_selectedRobot = new Point(currRobot);
	}

	public Point getSelectedRobot(){
		return new Point(_selectedRobot);
	}



	@Override
	public void mouseClicked(MouseEvent e) {

		JButton temp = (JButton) e.getComponent();

		if (_selectedRobot == null){
			JOptionPane.showMessageDialog(null,
					"You have to select a robot first. Please try again.",
					"No selection", JOptionPane.WARNING_MESSAGE);
		}
		else {
			//this is for moving the robot. That was fun... NOT
			if (temp.getText().equals(BTN_MOVE) ){

				Point newLocation = null;
				newLocation = Main._robotsWorld.moveRobot(_selectedRobot);
				if (newLocation != null){
					Main._worldPanel.getRobutton(_selectedRobot).setText(""); // deleting content from previous location
					Main._worldPanel.getRobutton(_selectedRobot).setBackground(orig); //setting the color to not selected
					Main._worldPanel.getRobutton(newLocation).setText(Main._robotsWorld.getRobot(newLocation).toString()); //setting robot text to new location
					Main._worldPanel.getRobutton(newLocation).setBackground(Color.PINK); //setting new robot to selected
					_selectedRobot = newLocation;
				}
			}

			//this is for turning right
			if (temp.getText().equals(BTN_RIGHT) ){
				if (Main._robotsWorld.turnRobotRight(_selectedRobot)){
					Main._worldPanel.getRobutton(_selectedRobot).setText(Main._robotsWorld.getRobot(_selectedRobot).toString());
				}
			}

			//this is for turning right
			if (temp.getText().equals(BTN_LEFT) ){
				if (Main._robotsWorld.turnRobotLeft(_selectedRobot)){
					Main._worldPanel.getRobutton(_selectedRobot).setText(Main._robotsWorld.getRobot(_selectedRobot).toString());
				}
			}

			//this is for deleting robot
			if (temp.getText().equals(BTN_DELETE) ){
				Main._worldPanel.getRobutton(_selectedRobot).setBackground(orig);
				Main._robotsWorld.removeRobot(_selectedRobot);
				Main._worldPanel.getRobutton(_selectedRobot).setText("");
				_selectedRobot = null;
			}
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
