

public class RobotArray{

	public static Integer[] _roboarray;
	private static Integer _minID;

	public RobotArray(){
		_roboarray = new Integer[(Main.get_Width() * Main.get_Height()) / (Main.ROBOT_SIZE * Main.ROBOT_SIZE)];
		_minID = 0;
	}


	public static Integer setID() {
		
		for (int i = 0 ; i <= _minID ; i++) {
			if ( _roboarray[i] == null ){
				_minID = i;
				_roboarray[i] = -1;
				return _minID;
			}
			else
				_minID++;
		}
		return _minID;
	}


	public static void FreeID(Robot temp) {
		_minID = temp.getIdRobot();
		_roboarray[temp.getIdRobot()] = null;
	}

}
