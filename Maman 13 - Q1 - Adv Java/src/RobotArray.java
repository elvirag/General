

public class RobotArray{

	public static Integer[] _roboarray;
	private static Integer _minID;

	public RobotArray(){
		_roboarray = new Integer[(Main.get_Width() * Main.get_Height()) / (Main.ROBOT_SIZE * Main.ROBOT_SIZE)];
		_minID = 0;
	}



	public static Integer setID() {
		//Integer id = null;
		
		for (Integer index: _roboarray) //TODO: remove this, for debugging when I get to deleting robots
			System.out.println(index);
		System.out.println("end of id array");
		
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

	public void FreeID(Robot robot){
		Integer robID = robot.getIdRobot();

		_roboarray[robID] = null;
		if (robID < _minID)
			_minID = robID;
	}




}
