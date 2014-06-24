import java.util.Random;


public class CalcSharedData implements Runnable{

	Random rand;
	SharedData _sharedData;



	public CalcSharedData(SharedData sharedData){
		rand = new Random();
		_sharedData = sharedData;
	}


	public void run(){
		for (int i = 0; i < Main.RUN_NUM ; i++){

			System.out.println("Calculating: " +	_sharedData.calc());
			try{
				Thread.sleep(Main.TIME_OUT);
			}
			catch (InterruptedException ie){
				System.err.println("Exception has been caught:" + ie);
				ie.printStackTrace();
			}
		}
	}
}
