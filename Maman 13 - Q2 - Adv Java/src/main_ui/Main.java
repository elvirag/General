package main_ui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;


public class Main {

	final public static int FRAME_WIDTH = 740;
	final public static int FRAME_HEIGHT = 400;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JFrame frame = new JFrame("Blind Typing Keyboard");


		FlowLayout _layout = new FlowLayout(FlowLayout.CENTER,10,10);
		frame.getContentPane().setLayout(_layout);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); // centered frame
		
		UI ui = new UI();
		frame.add(ui);
		
		frame.setVisible(true);
	}

}
