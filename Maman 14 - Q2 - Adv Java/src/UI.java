
import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * The class the implements the window-listener
 * so the saving and retrieving of the data 
 * that was/is in the hash table can be performed.
 */
public class UI extends JFrame implements WindowListener{

	private static final long serialVersionUID = 9056339958174744779L; // some generated serial
	private static final int TEXT_ROW = 20; //rows in text Area
	private static final int TEXT_COL = 10; //columns in Text Area

	private HandleFileMemo _handle; //The window handler
	protected static JTextArea _textArea; //the text area field, so Actionbuttons can use it

	
	/**
	 * 
	 */
	public UI(){
		super("Memo Application"); //Creates a frame
		this.setLayout(new BorderLayout()); //sets layout
		_textArea = new JTextArea(TEXT_ROW, TEXT_COL); //creates the field _textArea
		this.add(_textArea,BorderLayout.NORTH); //puts it on the upper part of the frame
		this.add(new ActionButtons(), BorderLayout.SOUTH); //puts new ActionButtons on the lower part of the frame
		this.addWindowListener(this); //adds the window listener
	}

	
	/**
	 * the action taken the the window is opened.
	 * Handled by the handler from the class HandleFileMemo
	 */
	@Override
	public void windowOpened(WindowEvent e) {
		_handle = new HandleFileMemo(); //Just create the object, the rest is made by the objects constructor.
	}
	
	/**
	 * The action taken when closing the window.
	 * Handled by the method closeFile from the class HandleFileMemo
	 * If an exception is thrown by it, it is handled here.
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		try {
			_handle.closeFile(); //the method is used to close the file and to save all info to it first.
		} catch (IOException e1) { //if exception is caught from the method...
			JOptionPane.showConfirmDialog(null, "There was a problem saving the file.\nIt didn't close properly.", "Error", JOptionPane.ERROR_MESSAGE);//If an exception is throw, handled.
			e1.printStackTrace();
			System.exit(1); //Exit with error status
		}
		System.exit(0); //The only exit with proper exit status
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
