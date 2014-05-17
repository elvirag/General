import java.awt.Color;
import java.awt.FlowLayout;
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
	
	private Robot _boardRobot;
	private JButton _selectedRobot;
	
	protected JButton move;
	protected JButton right;
	protected JButton left;
	protected JButton delete;

	public ActionsPanel() {
		super();
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		move = new JButton("Move");
		right = new JButton("Turn Right");
		left = new JButton("Turn Left");
		delete = new JButton("Delete");

		this.add(move);
		this.add(right);
		this.add(left);
		this.add(delete);
		
		move.addMouseListener(this);
		right.addMouseListener(this);
		left.addMouseListener(this);
		delete.addMouseListener(this);
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("click-action\n");
		
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
//	System.out.println("click-total-panel: " + ((JButton) e.getComponent()).getText() + "\n");
//	
//	if (((JButton) e.getComponent()).getText().isEmpty()){
//		//here writing to add robot
//		System.out.println("adding a robot!!!");
//		
//		Direction direct = null;
//		String direcString = null;
//		_selectedRobot = (JButton) e.getComponent();
//		do {
//			direcString = JOptionPane.showInputDialog("Please input direction of robot: (Up, Down, Right or Left only)");
//			switch(direcString){
//			case "up":
//				direct = Direction.UP;
//				break;
//			case "down":
//				direct = Direction.DOWN;
//				break;
//			case "right":
//				direct = Direction.RIGHT;
//				break;
//			case "left":
//				direct = Direction.LEFT;
//				break;
//			default:
//				setBackground(Color.RED);
//			}
//		}
//		while (direct == null);
//
//		_boardRobot = new Robot(direct);
//		_selectedRobot.setText(_boardRobot.toString());
//	}
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
//if (e.getComponent().getName().equalsIgnoreCase("Move") ){
//	System.out.println("Move!");
//}
//if (e.getComponent().getName().equalsIgnoreCase("Turn Right") ){
//	System.out.println("Turn Right!");
//}
//if (e.getComponent().getName().equalsIgnoreCase("Turn Left") ){
//	System.out.println("Turn Left!");
//}
//if (e.getComponent().getName().equalsIgnoreCase("Delete") ){
//	System.out.println("Delete!");
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

