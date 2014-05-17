



public class Robot {

	private Integer _idRobot;
	private Direction _directRobot;

	public Robot(Direction direction){
		setDirectRobot(direction);
		_idRobot = RobotArray.setID();
	}


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
	@Override
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
	
	// SETTERS
	private void setDirectRobot(Direction directRobot) {
		_directRobot = directRobot;
	}

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
