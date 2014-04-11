import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This class the implements the panel.<br>
 * Repaints after the user has given an input to show the new added line.<br>
 */
public class MyPanel extends JPanel {

	private static final long serialVersionUID = 1L; // serial
	private static final int TITLE_SIZE = 20; // I need to add to the frame all the space that the title takes up
	private static final int NUM_DOTS = 10; //Number of dots on each line
	private static final int SPACE = 21;
	private ArrayList<Integer> lineArray = new ArrayList<Integer>();// the array list that holds all the line coordinates.
	private JFrame frame;


	/**
	 * Empty builder only to show the panel
	 */
	public MyPanel() {
		super();
	}

	/**
	 * The method that initializes the object.<br>
	 * and loops till it gets all points (if input is correct)<br>
	 * and the user wants to quit ("Cancel" or clicking the x will quit).
	 */
	public void init() {
		regFrame();
		while (true) {
			getPoint();
		}
	}

	/**
	 * Setting a new frame, setting it's size according to the dots parameters.<br>
	 * Adding our dot panel to the frame.
	 */
	public void regFrame() {
		frame = new JFrame("Testing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(NUM_DOTS * SPACE, NUM_DOTS * SPACE + TITLE_SIZE);
		frame.add(this);
		frame.setVisible(true);
	}

	/**
	 * The paintComponent.<br>
	 * Draws the dots and repaints the lineArray.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.BLACK);

		for (int i = 0; i <= NUM_DOTS * SPACE; i += SPACE)
			for (int j = 0; j <= NUM_DOTS * SPACE; j += SPACE) {
				g2.draw(new Ellipse2D.Double(i, j, 1, 1));
			}

		if (lineArray.size() > 1) {
			for (int i = 1; i < lineArray.size(); i++) {
				g2.drawLine(lineArray.get(i - 1) % 10 * SPACE,
						lineArray.get(i - 1) / 10 * SPACE,
						lineArray.get(i)% 10 * SPACE,
						lineArray.get(i) / 10 * SPACE);
			}
		}
	}

	/*
	 * Adds a line, if it's correct.
	 * If it's not correct, issues a message and
	 * pops back the dialogue of the coordinates question.
	 */
	private void addLine(Integer input) {
		if (input >= 0 && input <= 99) { // checking validity of input
			lineArray.add(input);
			repaint();
		} else { //tells if input is bigger than 99 or smaller than 0.
			JOptionPane
			.showMessageDialog(
					null,
					"You have input a number in the wrong range. Please try again.",
					"Wrong input", JOptionPane.WARNING_MESSAGE);
		}
	}

	/*
	 * Getting the coordinate from the user.
	 * Catches exceptions and also quits if user wants to quit.
	 */
	private void getPoint() {
		Object input = JOptionPane
				.showInputDialog("What is the coordinate you want to input?\n(0-99 only!\n");
		String str = (String) input;
		Integer integer = null;

		try {
			integer = Integer.parseInt(str);
		} catch (NumberFormatException nme) {
			if (str == null || str == "") {
				JOptionPane
				.showMessageDialog(
						null,
						"You have chosen to stop drawing lines.\nThank you for using my line painter!\n",
						"Bye - Bye!", JOptionPane.NO_OPTION);
				System.exit(0);
			} else
				JOptionPane
				.showMessageDialog(
						null,
						"You have input one or more characters that are not numbers. Please try again.",
						"Wrong input", JOptionPane.WARNING_MESSAGE);
		}

		if (integer != null) {
			addLine(integer);
		}

	}
}