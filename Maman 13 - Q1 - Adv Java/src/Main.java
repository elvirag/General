
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Main {

	/**
	 * @param args
	 */

	private static Integer _width;
	private static Integer _height;
	public static final Integer ROBOT_SIZE = 50;
	private static final Integer MIN_WIDTH = 354; // the size of the buttons doesn't change so I fixed the minimum width
	private static final Integer MIN_HEIGHT = 107;
	private static final Integer BUTTON_WIDTH = 354;
	private static final Integer BUTTON_HEIGHT = 50;
	private static Integer MAX_SIZE = 10;
	private static Integer DEF_SIZE = 1;
	
	
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
	
	void initRobotWorld(){
		
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
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
			
		Integer frameWidth = get_Width();
		Integer frameHeight = get_Height() + BUTTON_HEIGHT;
		frame.setSize( frameWidth  > MIN_WIDTH ? frameWidth : MIN_WIDTH ,
				frameHeight  > MIN_HEIGHT ? frameHeight : MIN_HEIGHT); //TODO
		frame.add(new TotalPanel());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
