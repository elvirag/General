import java.util.Hashtable;


public class HashMemo extends Hashtable<Date, String>{

	private static final long serialVersionUID = -5364188521729684211L;//some generated serial
	private static Hashtable<Date, String> _hashtable;
	
	public HashMemo() {
		setHashtable(new Hashtable<Date, String>());
	}
	
	/**
	 * @return the _hashtable
	 */
	public static Hashtable<Date, String> getHashtable() {
		return _hashtable;
	}

	/**
	 * @param _hashtable the _hashtable to set
	 */
	public static void setHashtable(Hashtable<Date, String> _hashtable) {
		HashMemo._hashtable = _hashtable;
		_hashtable.hashCode();
	}
	
	protected String getString(Integer date){
		System.out.println("date:" + date);
		return "hi";
	}
}
