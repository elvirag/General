package KeyBoard;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextArea;
import main_ui.Main;

/**
 * The class that is the main worker here.<br>
 * It compares the key typed to the text of the buttons<br>
 * and lights up the appropriate button.<br>
 *
 */
public class TextArea extends JTextArea implements KeyListener{

	private static final long serialVersionUID = -6834033763543676790L; //some serial
	//Placement of text area in the middle so it's prettier. 
	private static final int BORDER = 10; //If 0, all is too much to the left of the text area
	private static final int KEYBOARD_SIZE = 210; // the size of the keyboard so I can determine the size of the text area
	//looks like in the picture, right? I'm good with following instructions,
	//besides the handing assignments in good time frames. Sorrrrrry... :( At least my code is easily read.

	//My keyhash, referred here a lot
	private KeyBoardHash _keyHash;

	/**
	 * This is the constructor:<br>
	 * It sets size of the text area, sets tooltips and adds the listener.<br>
	 * also, initializes the hash.
	 */
	public TextArea(){
		//setting the size of the text area - according to constraints
		this.setPreferredSize(new Dimension(Main.FRAME_WIDTH - BORDER, Main.FRAME_HEIGHT - KEYBOARD_SIZE));
		//setting the tooltip
		this.setToolTipText("Type here and the keys will change color accordingly.");
		//adding the listener
		addKeyListener(this);
		//using the hash - very important
		_keyHash = new KeyBoardHash();
	}

	/**
	 * If finds the key pressed right now in hash table, changes background to yellow.
	 * @Override the action that is needed to be executed when key is pressed
	 */
	public void keyPressed(KeyEvent e) {
		for (KeyBoardButton button : KeyBoardButton._keyBoardButtons)
			if (_keyHash._keyhash.containsKey(e.getKeyCode()) && _keyHash.getString(e.getKeyCode()).equals(button.getKeyView()))
				button.setDifferentBackground();
	}

	/**
	 * If finds the key released right now in hash table, changes background back to silver.
	 * @Override the action that is needed to be executed when key is released
	 */
	public void keyReleased(KeyEvent e) {
		for (KeyBoardButton button : KeyBoardButton._keyBoardButtons)
			if (_keyHash._keyhash.containsKey(e.getKeyCode()) && _keyHash.getString(e.getKeyCode()).equals(button.getKeyView()))
				button.setBackground();
	}

	/**
	 * Does nothing. I don't need it.
	 */
	@Override
	public void keyTyped(KeyEvent e) {}
}
