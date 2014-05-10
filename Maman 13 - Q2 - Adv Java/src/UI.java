import javax.swing.JFrame;
import javax.swing.JPanel;

import KeyBoard.KeyBoardPanel;
import KeyBoard.TextArea;


public class UI extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6626591741620618093L;
	JPanel _mainPanel = new JPanel();
	
	public UI(){
		System.out.println("Inside of UI constructor!");
		init();
	}

	public void init(){
		addTextArea();
		addKeyBoardPanel();
	}

	private void addTextArea() {
		_mainPanel.add(new TextArea());
	}

	private void addKeyBoardPanel(){
		_mainPanel.add(new KeyBoardPanel());
	}

}
