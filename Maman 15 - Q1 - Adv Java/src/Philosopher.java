import java.util.Random;


public class Philosopher implements Runnable{

	private String _name;
	private String _leftHand;
	private String _rightHand;
	Random _rand;
	
	public Philosopher(String name){
		_rand = new Random();
		setName(name);
	}
	
	private void setName(String name) {
		_name = name;
	}

	private void eat(){
		System.out.println(_name + " is eating now.");
		try {
			this.wait(Main.TIME_OUT + _rand.nextInt((int) Main.TIME_OUT));
		} catch (InterruptedException e) {
			System.err.println("Problem in \"eat\"");
			e.printStackTrace();
		}
		releaseChopSticks();
	}
	
	private void releaseChopSticks() {
		_leftHand = null;
		_rightHand = null;
		this.notify();
	}

	private void think(){
		System.out.println(_name + " is thinking now.");
		try {
			this.wait(Main.TIME_OUT);
		} catch (InterruptedException e) {
			System.err.println("Problem in \"eat\"");
			e.printStackTrace();
		}
	}
	
	private void getChopstics(){
		if( getLeft() && getRight()){
		System.out.println(_name + " got both chopsticks!");
		eat();
		}
		
		else if (getLeft() && !getRight()){
		System.out.println(_name + " only got the left one... :\\");	
		}
		
		else if (!getLeft() && getRight()){
		System.out.println(_name + " only got the right one... :/");	
		}
		
		else if (!getLeft() && !getRight()){
		System.out.println(_name + " got none of the chopsticks... :`|");	
		}
		
	}
	
	private boolean getRight() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean getLeft() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
