import javax.swing.JFrame;

import UIPack.UI;


public class Main {

	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UI ui = new UI();
		ui.setSize(FRAME_HEIGHT, FRAME_WIDTH);
		ui.setVisible(true);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
