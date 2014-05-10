package KeyBoard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;

import main_ui.Main;

public class TextArea extends JTextArea implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6834033763543676790L;
	private static final int BORDER = 100;
	private static final int KEYBOARD_SIZE = 230;

	private KeyBoardHash _keyHash;

	public TextArea() {
		init();
	}

	private void init(){
		this.setPreferredSize(new Dimension(Main.FRAME_WIDTH - BORDER, Main.FRAME_HEIGHT - KEYBOARD_SIZE));
		this.setBackground(Color.LIGHT_GRAY);
		this.setToolTipText("Type here and the keys will change color accordingly."); //TODO
		addKeyListener(this);
		_keyHash = new KeyBoardHash();
	}

		@Override
		public void keyPressed(KeyEvent e) {
			for (KeyBoardButton button : KeyBoardButton._keyBoardButtons)
				if (_keyHash._keyhash.containsKey(e.getKeyCode()) && _keyHash.getString(e.getKeyCode()).equals(button.getKeyView())){
					button.setDifferentBackground();
			}
		}
	
		@Override
		public void keyReleased(KeyEvent e) {
			for (KeyBoardButton button : KeyBoardButton._keyBoardButtons)
				if (_keyHash._keyhash.containsKey(e.getKeyCode()) && _keyHash.getString(e.getKeyCode()).equals(button.getKeyView())){
					button.setBackground();
			}
		}


	@Override
	public void keyTyped(KeyEvent e) {/*does nothing TODO*/}

}
