package main_ui; // two packages, just to train. Also, the keyboard hash is totally concealed from user.
import java.awt.BorderLayout;
import javax.swing.JPanel;
import KeyBoard.KeyBoardPanel;
import KeyBoard.TextArea;

/**
 * This class is only to do some order in the panels and not to clutter "Main"
 */
public class UI extends JPanel{

	private static final long serialVersionUID = 6626591741620618093L; //some serial

	public UI(){
		super();
		this.setLayout(new BorderLayout());// sets border layout for the two panels
		this.add(new TextArea(), BorderLayout.NORTH); //puts the text area up
		this.add(new KeyBoardPanel(), BorderLayout.SOUTH); // puts the keyboard below it
	}
}
