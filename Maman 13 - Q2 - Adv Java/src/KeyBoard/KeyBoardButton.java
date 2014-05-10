package KeyBoard;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;


public class KeyBoardButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2067880388944921967L;
	static ArrayList<KeyBoardButton> _keyBoardButtons = new ArrayList<KeyBoardButton>();
	private  String _keyView;
	private Color _background = this.getBackground();
	private Color _changedBackground = Color.YELLOW;



	public KeyBoardButton(String keyView){
		super(keyView);
		_keyView = keyView;
		this.setBackground(_background);
		this.setToolTipText(_keyView);
		_keyBoardButtons.add(this);
	}

	protected String getKeyView() {
		return _keyView;
	}

	protected void setBackground(){
		this.setBackground(_background);
	}

	protected void setDifferentBackground(){
		this.setBackground(_changedBackground);
	}
}
