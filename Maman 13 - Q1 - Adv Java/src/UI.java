import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UI extends JPanel {

	private JFrame frame;
	private Integer _width;
	private Integer _height;
	public RobotsWorld _robotsWorld;
	private Integer MAX_SIZE = 1000;
	private Integer DEF_SIZE = 200;

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
						null, "Input height", "Height of Robots World",
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
						null, "Input width", "Width of Robots World",
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
		if(width < 0 || width > MAX_SIZE){
			JOptionPane
			.showMessageDialog(
					null,
					"You have input an incorrect width. Please restart if you don't like the result :).",
					"Wrong input", JOptionPane.WARNING_MESSAGE);
			_width = DEF_SIZE;
		}
		else
			_width = width;
	}

	private void setHeight(Integer height) {
		if(height < 0 || height > MAX_SIZE){
			JOptionPane
			.showMessageDialog(
					null,
					"You have input an incorrect height. Please restart if you don't like the result :).",
					"Wrong input", JOptionPane.WARNING_MESSAGE);
			_height = DEF_SIZE;
		}
		else
			_height = height;

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
		frame.setSize(get_Height(), get_Width()); // TODO
		frame.add(this);
		frame.setVisible(true);
	}

}
