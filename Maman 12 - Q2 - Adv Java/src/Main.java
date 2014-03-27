import javax.swing.JOptionPane;


public class Main {

	private static Integer input(){
		return Integer.parseInt(JOptionPane.showInputDialog("What is the coordinate you want to input?\n(0-99 only!\n"));
	}

	public static void main(String[] args) {

		MyPanel mypanel = new MyPanel();

		while(true){
			mypanel.addLine(input());
		}

	}
}
