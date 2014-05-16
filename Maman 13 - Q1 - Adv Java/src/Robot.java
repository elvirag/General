



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
		case DOWN:
			setDirectRobot(Direction.RIGHT);
		case RIGHT:
			setDirectRobot(Direction.UP);
		case LEFT:
			setDirectRobot(Direction.DOWN);
		}
	}

	public void turnRight(){
		switch(getDirectRobot()){
		case UP:
			setDirectRobot(Direction.RIGHT);
		case DOWN:
			setDirectRobot(Direction.LEFT);
		case RIGHT:
			setDirectRobot(Direction.DOWN);
		case LEFT:
			setDirectRobot(Direction.UP);
		}

	}
	@Override
	public void finalize(){

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

		switch(_directRobot){
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
		return _idRobot + arrow;

	}
}
