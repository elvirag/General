import java.awt.Point;
import javax.swing.JButton;
/**
 * This is the robot Button. <br>
 * It only holds the information about the point of the robot,<br>
 * so it can be matched with the robot in RobotsWorld<br>
 * Its location can be set and to be gotten as well.<br>
 */
public class Robutton extends JButton {

	private static final long serialVersionUID = -1095505464869433297L; //some serial
	Point _location;//the point that the button is at
	
	/**
	 * The constructor.
	 * Gets the point that the button should be.
	 * @param selectedRobot
	 */
	public Robutton(Point selectedRobot) {
		setbuttonLocation(selectedRobot);//setting the location in the button
	}
	
	//gets the location - for WorldPanel
	public Point getbuttonLocation() {
		return _location;
	}
	
	//sets the location - for this constructor
	private void setbuttonLocation(Point location) {
		_location = location;
	}

}
