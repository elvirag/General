/**
 * This is the robot array.<br>
 * It stores the IDs and manages them,<br>
 * so robots are created with unique IDs<br>
 * that can be freed when they are deleted<br>
 * so another robot can reuse this id.<br>
 *
 */
public class RobotArray{

	public static Integer[] _roboarray; //the array to store all the ids so I can recycle them and to know what is taken
	private static Integer _minID; // the minimal ID, so I only look in a small place of the array

	/**
	 * The constructor. initializes robot array with size from lenght and width. <br>
	 * Divided by robots because it already multiplied in Main.
	 */
	public RobotArray(){
		_roboarray = new Integer[(Main.get_Width() * Main.get_Height())
		                         / (Main.ROBOT_SIZE * Main.ROBOT_SIZE)];
		_minID = 0; //initializing minId to 0, because it's the smallest.
	}

	/**
	 * Sets the Id of the robot. <br>
	 * Tries to find the smallest while assigning.
	 * Sets the taken ones as "-1" instead of null
	 * @return the new robot ID
	 */
	public static Integer setID() {
		//go only from beginning of array and try to find a new vacant place.
		for (int i = 0 ; i <= _minID ; i++) { //no need to search the whole array, the last "null" place is enough
			if ( _roboarray[i] == null ){ //if found an empty place
				_minID = i; //this is our minimal ID
				_roboarray[i] = -1; //update it as taken
				return _minID; //return it as our new minId
			}
			else
				_minID++; //goes forward
		}
		return _minID;
	}

	/**
	 * Gets a new Id and frees the place in the array relevant. also, updates it as minId if it's minimal.
	 * @param temp - robot to be freed
	 */
	public static void FreeID(Robot temp) {
		_minID = _minID > temp.getIdRobot() ? temp.getIdRobot() : _minID; //love those (from C). Setting minimal if it helps to minimize the Id
		_roboarray[temp.getIdRobot()] = null; //nullifies back the array
	}
}
