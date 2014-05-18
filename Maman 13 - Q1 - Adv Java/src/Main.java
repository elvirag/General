
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Main {

	/**
	 * @param args
	 */

	private static Integer _width;
	private static Integer _height;
	public static final Integer ROBOT_SIZE = 50;
	private static final Integer MIN_WIDTH = 354; // the size of the buttons doesn't change so I fixed the minimum width
	private static final Integer FRAME_WIDTH = 20;
	private static final Integer TITLE_HEIGHT = 20;
	private static final Integer BUTTON_HEIGHT = 50;
	private static final Integer MIN_HEIGHT = 120;
	private static Integer MAX_SIZE = 10;
	private static Integer DEF_SIZE = 1;
	protected static RobotsWorld _robotsWorld;
	protected static WorldPanel _worldPanel;
	protected static ActionsPanel _actionsPanel;


	public static void init() {
		do {
			try {
				String height = JOptionPane.showInputDialog(null,
						"Input height in number of robots (1-10)",
						"Height of Robots World",
						JOptionPane.QUESTION_MESSAGE);
				if (height == null)
					quit(); // asking whether to quit
				setHeight(Integer.parseInt(height));
			} catch (NumberFormatException e) {
				JOptionPane
				.showMessageDialog(
						null,
						"You have input a number in the wrong range. Please try again.",
						"Wrong input", JOptionPane.WARNING_MESSAGE);
			}
			catch (NullPointerException npe) {

			}
		} while(get_Height() == null );

		do {
			try {
				String width = JOptionPane.showInputDialog(
						null, "Input width in number of robots (1-10)", "Width of Robots World",
						JOptionPane.QUESTION_MESSAGE);
				if (width == null)
					quit();
				setWidth(Integer.parseInt(width));
			} catch (NumberFormatException e) {
				JOptionPane
				.showMessageDialog(
						null,
						"You have input a number in the wrong range. Please try again.",
						"Wrong input", JOptionPane.WARNING_MESSAGE);
			}

		} while (get_Width() == null);
		_robotsWorld = new RobotsWorld(get_Width() / ROBOT_SIZE, get_Height() / ROBOT_SIZE); // Adding the robot world so it can be updated.
	}

	private static void quit() {
		int input = JOptionPane //if user wants to quit before inputing the height/width
				.showConfirmDialog(null,
						"Would you like to quit?",
						"Exit?",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (input == JOptionPane.YES_OPTION)
			System.exit(0);

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

		Integer frameWidth = get_Width() + FRAME_WIDTH;
		Integer frameHeight = get_Height() + BUTTON_HEIGHT + TITLE_HEIGHT;
		frame.setSize( frameWidth  > MIN_WIDTH ? frameWidth : MIN_WIDTH ,
				frameHeight  > MIN_HEIGHT ? frameHeight : MIN_HEIGHT); //TODO
		JPanel totalPanel = new JPanel();
		totalPanel.setLayout(new BorderLayout());
		_actionsPanel = new ActionsPanel();
		totalPanel.add(_actionsPanel, BorderLayout.SOUTH);
		_worldPanel = new WorldPanel();
		totalPanel.add(_worldPanel, BorderLayout.NORTH);
		frame.add(totalPanel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
