
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class WorldPanel extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5515271562836636528L;
	GridLayout _worldLayout;
	protected RobotsWorld _robotsWorld;
	protected RobotArray _roboarray;
	
	public WorldPanel(Integer robot_width, Integer robot_height){
		super();
		_robotsWorld = new RobotsWorld(robot_width, robot_height); // Adding the robot world so it can be updated.
		_roboarray = new RobotArray();
		this.setPreferredSize(new Dimension(robot_width * Main.ROBOT_SIZE,robot_height * Main.ROBOT_SIZE));
		
		_worldLayout = new GridLayout(robot_width,robot_height,0,0);
		this.setLayout(_worldLayout);
		
		for (int i = 0; i < robot_height; i++)
			for (int j = 0; j < robot_width; j++){
				JButton temp  = new JButton();
				temp.setPreferredSize(new Dimension(Main.ROBOT_SIZE, Main.ROBOT_SIZE));
				this.add(temp);
				temp.addMouseListener(this);
			}	
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		//TODO to get the id of the robot for another method to output it.
		System.out.println("click-world\n");
		JButton currRobot = (JButton) e.getComponent();
		
		if (currRobot.getText().isEmpty()){
			System.out.println("adding a robot!!!");
			
			Direction direct = null;
			String direcString = null;
			String robotPrompt = "Please input direction of robot:\n(Up, Down, Right or Left only)";
			String robotErrorPromt = "Wrong input. " + robotPrompt;

			do {
				direcString = JOptionPane.showInputDialog(robotPrompt);
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
					robotPrompt = robotErrorPromt;
				}
			}
			while (direct == null);
	
			Robot thisRobot = new Robot(direct);
			_robotsWorld.addRobot(thisRobot, getLocation());
			System.out.println("here:" + _robotsWorld.getRobot(getLocation()));
			currRobot.setText(thisRobot.toString());
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
