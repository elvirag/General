
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This class is the Main.<br>
 * It has the frame and it requests the height and width of world in robot terms, from the user.<br>
 * It then sets the world up with all the internal parameters.<br>
 * Created a new panel of the action buttons and the world panel.<br>
 * 
 * @author Elvira Gandelman<br>
 * <b>ID:</b> 307032623
 */
public class Main {

	private static Integer _width;//width of world - in pixels this time
	private static Integer _height;//height of world - in pixels this time
	
	//The frame has some borders in the right and left and top and bottom
	//I had to add to the frame size so panel will not be obstructed.
	//Those are the parameters I used.
	private static final Integer MIN_WIDTH = 354; // the width of the action buttons
	private static final Integer FRAME_WIDTH = 15; // the width of the borders of the frame to right and left of it
	private static final Integer TITLE_HEIGHT = 20; //the height of the title
	private static final Integer BUTTON_HEIGHT = 50; //the height of the action buttons
	private static final Integer MIN_HEIGHT = 120; //the minimum height (one robot button & action buttons)
	
	//Limiting amount of robots on board - min & max
	private static Integer MAX_SIZE = 10; //max number of robots in line or column
	private static Integer DEF_SIZE = 1; //default size if wrong input was used. Restarting is an option if you don't like it.
	
	//Our static parameters: robot matrix, button matrix, action panel, world panel
	protected static RobotsWorld _robotsWorld;
	protected static WorldPanel _worldPanel;
	protected static ActionsPanel _actionsPanel;
	
	//Size of robot. If smaller - 10 looks like 3 dots. If larger, looks ridiculous.
	public static final Integer ROBOT_SIZE = 55;

	/**
	 * This init() method gets height and width (in robots) from user.
	 * Deals with NumberFormatExceptions & NullPointerException.
	 * Asks user to exit if he didn't input his parameters.
	 * Quits if requested.
	 */
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
			try
			{
				String width = JOptionPane.showInputDialog(
						null, "Input width in number of robots (1-10)", "Width of Robots World",
						JOptionPane.QUESTION_MESSAGE);
				if (width == null)
					quit();
				setWidth(Integer.parseInt(width));
			}
			catch (NumberFormatException e) {
				JOptionPane
				.showMessageDialog(
						null,
						"You have input a number in the wrong range. Please try again.",
						"Wrong input", JOptionPane.WARNING_MESSAGE);
			}
		} while (get_Width() == null);
		_robotsWorld = new RobotsWorld( get_Height() / ROBOT_SIZE, get_Width() / ROBOT_SIZE); // Adding the robot world so it can be updated.
	}

	//Asking the user if he wants to quit. Happens if user doesn't input one of the parameters & clicks cancel.
	private static void quit() {
		int input = JOptionPane //if user wants to quit before inputing the height/width
				.showConfirmDialog(null,
						"Would you like to quit?",
						"Exit?",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (input == JOptionPane.YES_OPTION)
			System.exit(0);
	}

	//GETTERS
	static Integer get_Width() {
		return _width;
	}
	static Integer get_Height() {
		return _height;
	}

	//SETTERS
	//Setting width. Width can only be between 10 and 1 robots.
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


	//Setting height. Height can only be between 10 and 1 robots.
	private static void setHeight(Integer height) {
		if(height <= 0 || height > MAX_SIZE){
			JOptionPane
			.showMessageDialog(
					null,
					"You have input an incorrect height. Please restart if you don't like the result :).",
					"Wrong input", JOptionPane.WARNING_MESSAGE);
			_height = DEF_SIZE *  Main.ROBOT_SIZE;//height is set to 1 if input negative number or a number bigger than 10.
		}
		else  //height is multiplies so it can be translated to size of frame.
			_height = height * Main.ROBOT_SIZE;

	}

	/**
	 * My main. Here I initialize the frame and add a panel to it and show it.<br>
	 * Let the games begin.
	 * @param args
	 */
	public static void main(String[] args) {

		init();//init the world by getting the height and width of world (in robots)
		JFrame frame = new JFrame("Robot's World");//Creating the frame and adding a title.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//The program will exit on close.
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));//the setting of the layout of the panel on it relative to it.
		Integer frameWidth = get_Width() + FRAME_WIDTH;//setting it's width
		Integer frameHeight = get_Height() + BUTTON_HEIGHT + TITLE_HEIGHT;//setting it's height
		frame.setSize( frameWidth  > MIN_WIDTH ? frameWidth : MIN_WIDTH ,//checking out if not less than minimal width TODO
				frameHeight  > MIN_HEIGHT ? frameHeight : MIN_HEIGHT); //got to remember the button

		//All setting of "totalPanel" that includes the WorldPanel & ActionsPanel
		JPanel totalPanel = new JPanel(); // initializing the "totalPanel"
		totalPanel.setLayout(new BorderLayout());//setting it's layout
		_worldPanel = new WorldPanel();//creating a new static panel of type WorldPanel
		totalPanel.add(_worldPanel, BorderLayout.NORTH);//setting it's layout - in the upper part of the panel
		_actionsPanel = new ActionsPanel();//creating a new static panel of type ActionPanel
		totalPanel.add(_actionsPanel, BorderLayout.SOUTH);//setting it's layout - in the lower part of the panel
		frame.add(totalPanel);//adding this panel to the frame

		//Final touches
		frame.setLocationRelativeTo(null);//Locate it in the center
		frame.setResizable(true);//Can't resize the panel
		frame.setVisible(true);//Show the panel
	}
}
