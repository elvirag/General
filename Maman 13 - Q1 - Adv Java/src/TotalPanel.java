
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TotalPanel extends JPanel implements MouseListener{

	WorldPanel _worldPanel;
	ActionsPanel _actionPanel;
	Robot _boardRobot;
	JButton _selectedRobot;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1256988321613945776L;
	/**
	 * Empty builder only to show the panel
	 */
	public TotalPanel() {
		super();
		this.setLayout(new BorderLayout());
		_worldPanel = new WorldPanel(Main.get_Width()/Main.ROBOT_SIZE, Main.get_Height()/Main.ROBOT_SIZE); //to add a method to select the button so the totalpanel can know
		this.add(_worldPanel,BorderLayout.NORTH);
		_actionPanel = new ActionsPanel();
		this.add(_actionPanel,BorderLayout.SOUTH);
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("click: " + ((JButton) e.getComponent()).getText());
		
		if (((JButton) e.getComponent()).getText().isEmpty()){
			//here writing to add robot
			System.out.println("adding a robot!!!");
			
			Direction direct = null;
			String direcString = null;
			_selectedRobot = (JButton) e.getComponent();
			do {
				direcString = JOptionPane.showInputDialog("Please input direction of robot: (Up, Down, Right or Left only)");
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
				default:
					setBackground(Color.RED);
				}
			}
			while (direct == null);
	
			_boardRobot = new Robot(direct);
			_selectedRobot.setText(_boardRobot.toString());
		}
		
		else if (((JButton) e.getComponent()).getText().matches("\\d")){
			//here writing to store this robot and change it's background so I can use it to do things.
			//also, if another robot was selected, the one in the selection loses it's background first!
			System.out.println("Clicking an existing robot!!!");
		}
		
		else if (((JButton) e.getComponent()).getText().matches("\\w")){
			//here writing to do some action about chosen robot
			//don't forget to add something if referenced robot is null
			System.out.println("Clicking an action button!!!");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("enter1");
	}


	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("exit1");
	}


	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("press");
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("release");
	}

}



//	}
//	if (e.getComponent().getName().equalsIgnoreCase("Move") ){
//		System.out.println("Move!");
//	}
//	if (e.getComponent().getName().equalsIgnoreCase("Turn Right") ){
//		System.out.println("Turn Right!");
//	}
//	if (e.getComponent().getName().equalsIgnoreCase("Turn Left") ){
//		System.out.println("Turn Left!");
//	}
//	if (e.getComponent().getName().equalsIgnoreCase("Delete") ){
//		System.out.println("Delete!");
//	}
//}
//
//
//@Override
//public void mouseClicked(MouseEvent arg0) {
//
//	if (_robot == null){
//
//		Direction direct = null;
//		String direcString = null;
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
//		_robot = new Robot(direct);
//		this.setText(_robot.toString());
//	}
//	
//	else{
//		this.setBackground(Color.PINK);
//		_robot.getIdRobot();
//
//	}
//}



