


public class Main{

	
	static final int RUN_NUM = 10;
	static final long TIME_OUT = 400; // 2 secs time out

	
	public static void main(String[] args) {
		
		SharedData sharedData = new SharedData();
		
		(new Thread(new StoreSharedData(sharedData))).start();
		(new Thread(new CalcSharedData(sharedData))).start();

	}
	

}
