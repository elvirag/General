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
	private Integer _keyValue;
	private  String _keyView;
	private Color _background = this.getBackground();
	private Color _changedBackground = Color.YELLOW;
	private KeyBoardHash _keyHash;
	
	
	public KeyBoardButton(Integer keyValue){
		super();
		_keyHash = new KeyBoardHash();
		setKeyValue(keyValue);
		setKeyView(keyValue);
		setText(_keyView);
		setBackground(_background);
		System.out.println("\nKey value of Button: " + getKeyValue() + "\nKey view of Button:" + getKeyView());
		setToolTipText(_keyView);
		addKeyListener(this);
		
	}

	private String getKeyView() {
		return _keyView;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.printf("\nKey Code pressed: %d  Key Value: %d Key View: %s", e.getKeyCode(), _keyValue, _keyValue);
		if (e.getKeyCode() == _keyValue){
			setBackground(_changedBackground);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.printf("\nKey Code released: %d  Key Value: %d", e.getKeyCode(), _keyValue);
		if (e.getKeyCode() == _keyValue){
			setBackground(_background);
		}	
	}

	@Override
	public void keyTyped(KeyEvent e) {/*does nothing TODO*/}

	private Integer setKeyValue(Integer keyValue) {
		if (_keyHash._keyhash.containsKey(keyValue)){
			_keyValue = keyValue;
			return _keyValue;
		}
		else{
			System.out.println("There is no such Key\n"); //not supposed to happen, I type my own buttons.
			return null;
		}
	}
	
	private String setKeyView(Integer keyValue) {
		if (_keyHash._keyhash.containsKey(keyValue)){
			_keyView = _keyHash._keyhash.get(_keyValue);
			return _keyView;
		}
		else System.out.println("There is no such String\n"); //not supposed to happen, I type my own buttons.
		return null;
	}
	
	private Integer getKeyValue() {
		return _keyValue;
	}
}
