import java.awt.Color;
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
		addMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (_robot == null){
			String direcString = JOptionPane.showInputDialog("Please input direction of robot: (Up, Down, Right or Left only)");
			Direction direct = null;
			if (direcString.equals("Up"))
				direct = Direction.UP;
			if (direcString.equals("Down"))
				direct = Direction.DOWN;
			if (direcString.equals("Right"))
				direct = Direction.RIGHT;
			if (direcString.equals("Left"))
				direct = Direction.LEFT;
			else
				try {
					throw new Direxception();
				} catch (Direxception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println("\nThe robot direction is: " + direcString);
			_robot = new Robot(direct);
		}
		else{
			setBackground(Color.PINK);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if (_robot == null){
			String direcString = JOptionPane.showInputDialog("Please input direction of robot: (Up, Down, Right or Left only)");
			System.out.println("\nThe robot direction is: " + direcString);
			Direction direct = null;
			do {
				try {
					if (direcString.equals("Up")){
						direct = Direction.UP;
						System.out.println("\nThe robot real direction is: " + direct);
					}
					if (direcString.equals("Down"))
						direct = Direction.DOWN;
					if (direcString.equals("Right"))
						direct = Direction.RIGHT;
					if (direcString.equals("Left"))
						direct = Direction.LEFT;
					else
						throw new Direxception();
				} catch (Direxception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}while(direct == null);
			_robot = new Robot(direct);
		}
		else{
			setBackground(Color.PINK);
		}
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
