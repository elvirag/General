import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.plaf.BorderUIResource;


public class UI extends JFrame{

	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 400;
	JFrame frame;

	JTextArea _textArea;

	KeyBoardHash _keyBoardHash;
	
	FlowLayout _layout = new FlowLayout();
	JPanel mainPanel = new JPanel(_layout);
	
	JPanel _line1 = new JPanel();
	JPanel _line2 = new JPanel();
	JPanel _line3 = new JPanel();
	JPanel _line4 = new JPanel();
	JPanel _line5 = new JPanel();
	
	public UI(){
		frame = new JFrame();
		
		frame.setLayout(new BorderLayout()); //TODO put it in main
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocationRelativeTo(null); // centered frame
		addText();
		frame.setVisible(true);
	}

	
	//TODO: put the setup of the frame in the main... call the method from the main.
	//TODO: (different : 
	private void addText(){
		_textArea = new JTextArea();
		_textArea.setBackground(Color.LIGHT_GRAY);
		_textArea.setToolTipText("Type here and the keys will change color accordingly."); //TODO

		mainPanel.add(_line1, FlowLayout.LEFT);
		mainPanel.add(_line2, FlowLayout.LEFT);
		mainPanel.add(_line3, FlowLayout.LEFT);
		mainPanel.add(_line4, FlowLayout.LEFT);
		mainPanel.add(_line5, FlowLayout.CENTER);
	
		
		frame.add(_textArea, BorderLayout.NORTH);
		frame.add(mainPanel, BorderLayout.SOUTH);
		
		setButtons();
	}

	private void setButtons(){
	JButton button1 = new JButton("Yo yo1!");
	_line1.add(button1);
	JButton button2 = new JButton("Yo yo2!");
	_line2.add(button2);
	JButton button3 = new JButton("Yo yo3!");
	_line3.add(button3);
	JButton button4 = new JButton("Yo yo!");
	_line4.add(button4);
	JButton button5 = new JButton("Yo yo!");
	_line5.add(button5);
	}
}
