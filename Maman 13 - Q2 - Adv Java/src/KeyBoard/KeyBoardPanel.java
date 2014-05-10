package KeyBoard;

import java.awt.FlowLayout;
import java.util.ArrayList;

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
	
	public KeyBoardPanel() {
		_line1 = new JPanel(_leftFlow);
		_line2 = new JPanel(_leftFlow);
		_line3 = new JPanel(_leftFlow);
		_line4 = new JPanel(_leftFlow);
		_line5 = new JPanel(_centerFlow);
		
		this.add(_line1);
		this.add(_line2);
		this.add(_line3);
		this.add(_line4);
		this.add(_line5);
		
		setButtonsLine1();
		setButtonsLine2();
		setButtonsLine3();
		setButtonsLine4();
		setButtonsLine5();
		
	}
	
	private void setButtonsLine1(){
		KeyBoardButton buttonSix = new KeyBoardButton("6");
		_line1.add(buttonSix);
	}
	
	private void setButtonsLine2(){
		KeyBoardButton buttonEnter = new KeyBoardButton("Enter");
		_line2.add(buttonEnter);
	}
	
	private void setButtonsLine3(){
		KeyBoardButton buttonUp = new KeyBoardButton("^");
		_line3.add(buttonUp);
	}
	
	private void setButtonsLine4(){
		KeyBoardButton buttonY = new KeyBoardButton("Y");
		_line4.add(buttonY);
	}
	
	private void setButtonsLine5(){
		KeyBoardButton buttonBackSpace = new KeyBoardButton("BackSpace");
		_line5.add(buttonBackSpace);
	}
	
}
