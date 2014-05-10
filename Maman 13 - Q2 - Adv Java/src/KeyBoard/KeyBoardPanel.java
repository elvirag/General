package KeyBoard;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
		
		this.setLayout(new GridLayout(6, 15));
		
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
		KeyBoardButton buttonTag = new KeyBoardButton("`");
		_line1.add(buttonTag);
		KeyBoardButton buttonOne = new KeyBoardButton("1");
		_line1.add(buttonOne);
		KeyBoardButton buttonTwo = new KeyBoardButton("2");
		_line1.add(buttonTwo);
		KeyBoardButton buttonThree = new KeyBoardButton("3");
		_line1.add(buttonThree);
		KeyBoardButton buttonFour = new KeyBoardButton("4");
		_line1.add(buttonFour);
		KeyBoardButton buttonFive = new KeyBoardButton("5");
		_line1.add(buttonFive);
		KeyBoardButton buttonSix = new KeyBoardButton("6");
		_line1.add(buttonSix);
		KeyBoardButton buttonSeven = new KeyBoardButton("7");
		_line1.add(buttonSeven);
		KeyBoardButton buttonEight = new KeyBoardButton("8");
		_line1.add(buttonEight);
		KeyBoardButton buttonNine = new KeyBoardButton("9");
		_line1.add(buttonNine);
		KeyBoardButton buttonZero = new KeyBoardButton("0");
		_line1.add(buttonZero);
		KeyBoardButton buttonMinus = new KeyBoardButton("-");
		_line1.add(buttonMinus);
		KeyBoardButton buttonPlus = new KeyBoardButton("+");
		_line1.add(buttonPlus);
		KeyBoardButton buttonBackSpace = new KeyBoardButton("BackSpace");
		_line1.add(buttonBackSpace);	
	}
	
	private void setButtonsLine2(){
		KeyBoardButton buttonTab = new KeyBoardButton("Tab");
		_line2.add(buttonTab);
		KeyBoardButton buttonQ = new KeyBoardButton("Q");
		_line2.add(buttonQ);
		KeyBoardButton buttonW = new KeyBoardButton("W");
		_line2.add(buttonW);
		KeyBoardButton buttonE = new KeyBoardButton("E");
		_line2.add(buttonE);
		KeyBoardButton buttonR = new KeyBoardButton("R");
		_line2.add(buttonR);
		KeyBoardButton buttonT = new KeyBoardButton("T");
		_line2.add(buttonT);
		KeyBoardButton buttonY = new KeyBoardButton("Y");
		_line2.add(buttonY);
		KeyBoardButton buttonU = new KeyBoardButton("U");
		_line2.add(buttonU);
		KeyBoardButton buttonI = new KeyBoardButton("I");
		_line2.add(buttonI);
		KeyBoardButton buttonO = new KeyBoardButton("O");
		_line2.add(buttonO);
		KeyBoardButton buttonP = new KeyBoardButton("P");
		_line2.add(buttonP);
		KeyBoardButton buttonOpen = new KeyBoardButton("[");
		_line2.add(buttonOpen);
		KeyBoardButton buttonClose = new KeyBoardButton("]");
		_line2.add(buttonClose);
		KeyBoardButton buttonSlash1 = new KeyBoardButton("\\");
		_line2.add(buttonSlash1);	
	}
	
	private void setButtonsLine3(){
		KeyBoardButton buttonCaps = new KeyBoardButton("Caps");
		_line3.add(buttonCaps);
		KeyBoardButton buttonA = new KeyBoardButton("A");
		_line3.add(buttonA);
		KeyBoardButton buttonS = new KeyBoardButton("S");
		_line3.add(buttonS);
		KeyBoardButton buttonD = new KeyBoardButton("D");
		_line3.add(buttonD);
		KeyBoardButton buttonF = new KeyBoardButton("F");
		_line3.add(buttonF);
		KeyBoardButton buttonG = new KeyBoardButton("G");
		_line3.add(buttonG);
		KeyBoardButton buttonH = new KeyBoardButton("H");
		_line3.add(buttonH);
		KeyBoardButton buttonJ = new KeyBoardButton("J");
		_line3.add(buttonJ);
		KeyBoardButton buttonK = new KeyBoardButton("K");
		_line3.add(buttonK);
		KeyBoardButton buttonL = new KeyBoardButton("L");
		_line3.add(buttonL);
		KeyBoardButton buttontwodots = new KeyBoardButton(":");
		_line3.add(buttontwodots);
		KeyBoardButton buttonSlash2 = new KeyBoardButton("\\");
		_line3.add(buttonSlash2);
		KeyBoardButton buttonEnter = new KeyBoardButton("Enter");
		_line3.add(buttonEnter);
		}
	
	private void setButtonsLine4(){
		KeyBoardButton buttonShift = new KeyBoardButton("Shift");
		_line4.add(buttonShift);
		KeyBoardButton buttonZ = new KeyBoardButton("Z");
		_line4.add(buttonZ);
		KeyBoardButton buttonX = new KeyBoardButton("X");
		_line4.add(buttonX);
		KeyBoardButton buttonC = new KeyBoardButton("C");
		_line4.add(buttonC);
		KeyBoardButton buttonV = new KeyBoardButton("V");
		_line4.add(buttonV);
		KeyBoardButton buttonB = new KeyBoardButton("B");
		_line4.add(buttonB);
		KeyBoardButton buttonN = new KeyBoardButton("N");
		_line4.add(buttonN);
		KeyBoardButton buttonM = new KeyBoardButton("M");
		_line4.add(buttonM);
		KeyBoardButton buttonComma1 = new KeyBoardButton(",");
		_line4.add(buttonComma1);
		KeyBoardButton buttonDot = new KeyBoardButton(".");
		_line4.add(buttonDot);
		KeyBoardButton buttonQuestion = new KeyBoardButton("?");
		_line4.add(buttonQuestion);
		KeyBoardButton buttonUp = new KeyBoardButton("^");
		_line4.add(buttonUp);
		}
	
	private void setButtonsLine5(){
		KeyBoardButton buttonSpace = new KeyBoardButton("                                                                                                          ");
		_line5.add(buttonSpace);
		KeyBoardButton buttonComma2 = new KeyBoardButton(",");
		_line5.add(buttonComma2);
		KeyBoardButton buttonLeft = new KeyBoardButton("<");
		_line5.add(buttonLeft);
		KeyBoardButton buttonDown = new KeyBoardButton("v");
		_line5.add(buttonDown);
		KeyBoardButton buttonRight = new KeyBoardButton(">");
		_line5.add(buttonRight);
	}
	
}
