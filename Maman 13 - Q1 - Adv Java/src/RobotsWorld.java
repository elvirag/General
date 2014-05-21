import java.awt.Point;

/**
 * This is the logic class.<br>
 * It contains:<br>
 * 1.) An array of robots.<br>
 * 2.) A method to add a robot.<br>
 * 3.) A method to remove a robot.<br>
 * 4.) A method to turn a robot right.<br>
 * 5.) A method to turn a robot left.<br>
 * 6.) A constructor to set the size of the robots world.<br>
 * 7.) Two fields that contain the height and width of the world, in robots, ofc.<br>
 * 8.) Most important - getRobot - a method to get a robot at a certain point.
 */
public class RobotsWorld {

	private static final int DEF_SIZE = 1; //if height or width are negative.
	private int _width; //width of world (in robots)
	private int _height;// height of world (in robots)
	private Robot[][] _robotWorld; // the 2D array (matrix) of robots.

	/**
	 * Constructor. initializes the robots matrix with given sizes from user.
	 * @param width of world (in robots)
	 * @param height of world (in robots)
	 */
	public RobotsWorld(Integer height, Integer width) {
		_robotWorld = new Robot[setHeight(height)][setWidth(width)];
	}

	/**
	 * Adds a robot to the world.<br>
	 * @param r - robot
	 * @param p - point
	 * @return <b>true</b> if robot was added;<br>
	 * <b>false</b> if wrong coordinates were given or a robot already existed there.
	 */
	public boolean addRobot(Robot r, Point p) {
		if (getRobot(p) == null && p.x < _height && p.y < _width ) {
			_robotWorld[p.x][p.y] = r;
			return true;
		}
		else
			return false;
	}

	/**
	 * Moves a robot around the world.<br>
	 * @param p - point
	 * @return <b>new Point</b> of the robot if robot was moved;<br>
	 * <b>null</b> if robot can't be moved because he'll fall off the world<br>
	 * or if there is another robot in the way.
	 */
	public Point moveRobot(Point p) {
		Point temp = new Point(p); // storing the point where the robot is so we can move the point and find out it's new coordinates
		//if there is a robot in the point selected, move it
		if (getRobot(p) != null) {
			switch (getRobot(p).getDirectRobot()) {
			case UP:
				temp.x--;
				break;
			case DOWN:
				temp.x++;
				break;
			case RIGHT:
				temp.y++;
				break;
			case LEFT:
				temp.y--;
				break;
			}
			// should check if we are out of bounds, the get robot will give a false positive otherwise :)
			if (temp.x < 0 || temp.y < 0 || temp.x >= _height || temp.y >= _width) {
				return null;
			}
			//if there is no robot in the place where we want to move our robot, go ahead
			if (getRobot(temp) == null) {
				_robotWorld[temp.x][temp.y] = getRobot(p);//put the robot in the new place
				_robotWorld[p.x][p.y] = null;//delete the robot from the old place
				return temp; //return the new location of the robot
			}
		}
		//else, maybe an innocent robot will die (will be run over/deleted/corrupted)
		return null;
	}

	/**
	 * Turns a robot right.<br>
	 * @param p - point
	 * @return <b>true</b> if robot was turned right;<br>
	 * <b>false</b> if robot didn't exist in this point.
	 */
	public boolean turnRobotRight(Point p) {
		if (getRobot(p) != null) {
			getRobot(p).turnRight();
			return true;
		}
		return false;
	}

	/**
	 * Turns a robot left.<br>
	 * @param p - point
	 * @return <b>true</b> if robot was turned left;<br>
	 * <b>false</b> if robot didn't exist in this point.
	 */
	public boolean turnRobotLeft(Point p) {
		if (getRobot(p) != null) {
			getRobot(p).turnLeft();
			return true;
		}
		return false;
	}

	/**
	 * Removes a robot from the world.<br>
	 * Frees it's ID so another robot can be created with it.
	 * @param p - point
	 * @return <b>Robot</b> if robot was removed;<br>
	 * <b>false</b> if robot didn't exist in this point.
	 */
	public Robot removeRobot(Point p) {
		Robot temp = getRobot(p); // store the robot information in temp
		if (temp != null) { //if there is a robot here
			RobotArray.FreeID(temp); //freeing the ID so other Robots can use it
			_robotWorld[p.x][p.y].finalize(); //finalize the robot - free it's direction and id fields
			_robotWorld[p.x][p.y] = null; //nullify the place in robots world so another robot can be here
			return temp; //return the information of the robot that was stored in temp beforehand
		}
		return null; //or if there was no robot there, return null
	}

	/**
	 * Most important method, used 13 times in my program!
	 * Gets the robot in a specific given point.
	 * @param p - point
	 * @return - the robot in the location, if there is one.
	 */
	public Robot getRobot(Point p) {
		if ( p.x < _height && p.y < _width && p.x >= 0 && p.y >= 0 )
			if(_robotWorld[p.x][p.y] != null)
				return _robotWorld[p.x][p.y];
		return null;
	}
	
	//only private, not need outside
	private int setHeight(int height) { //setting the height of the robot world, in robots
		if (height < 0) //checking if not negative
			_height = DEF_SIZE; // if so, setting to default value
		else
			_height = height; //setting the height
		return _height; //return the height so I can use it. I know this is not so good, but it's better to write another getter.
	}

	//same like height
	private int setWidth(int width) {
		if (width < 0)
			_width = DEF_SIZE;
		else
			_width = width;
		return _width;
	}
}
