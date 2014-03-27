import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This class the implements the panel.<br>
 * Repaints after the user has given an input to show the new added line.<br>
 */

public class MyPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private ArrayList<Integer> lineArray = new ArrayList<Integer>();// the array list that holds all the line numbers

	public MyPanel(){
		super();
	} //empty builder only to show the panel

	Object input = JOptionPane.showInputDialog("What is the coordinate you want to input?\n(0-99 only!\n");
	String str = (String)input;
	Integer integer;

	try 
	{
		Integer.parseInt(str);
	}
	catch(NumberFormatException nme)
	{
		JOptionPane.showMessageDialog(null, "You have chosen to stop drawing lines.\nThank you for using my line painter!\n", "Bye - Bye!", JOptionPane.NO_OPTION);
	}

	if (input != null) //this is for the option that the user clicks cancel.
	{
		addLine(integer);
	}

	public void addLine(Integer point){
		if (point >= 0 && point <= 99)
		{
			lineArray.add(point);
			repaint();
		}

		else{
			JOptionPane.showMessageDialog(null, "You have input a number in the wrong range. Please try again.", "Wrong input", JOptionPane.WARNING_MESSAGE);
		}
	}
}
