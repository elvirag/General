import java.awt.FlowLayout;

import javax.swing.JFrame;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final int FRAME_WIDTH = 600;
		final int FRAME_HEIGHT = 400;
		
		JFrame frame = new JFrame("Blind Typing Keyboard");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocationRelativeTo(null); // centered frame
		
		FlowLayout _layout = new FlowLayout();
		frame.setLayout(_layout);
		
		//UI ui = new UI();
		//frame.add(ui);
		frame.setVisible(true);
	}

}
