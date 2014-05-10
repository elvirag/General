package main_ui;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import KeyBoard.KeyBoardPanel;
import KeyBoard.TextArea;


public class UI extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6626591741620618093L;
	
	TextArea _textArea;
	KeyBoardPanel _keyBoardPanel;
	BorderLayout _layout = new BorderLayout();
	
	public UI(){
		super();
		_textArea = new TextArea();
		_keyBoardPanel = new KeyBoardPanel();
		init();
	}

	public void init(){
		this.setLayout(_layout);
		addTextArea();
		addKeyBoardPanel();
		this.setVisible(true);
	}

	private void addTextArea() {
		this.add(_textArea, BorderLayout.NORTH);
	}

	private void addKeyBoardPanel(){
		this.add(_keyBoardPanel, BorderLayout.SOUTH);
	}

}
