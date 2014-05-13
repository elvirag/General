
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Main {

	/**
	 * @param args
	 */

	private static final Integer WIDTH_FACTOR = 300;
	private static final Integer HEIGHT_FACTOR = 350;
	private static Integer _width;
	private static Integer _height;
	private static Integer MAX_SIZE = 10;
	private static Integer DEF_SIZE = 1;
	public static final Integer ROBOT_SIZE = 70;
	
	
	public static void init() {
		do {
			try {
				setHeight(Integer.parseInt(JOptionPane.showInputDialog(
						null, "Input height in number of robots (1-10)", "Height of Robots World",
						JOptionPane.QUESTION_MESSAGE)));
			} catch (NumberFormatException e) {
				JOptionPane
				.showMessageDialog(
						null,
						"You have input a number in the wrong range. Please try again.",
						"Wrong input", JOptionPane.WARNING_MESSAGE);
			}
			try {
				setWidth(Integer.parseInt(JOptionPane.showInputDialog(
						null, "Input width in number of robots (1-10)", "Width of Robots World",
						JOptionPane.QUESTION_MESSAGE)));
			} catch (NumberFormatException e) {
				JOptionPane
				.showMessageDialog(
						null,
						"You have input a number in the wrong range. Please try again.",
						"Wrong input", JOptionPane.WARNING_MESSAGE);
			}

		} while (get_Height() == null || get_Width() == null);

	}

	static Integer get_Width() {
		return _width;
	}

	static Integer get_Height() {
		return _height;
	}

	private static void setWidth(Integer width) {
		if(width <= 0 || width > MAX_SIZE){
			JOptionPane
			.showMessageDialog(
					null,
					"You have input an incorrect width. Please restart if you don't like the result :).",
					"Wrong input", JOptionPane.WARNING_MESSAGE);
			_width = DEF_SIZE * Main.ROBOT_SIZE;
		}
		else
			_width = width * Main.ROBOT_SIZE;
	}

	static void setHeight(Integer height) {
		if(height <= 0 || height > MAX_SIZE){
			JOptionPane
			.showMessageDialog(
					null,
					"You have input an incorrect height. Please restart if you don't like the result :).",
					"Wrong input", JOptionPane.WARNING_MESSAGE);
			_height = DEF_SIZE *  Main.ROBOT_SIZE;
		}
		else
			_height = height * Main.ROBOT_SIZE;

	}





	public static void main(String[] args) {
		
		init();
		
		JFrame frame = new JFrame("Robot's World");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		frame.setSize(get_Width() - WIDTH_FACTOR, get_Height() - HEIGHT_FACTOR); // TODO
		frame.add(new TotalPanel());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
