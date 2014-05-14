import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ActionsPanel extends JPanel implements MouseListener{
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

		move.addMouseListener(this);
		right.addMouseListener(this);
		left.addMouseListener(this);
		delete.addMouseListener(this);


	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getComponent() == move){
			move.setText("Moving...");
			WorldPanel._robotsWorld.moveRobot(getLocation());
		}
		if (arg0.getComponent() == right){
			this.setEnabled(false);
		}

		if (arg0.getComponent() == left){
			this.setEnabled(false);
		}

		if (arg0.getComponent() == delete){
			this.setEnabled(false);
		}


	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
