
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;


public class Robutton extends JButton implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 666142079284199889L;

	Robot _robot = null;

	public Robutton() {
		super();
		this.setPreferredSize(new Dimension(Main.ROBOT_SIZE, Main.ROBOT_SIZE));
		addMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {

		if (_robot == null){

			Direction direct = null;
			String direcString = null;
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

			_robot = new Robot(direct);
			if (WorldPanel._robotsWorld.addRobot(_robot, getLocation()))
				this.setText(_robot.toString());
			System.out.println("Location of robot is: " + getLocation());
		}
		else{
			this.setBackground(Color.PINK);
			_robot.getIdRobot();

		}
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
