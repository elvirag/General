



public class Robot {

	private Integer _idRobot;
	private Direction _directRobot;

	public Robot(Direction direction){
		setID();
		setDirectRobot(direction);
	}


	public void turnLeft(){
		switch(_directRobot){
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
		switch(_directRobot){
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
	// should be private unless stated otherwise in the maman 15.5
	public void setDirectRobot(Direction directRobot) {
		_directRobot = directRobot;
	}

	private void setID() {
		_idRobot = RobotArray.getID(); 
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
