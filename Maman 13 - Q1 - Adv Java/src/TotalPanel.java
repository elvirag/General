
import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TotalPanel extends JPanel {

	
	private LayoutManager _totalLayout;

	/**
	 * Empty builder only to show the panel
	 */
	public TotalPanel() {
		super();
		_totalLayout = new BorderLayout();
		this.setLayout(_totalLayout);
		this.add(new WorldPanel(getWidth(), getHeight()),BorderLayout.NORTH);
		this.add(new ActionsPanel(),BorderLayout.SOUTH);
	}

	

}
