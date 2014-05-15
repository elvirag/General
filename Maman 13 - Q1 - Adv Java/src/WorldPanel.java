
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;


public class WorldPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5515271562836636528L;
	GridLayout _worldLayout;
	protected static RobotsWorld _robotsWorld;
	protected static RobotArray _roboarray;
	
	public WorldPanel(Integer robot_width, Integer robot_height){
		super();
		_robotsWorld = new RobotsWorld(robot_width, robot_height); // Adding the robot world so it can be updated.
		_roboarray = new RobotArray();
		this.setPreferredSize(new Dimension(robot_width * Main.ROBOT_SIZE,robot_height * Main.ROBOT_SIZE));
		
		_worldLayout = new GridLayout(robot_width,robot_height,0,0);
		this.setLayout(_worldLayout);
		
		for (int i = 0; i < robot_height; i++)
			for (int j = 0; j < robot_width; j++)
				this.add(new Robutton());
	}
}
