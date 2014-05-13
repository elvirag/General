import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ActionsPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -969652273342908891L;
	JButton move;
	JButton right;
	JButton left;
	JButton delete;
	
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
	}
}
