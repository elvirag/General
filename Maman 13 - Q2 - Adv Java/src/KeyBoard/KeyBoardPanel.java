package KeyBoard;

import java.awt.FlowLayout;

import javax.swing.JPanel;

public class KeyBoardPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3165378284531156913L;

	FlowLayout _leftFlow = new FlowLayout(FlowLayout.LEFT);
	FlowLayout _centerFlow = new FlowLayout(FlowLayout.CENTER);
	
	JPanel _line1;
	JPanel _line2;
	JPanel _line3;
	JPanel _line4;
	JPanel _line5;
	
	JPanel _keyBoardPanel = new JPanel();
	
	public KeyBoardPanel() {
		_line1 = new JPanel(_leftFlow);
		_line2 = new JPanel(_leftFlow);
		_line3 = new JPanel(_leftFlow);
		_line4 = new JPanel(_leftFlow);
		_line5 = new JPanel(_centerFlow);
		
		_keyBoardPanel.add(_line1);
		_keyBoardPanel.add(_line2);
		_keyBoardPanel.add(_line3);
		_keyBoardPanel.add(_line4);
		_keyBoardPanel.add(_line5);
		
		setButtonsLine1();
		setButtonsLine2();
		setButtonsLine3();
		setButtonsLine4();
		setButtonsLine5();
		
	}
	
	private void setButtonsLine1(){
		KeyBoardButton buttonSix = new KeyBoardButton(54);
		_line1.add(buttonSix);
	}
	
	private void setButtonsLine2(){
		KeyBoardButton buttonEnter = new KeyBoardButton(10);
		_line2.add(buttonEnter);
	}
	
	private void setButtonsLine3(){
		KeyBoardButton buttonUp = new KeyBoardButton(38);
		_line3.add(buttonUp);
	}
	
	private void setButtonsLine4(){
		KeyBoardButton buttonY = new KeyBoardButton(89);
		_line4.add(buttonY);
	}
	
	private void setButtonsLine5(){
		KeyBoardButton buttonBackSpace = new KeyBoardButton(8);
		_line5.add(buttonBackSpace);
	}
	
}
