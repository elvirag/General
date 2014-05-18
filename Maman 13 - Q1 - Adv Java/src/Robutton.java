import java.awt.Point;

import javax.swing.JButton;


public class Robutton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1095505464869433297L;
	Point _location;
	
	public Robutton(Point selectedRobot) {
		setLocation(selectedRobot);
	}

	public Point getLocation() {
		return _location;
	}

	public void setLocation(Point location) {
		_location = location;
	}

}
