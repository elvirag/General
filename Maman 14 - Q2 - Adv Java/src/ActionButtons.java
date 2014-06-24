import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This class is GUI mostly.
 * It is a JPanel with the combo box of the dates (DataInput) and also has
 * the save & display buttons that save the text and get it from the hash-table.
 */
public class ActionButtons extends JPanel implements MouseListener{

	private static final long serialVersionUID = 2893209635495576609L; //generated some serial

	private JButton _get; //the "Display" button
	private JButton _set; //the "Save" button
	private DataInput _dataInput; //The combo boxes from the DataInput class

	/**
	 * The constructor of this class.
	 * Adds the date combo boxes, adds the saving and displaying buttons,
	 * adds a tool tip for each and a mouse listener.
	 */
	public ActionButtons(){
		_dataInput = new DataInput();// Generating a new DataInput objects so there can be combo boxes.
		this.add(_dataInput); //adding to panel
		_set = new JButton("Save"); //creating the "Save" Button
		_set.setToolTipText("Saves the text to the chosen date.     Will overwrite the existing memo, if exists."); //Tool-tip
		this.add(_set); //adding it to panel
		_get = new JButton("Display");//creating the "Save" Button
		_get.setToolTipText("Displays the text from chosen date.   If empty, no memo was saved at this date."); //Tool-tip
		this.add(_get); //adding it to panel
		_set.addMouseListener(this); //adding the mouse listener to the button
		_get.addMouseListener(this); //adding the mouse listener to the button
	}

	/**
	 * If mouse clicks one of the buttons, determines which one and acts on it.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (((JButton) e.getComponent()).getText().equals("Save")) //if "Save" button is clicked
			if (_dataInput.getDate() != null) //Check if the user created a date object (if no "display" was clicked, there is no Date object yet.)
				HandleFileMemo._hashtable.put(_dataInput.getDate(), UI._textArea.getText()); //put the pair of date and text in the hash table

		if (((JButton) e.getComponent()).getText().equals("Display")) //if "Display" button is clicked
				//get the text saved in the specified date and displays it in the text area.
			if (_dataInput.getDate() != null) //Check if the user created a date object (if no "display" was clicked, there is no Date object yet.
				UI._textArea.setText( HandleFileMemo._hashtable.get(_dataInput.getDate()));
	}

	//Not used at all
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}
