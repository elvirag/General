
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;


public class WorldPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5515271562836636528L;
	GridLayout _worldLayout;
	
	public WorldPanel(Integer robot_width, Integer robot_height){
		super();
		this.setPreferredSize(new Dimension(robot_width * Main.ROBOT_SIZE,robot_height * Main.ROBOT_SIZE));
		
		_worldLayout = new GridLayout(robot_width,robot_height,0,0);
		this.setLayout(_worldLayout);
		
		for (int i = 0; i < robot_height; i++)
			for (int j = 0; j < robot_width; j++)
				this.add(new Robutton());
	}
}
