import java.util.Random;


public class StoreSharedData implements Runnable{

	double _element1;
	double _element2;
	Random rand;
	SharedData _sharedData;



	public StoreSharedData(SharedData sharedData){
		rand = new Random();
		_sharedData = sharedData;
	}


	public void run(){

		for (int i = 0; i < Main.RUN_NUM ; i++){
			_element1 = rand.nextDouble();
			_element2 = rand.nextDouble();
			_sharedData.store(_element1, _element2);
			try
			{
				System.out.println(this.toString());
				Thread.sleep(Main.TIME_OUT);
			}
			catch (InterruptedException ie){
				System.err.println("Exception has been caught:" + ie);
				ie.printStackTrace();
			}
		}
	}

	public String toString(){
		return "Storing: ( " + _element1 + ", " + _element2 + " ) = " + ( _element1 + _element2 ) / 2;
	}
}
