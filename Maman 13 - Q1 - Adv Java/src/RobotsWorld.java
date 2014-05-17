
import java.awt.Point;

public class RobotsWorld {

	private static final int DEF_SIZE = 1;
	private int _width;
	private int _height;
	private Robot[][] _robotWorld;

	public RobotsWorld(Integer width, Integer height) {
		_robotWorld = new Robot[setWidth(width)][setHeight(height)];
	}

	public boolean addRobot(Robot r, Point p) {
		if (getRobot(p) == null && p.x < _width && p.y < _height) {
			_robotWorld[p.x][p.y] = r;
			return true;
		} else {
			return false;
		}
	}

	public Point moveRobot(Point p) {
		Point temp = new Point(p);

		if (getRobot(p) != null) {
			switch (getRobot(p).getDirectRobot()) {
			case UP:
				temp.y--;
				break;
			case DOWN:
				temp.y++;
				break;
			case RIGHT:
				temp.x++;
				break;
			case LEFT:
				temp.x--;
				break;
			}
			if (temp.x < 0 || temp.y < 0 || temp.x > _width || temp.y > _height) { // should check if we are out of bounds, the get robot will give a false positive otherwise :)
				return null;
			}
			if (getRobot(temp) == null) {
				_robotWorld[temp.x][temp.y] = getRobot(p);
				_robotWorld[p.x][p.y] = null;
				return temp;
			}
		}
		return null;
	}


	public boolean turnRobotRight(Point p) {
		if (getRobot(p) != null) {
			System.out.println("from robots world - robot before turn:" + getRobot(p));
			getRobot(p).turnRight();
			System.out.println("from robots world - robot after turn:" + getRobot(p));
			return true;
		}
		return false;
	}

	public boolean turnRobotLeft(Point p) {
		if (getRobot(p) != null) {
			getRobot(p).turnLeft();
			return true;
		}
		return false;
	}

	public Robot removeRobot(Point p) {
		Robot temp = getRobot(p);
		if (temp != null) {
			//RobotArray.FreeID(temp); //freeing the ID so other Robots can use it
			_robotWorld[p.x][p.y] = null;
			return temp;
		}
		return null;
	}

	public Robot getRobot(Point p) {
		if ( p.x < _width && p.y < _height && p.x >= 0 && p.y >= 0 )
			if(_robotWorld[p.x][p.y] != null)
				return _robotWorld[p.x][p.y];

		return null;
	}

	private int setHeight(int height) {
		if (height < 0)
			_height = DEF_SIZE;
		else
			_height = height;
		return _height;
	}

	private int setWidth(int width) {
		if (width < 0)
			_width = DEF_SIZE;
		else
			_width = width;
		return _width;
	}

}
