package main_ui;
import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 * This class sets the main frame and adds the panel.<br>
 * The panel isn't resizeable, fixed in size and is centered. <br>
 * @author Elvira Gandelman<br>
 * <b>ID:</b> 307032623
 *
 */
public class Main {

	final public static int FRAME_WIDTH = 710; // The width of the keyboard - all sizes are set
	final public static int FRAME_HEIGHT = 400; // The width of the keyboard - all sizes are set


	public static void main(String[] args) {

		JFrame frame = new JFrame("Blind Typing Keyboard"); // creating a new frame and title

		frame.setLayout(new FlowLayout(FlowLayout.CENTER,0,0)); // setting the layout for the panel on the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT); // setting frame size
		frame.setResizable(false); // frame is not resizable, no need for that.
		frame.setLocationRelativeTo(null); // centered frame
		frame.add(new UI()); // adding all the other panels on top of this panel
		frame.setVisible(true); // show the frame.
	}

}
