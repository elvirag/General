/**
 * The class of the robot.<br>
 * The robot has an ID and a direction.<br>
 * It's represented as a string of ID+direction.<br>
 * It can be turned left & right, it has getters & a setter for direction<br>
 * and a finalize method that nullifies it's fields.<br>
 *
 */
public class Robot {

	private Integer _idRobot; //the robot id
	private Direction _directRobot; //the robot direction

	/**
	 * The constructor.
	 * It sets the direction using the setter
	 * and also gets a unique ID to use.
	 * @param direction - the direction that it gets from user
	 */
	public Robot(Direction direction){
		setDirectRobot(direction);
		_idRobot = RobotArray.setID();
	}


	/**
	 * The robot turns left.
	 */
	public void turnLeft(){
		switch(getDirectRobot()){
		case UP:
			setDirectRobot(Direction.LEFT);
			break;
		case DOWN:
			setDirectRobot(Direction.RIGHT);
			break;
		case RIGHT:
			setDirectRobot(Direction.UP);
			break;
		case LEFT:
			setDirectRobot(Direction.DOWN);
			break;
		}
	}

	/**
	 * The robot turns right.
	 */
	public void turnRight(){
		switch(getDirectRobot()){
		case UP:
			setDirectRobot(Direction.RIGHT);
			break;
		case DOWN:
			setDirectRobot(Direction.LEFT);
			break;
		case RIGHT:
			setDirectRobot(Direction.DOWN);
			break;
		case LEFT:
			setDirectRobot(Direction.UP);
			break;
		}
	}

	/**
	 * This is the finalize method, overridden.<br>
	 * It nullifies the fields of the robot so the GC can collect it.
	 * 	@Override
	 **/
	public void finalize(){
		_idRobot = null;
		_directRobot = null;
	}

	// GETTERS
	public Integer getIdRobot() {
		return _idRobot;
	}
	public Direction getDirectRobot() {
		return _directRobot;
	}

	// SETTER
	private void setDirectRobot(Direction directRobot) {
		_directRobot = directRobot;
	}

	/**
	 * the overridden toString. Represents the robot as Id & Direction
	 */
	public String toString(){
		String arrow = "";

		switch(getDirectRobot()){
		case UP:
			arrow = "^";
			break;
		case DOWN:
			arrow = "v";
			break;
		case RIGHT:
			arrow = ">";
			break;
		case LEFT:
			arrow = "<";
			break;
		}
		return getIdRobot() + arrow;
	}
}
