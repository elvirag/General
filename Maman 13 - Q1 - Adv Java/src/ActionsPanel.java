import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;


public class ActionsPanel extends JPanel implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -969652273342908891L;
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
		System.out.println("click3");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("enter3");
	}


	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("exit3");
	}


	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("press3");
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("release3");
	}

}
