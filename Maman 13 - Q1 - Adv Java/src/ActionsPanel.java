import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ActionsPanel extends JPanel implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -969652273342908891L;

	private Point _selectedRobot;

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

		this.add(move);
		this.add(right);
		this.add(left);
		this.add(delete);

		move.addMouseListener(this);
		right.addMouseListener(this);
		left.addMouseListener(this);
		delete.addMouseListener(this);
	}

	public void setRobotsWorld(RobotsWorld robotsWorld){
		
	}
	
	public void setSelectedRobot(Point currRobot) {
		_selectedRobot = new Point(currRobot);
	}

	public Point getSelectedRobot(){
		return new Point(_selectedRobot);
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		
		JButton temp = (JButton) e.getComponent();
		System.out.println("the comp is: " + temp.getText());
		
		if (temp.getText().equals(BTN_MOVE) ){
			System.out.println("Move!");
			Point newLocation = Main._robotsWorld.moveRobot(_selectedRobot);
			//System.out.println("robot selected: " + Main._robotsWorld.getRobot(_selectedRobot).toString());
			System.out.println("robot new: " + Main._robotsWorld.getRobot(newLocation).toString());
			Main._worldPanel.getRobutton(_selectedRobot).setText("");
			Main._worldPanel.getRobutton(newLocation).setText(Main._robotsWorld.getRobot(newLocation).toString());
			_selectedRobot = newLocation;
				
		}
		if (temp.getText().equals(BTN_RIGHT) ){
			if (Main._robotsWorld.turnRobotRight(_selectedRobot)){
				System.out.println("world panel robbuton: " + Main._worldPanel.getRobutton(_selectedRobot));
				Main._worldPanel.getRobutton(_selectedRobot).setText(Main._robotsWorld.getRobot(_selectedRobot).toString());
				System.out.println("The new robot is:" + Main._robotsWorld.getRobot(_selectedRobot).toString());
				System.out.println("The button this text is supposed to be on: " + Main._worldPanel.getRobutton(_selectedRobot).getText());
			}
		}
		if (temp.getText().equals(BTN_LEFT) ){
			System.out.println("Turn Left!");
			Main._robotsWorld.getRobot(_selectedRobot).turnLeft();
		}
		if (temp.getText().equals(BTN_DELETE) ){
			System.out.println("Delete!");
			Main._robotsWorld.removeRobot(_selectedRobot);
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

