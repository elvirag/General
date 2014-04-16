
public class Robot {

	private int _idRobot;
	private Direction _directRobot;

	public Robot(Direction direction){
		setID();
		setDirectRobot(direction);
	}


	public void turnLeft(){
		switch(_directRobot){
		case UP:
			_directRobot = Direction.LEFT;
		case DOWN:
			_directRobot = Direction.RIGHT;
		case RIGHT:
			_directRobot = Direction.UP;
		case LEFT:
			_directRobot = Direction.DOWN;
		}
	}

	public void turnRight(){
		switch(_directRobot){
		case UP:
			_directRobot = Direction.RIGHT;
		case DOWN:
			_directRobot = Direction.LEFT;
		case RIGHT:
			_directRobot = Direction.DOWN;
		case LEFT:
			_directRobot = Direction.UP;
		}

	}
	@Override
	public void finalize(){
		//TODO
	}
	
	// GETTERS
	public int getIdRobot() {
		return _idRobot;
	}

	public Direction getDirectRobot() {
		return _directRobot;
	}
	// SETTERS
	public void setDirectRobot(Direction directRobot) {
		_directRobot = directRobot;
	}

	private void setID() {
		int ID = 0;
		// TODO 
		_idRobot = ID;
	}

	public String toString(){

		String arrow = "";

		switch(_directRobot){
		case UP:
			arrow = "^";
		case DOWN:
			arrow = "v";
		case RIGHT:
			arrow = ">";
		case LEFT:
			arrow = "<";
		}
		return _idRobot + arrow;

	}
}
