import javax.swing.JFrame;

import UIPack.UI;


public class Main {

	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 400;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UI ui = new UI();
		ui.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ui.setLocationRelativeTo(null);
		ui.setResizable(false);
		ui.setVisible(true);
	}
}
