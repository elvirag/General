
import java.awt.GridLayout;

import javax.swing.JPanel;


public class WorldPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5515271562836636528L;
	GridLayout _worldLayout;
	
	public WorldPanel(Integer width, Integer height){
		super();
		_worldLayout = new GridLayout(Main.get_Height(),Main.get_Width(),0,0);
		this.setLayout(_worldLayout);
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				this.add(new Robutton());
	}
}
