package KeyBoard;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 * 
 * @author Elvira
 *
 */
class KeyBoardButton extends JButton{

	private static final long serialVersionUID = -2067880388944921967L; //some serial
	// the array that saves all the keyboard buttons so we can compare them to the hashmap
	static ArrayList<KeyBoardButton> _keyBoardButtons = new ArrayList<KeyBoardButton>();
	private  String _keyView; // the String on the key
	private Color _background = this.getBackground(); // Old background for restoring color
	private Color _changedBackground = Color.YELLOW; //Changed Background for typed buttons


	//Constructor for this class: sets text, sets tooltip, saves string
	//and adds to the arraylist of the keyboard all the buttons can access
	protected KeyBoardButton(String keyView){
		super(keyView); // setting text
		_keyView = keyView; //saving as an internal field
		this.setToolTipText(_keyView); //setting tooltip
		_keyBoardButtons.add(this); //adding to arraylist
	}

	protected String getKeyView() { //gets key view
		return _keyView;
	}

	protected void setBackground(){ //sets regular background
		this.setBackground(_background);
	}

	protected void setDifferentBackground(){ //sets different background
		this.setBackground(_changedBackground);
	}
}
