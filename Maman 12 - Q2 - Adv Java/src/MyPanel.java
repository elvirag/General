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

	private static final long serialVersionUID = 1L;
	private static final int TITLE_SIZE = 20;
	private static final int NUM_DOTS = 10;
	private static final int SPACE = 19;
	private ArrayList<Integer> lineArray = new ArrayList<Integer>();// the array list that holds all the line numbers
	
	
	
	private JFrame frame;

	public MyPanel() {
		super();
	} // empty builder only to show the panel

	public void init() {
		regFrame();
		while(true){
			getPoint();
		}

	}

	public void regFrame() {
		frame = new JFrame("Testing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(NUM_DOTS * SPACE, NUM_DOTS * SPACE + TITLE_SIZE);
		frame.add(this);
		frame.setVisible(true);
	}

	public void paintComponent(Graphics g) {
		// RecoverGraphics2D
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.BLACK);

		// Ellipse2D.Double is an inner class of Ellipse2D.
		for (int i = 0; i <= NUM_DOTS * SPACE; i += SPACE)
			for (int j = 0; j <= NUM_DOTS * SPACE; j += SPACE) {
				g2.draw(new Ellipse2D.Double(i, j, 1, 1));
			}
		
		if (lineArray.size() > 1) {
			for (int i = 1; i < lineArray.size(); i++) {
				g2.drawLine(lineArray.get(i - 1)/10 * SPACE,
						lineArray.get(i - 1) % 10 *SPACE, lineArray.get(i) / 10 * SPACE,
						lineArray.get(i) % 10 * SPACE);
			}
		}

	}

	private void addLine(Integer input) {
		if (input >= 0 && input <= 99)
		{
			lineArray.add(input);
				//frame.repaint();
				repaint();
		}
		else{
			JOptionPane.showMessageDialog(null,
					"You have input a number in the wrong range. Please try again.",
					"Wrong input", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void getPoint(){
		Object input = JOptionPane.showInputDialog("What is the coordinate you want to input?\n(0-99 only!\n");
		String str = (String)input;
		Integer integer = null;

		try
		{
			integer = Integer.parseInt(str);
		}
		catch(NumberFormatException nme)
		{
			JOptionPane.showMessageDialog(null,
					"You have chosen to stop drawing lines.\nThank you for using my line painter!\n",
					"Bye - Bye!", JOptionPane.NO_OPTION);
		}

		if (input != null) //this is for the option that the user clicks cancel.
		{
			addLine(integer);
		}

	}
}