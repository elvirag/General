
import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;


public class UI extends JFrame implements WindowListener{

	private static final long serialVersionUID = 9056339958174744779L; // some generated serial
	public static JTextArea _textArea;
	ActionButtons _actionButtons;
	HandleFileMemo _handle;

	private int TEXT_WIDTH = 10;
	private int TEXT_LENGHT = 20;



	public UI(){
		super("Memo Application");
		this.setLayout(new BorderLayout());

		_textArea = new JTextArea(TEXT_LENGHT, TEXT_WIDTH);
		this.add(_textArea,BorderLayout.NORTH);

		_actionButtons = new ActionButtons();
		this.add(_actionButtons, BorderLayout.SOUTH);
		
		this.addWindowListener(this);
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("Window has opened. Loading DB...");
		_handle = new HandleFileMemo();
		
	}
	
	
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("Window is being closed. Saving...");
		//TODO
		//All functions of saving here
		System.exit(0);
	}
	
	//Not used at all
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowClosed(WindowEvent e) {}

}
