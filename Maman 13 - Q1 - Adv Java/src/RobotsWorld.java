
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
		} else
			return false;
	}

	public Point moveRobot(Point p) {
		Point temp = new Point(p);

		if (getRobot(p) != null) {
			switch (getRobot(p).getDirectRobot()) {
			case UP:
				temp.y--;
			case DOWN:
				temp.y++;
			case RIGHT:
				temp.x++;
			case LEFT:
				temp.x--;
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
			switch (getRobot(p).getDirectRobot()) {
			case UP:
				getRobot(p).setDirectRobot(Direction.RIGHT);
			case DOWN:
				getRobot(p).setDirectRobot(Direction.LEFT);
			case RIGHT:
				getRobot(p).setDirectRobot(Direction.DOWN);
			case LEFT:
				getRobot(p).setDirectRobot(Direction.UP);
			}
		}
		return false;
	}

	public boolean turnRobotLeft(Point p) {
		if (getRobot(p) != null) {
			switch (getRobot(p).getDirectRobot()) {
			case UP:
				getRobot(p).setDirectRobot(Direction.LEFT);
			case DOWN:
				getRobot(p).setDirectRobot(Direction.RIGHT);
			case RIGHT:
				getRobot(p).setDirectRobot(Direction.UP);
			case LEFT:
				getRobot(p).setDirectRobot(Direction.DOWN);
			}
		}
		return false;
	}

	public Robot removeRobot(Point p) {
		Robot temp = getRobot(p);
		if (temp != null) {
			RobotArray.FreeID(temp); //freeing the ID so other Robots can use it
			_robotWorld[p.x][p.y] = null;
			return temp;
		}
		return null;
	}

	public Robot getRobot(Point p) {
		if ( p.x < _width && p.y < _height)
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
