

public class RobotArray{

	public static Robot[] _roboarray;
	private static Integer _minID;

	public RobotArray(){
		_roboarray = new Robot[Main.get_Width() * Main.get_Height()];
		System.out.println(_roboarray);
		_minID = 0;
	}



	public static Integer getID() {

		for (int i = 0 ; i <= _minID ; i++) {
			if ( _roboarray[i] == null ){
				_minID = i;
				break;
			}
		}
		return _minID;
	}

	public static void FreeID(Robot robot){
		Integer robID = robot.getIdRobot();

		_roboarray[robID] = null;
		if (robID < _minID)
			_minID = robID;
	}




}
