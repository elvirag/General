
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class TotalPanel extends JPanel{

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
		this.add(new WorldPanel(Main.get_Width()/Main.ROBOT_SIZE, Main.get_Height()/Main.ROBOT_SIZE),BorderLayout.NORTH);
		this.add( new ActionsPanel(),BorderLayout.SOUTH);
	}

}





