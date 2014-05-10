package KeyBoard;

import java.awt.Color;

import javax.swing.JTextArea;

public class TextArea extends JTextArea{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6834033763543676790L;
	JTextArea _textArea;
	public TextArea() {
		System.out.println("Inside of TextArea constructor!");
		init();
	}

	private void init(){
		_textArea = new JTextArea();
		_textArea.setBackground(Color.LIGHT_GRAY);
		_textArea.setToolTipText("Type here and the keys will change color accordingly."); //TODO
	}
}
