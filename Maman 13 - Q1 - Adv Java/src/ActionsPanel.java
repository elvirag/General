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
			JOptionPane
			.showMessageDialog(
					null,
					"You have to select a robot first. Please try again.", "No selection", JOptionPane.WARNING_MESSAGE);
		}


		Main._worldPanel.getRobutton(_selectedRobot).setBackground(Color.PINK);

		if (temp.getText().equals(BTN_MOVE) ){
			Point newLocation = Main._robotsWorld.moveRobot(_selectedRobot);
			//System.out.println("robot selected: " + Main._robotsWorld.getRobot(_selectedRobot).toString());
			System.out.println("robot new: " + Main._robotsWorld.getRobot(newLocation).toString());
			Main._worldPanel.getRobutton(_selectedRobot).setText("");
			Main._worldPanel.getRobutton(newLocation).setText(Main._robotsWorld.getRobot(newLocation).toString());
			_selectedRobot = newLocation;

		}
		if (temp.getText().equals(BTN_RIGHT) ){
			if (Main._robotsWorld.turnRobotRight(_selectedRobot)){
				Main._worldPanel.getRobutton(_selectedRobot).setText(Main._robotsWorld.getRobot(_selectedRobot).toString());
			}
		}
		if (temp.getText().equals(BTN_LEFT) ){
			if (Main._robotsWorld.turnRobotLeft(_selectedRobot)){
				Main._worldPanel.getRobutton(_selectedRobot).setText(Main._robotsWorld.getRobot(_selectedRobot).toString());
			}
		}
		if (temp.getText().equals(BTN_DELETE) ){
			Main._robotsWorld.removeRobot(_selectedRobot);
			Main._worldPanel.getRobutton(_selectedRobot).setText("");
			_selectedRobot = null;
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



//
//@Override
//public void mouseClicked(MouseEvent e) {
//	
//	else if (((JButton) e.getComponent()).getText().matches("\\d")){
//		//here writing to store this robot and change it's background so I can use it to do things.
//		//also, if another robot was selected, the one in the selection loses it's background first!
//		System.out.println("Clicking an existing robot!!!");
//	}
//	
//	else if (((JButton) e.getComponent()).getText().matches("\\w")){
//		//here writing to do some action about chosen robot
//		//don't forget to add something if referenced robot is null
//		System.out.println("Clicking an action button!!!");
//	}
//}


//}
//}
//
//
//@Override
//public void mouseClicked(MouseEvent arg0) {
//
//if (_robot == null){
//
//	Direction direct = null;
//	String direcString = null;
//	do {
//		direcString = JOptionPane.showInputDialog("Please input direction of robot: (Up, Down, Right or Left only)");
//		switch(direcString){
//		case "up":
//			direct = Direction.UP;
//			break;
//		case "down":
//			direct = Direction.DOWN;
//			break;
//		case "right":
//			direct = Direction.RIGHT;
//			break;
//		case "left":
//			direct = Direction.LEFT;
//			break;
//		default:
//			setBackground(Color.RED);
//		}
//	}
//	while (direct == null);
//
//	_robot = new Robot(direct);
//	this.setText(_robot.toString());
//}
//
//else{
//	this.setBackground(Color.PINK);
//	_robot.getIdRobot();
//
//}
//}

