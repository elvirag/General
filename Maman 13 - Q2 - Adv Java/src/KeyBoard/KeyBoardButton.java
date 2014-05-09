package KeyBoard;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;


public class KeyBoardButton extends JButton implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2067880388944921967L;
	private static Integer _keyValue;
	private static String _keyView;
	private Color _background = Color.RED;
	private Color _changedBackground = Color.YELLOW;
	
	
	
	public KeyBoardButton(Integer keyValue){
		super(setKeyView(setKeyValue(keyValue)));
		this.setBackground(_background);
		System.out.println("\nKey value of Button: " + getKeyValue() + "\nKey view of Button:" + getKeyView());
		this.setToolTipText(_keyView);
		this.addKeyListener(this);
		
	}

	private static String getKeyView() {
		return _keyView;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("The key was printed!!!");
		if (e.getKeyCode() == _keyValue)
			this.setBackground(_changedBackground);		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == _keyValue)
			this.setBackground(_background);	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	private static Integer setKeyValue(Integer keyValue) {
		if (new KeyBoardHash()._keyhash.containsKey(keyValue)){
			_keyValue = keyValue;
			return _keyValue;
		}
		else{
			System.out.println("There is no such Key\n"); //not supposed to happen, I type my own buttons.
			return null;
		}
	}
	
	private static String setKeyView(Integer keyValue) {
		if (new KeyBoardHash()._keyhash.containsKey(keyValue)){
			_keyView = new KeyBoardHash()._keyhash.get(_keyValue);
			return _keyView;
		}
		else System.out.println("There is no such String\n"); //not supposed to happen, I type my own buttons.
		return null;
	}
	
	private Integer getKeyValue() {
		return _keyValue;
	}
}
