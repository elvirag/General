


public class Main{

	
	static final int RUN_NUM = 10;
	static final long TIME_OUT = 400; // 2 secs time out

	
	public static void main(String[] args) {
		
		SharedData sharedData = new SharedData();
		
		Thread store = new Thread(new StoreSharedData(sharedData));
		store.start();
		Thread calc = new Thread(new CalcSharedData(sharedData));
		calc.start();

	}
	

}
