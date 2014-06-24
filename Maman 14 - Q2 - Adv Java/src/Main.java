import javax.swing.JFrame;

/**
 * This is the main class.
 * It creates a frame of type UI and sets all the display parameters.
 * @author Elvira Gandelman
 * <b>ID:</b> 307032623
 *
 */
public class Main{

	private static final int FRAME_WIDTH = 500; //width of frame
	private static final int FRAME_HEIGHT = 400; //height of frame

	public static void main(String[] args) {

		UI ui = new UI();// creation of the frame object
		ui.setSize(FRAME_WIDTH, FRAME_HEIGHT); //set the size of the frame
		ui.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//Implementation of method to save on exit requires the handling of that there.
		ui.setLocationRelativeTo(null); // center the frame
		ui.setResizable(false); //set the frame to not be able to be resized by the user.
		ui.setVisible(true); //show the frame
	}
}
