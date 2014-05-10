import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UI extends JPanel {

	
	private JFrame frame;
	private Integer _width;
	private Integer _height;
	public RobotsWorld _robotsWorld;
	private Integer ROBOT_SIZE = 70;
	private Integer MAX_SIZE = 10;
	private Integer DEF_SIZE = 1;

	/**
	 * Empty builder only to show the panel
	 */
	public UI() {
		super();
	}

	public void init() {
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

		_robotsWorld = new RobotsWorld(get_Height(), get_Width());
		regFrame();
	}

	private void setWidth(Integer width) {
		if(width <= 0 || width > MAX_SIZE){
			JOptionPane
			.showMessageDialog(
					null,
					"You have input an incorrect width. Please restart if you don't like the result :).",
					"Wrong input", JOptionPane.WARNING_MESSAGE);
			_width = DEF_SIZE * ROBOT_SIZE;
		}
		else
			_width = width * ROBOT_SIZE;
	}

	private void setHeight(Integer height) {
		if(height <= 0 || height > MAX_SIZE){
			JOptionPane
			.showMessageDialog(
					null,
					"You have input an incorrect height. Please restart if you don't like the result :).",
					"Wrong input", JOptionPane.WARNING_MESSAGE);
			_height = DEF_SIZE *  ROBOT_SIZE;
		}
		else
			_height = height * ROBOT_SIZE;

	}

	private Integer get_Height(){
		return _height;
	}
	
	private Integer get_Width(){
		return _width;
	}

	public void regFrame() {
		frame = new JFrame("Robot's World");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		frame.setSize(get_Height(), get_Width()); // TODO
		for (int i = 0; i < get_Height()/ROBOT_SIZE; i++)
			for (int j = 0; j< get_Width()/ROBOT_SIZE; j++)
				frame.add(new Robutton());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
