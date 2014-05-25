import javax.swing.JFrame;


public class Main{

	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 400;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UI ui = new UI();
		ui.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		ui.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//Implementation of method to save on exit requires the handling of that there.
		ui.setLocationRelativeTo(null);
		ui.setResizable(false);
		ui.setVisible(true);
	}

}
