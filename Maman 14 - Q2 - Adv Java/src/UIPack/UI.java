package UIPack;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class UI extends JFrame{

	private static final long serialVersionUID = 9056339958174744779L; // some generated serial
	JTextArea _textArea;
	ActionButtons _actionButtons;

	private int TEXT_WIDTH = 10;
	private int TEXT_LENGHT = 20;



	public UI(){
		super("Memo Application");

		this.setLayout(new BorderLayout());

		_textArea = new JTextArea(TEXT_LENGHT, TEXT_WIDTH);
		this.add(_textArea,BorderLayout.NORTH);

		_actionButtons = new ActionButtons();
		this.add(_actionButtons, BorderLayout.SOUTH);
	}
}
