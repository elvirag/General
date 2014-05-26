

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ActionButtons extends JPanel implements MouseListener{

	private static final long serialVersionUID = 2893209635495576609L; //generated some serial

	private JButton _get;
	private JButton _set;
	
	private Date _date;
	private String _memoText;
	public static HashMemo _hash;

	public ActionButtons(){
		this.add(new DataInput());
		_set = new JButton("Save");
		this.add(_set);
		_get = new JButton("Display");
		this.add(_get);
		_set.addMouseListener(this);
		_get.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (((JButton) e.getComponent()).getText().equals("Save")){
			System.out.println("Saving...");
			if (checkDate()){
				_memoText = UI._textArea.getText();
				System.out.println("The text on the textArea: " + _memoText);
				_hash.put(_date, _memoText);
			}
			
		}

		if (((JButton) e.getComponent()).getText().equals("Display")){
			System.out.println("Displaying...");
			if (checkDate()){
				System.out.println("date:" + _date);
				_memoText = _hash.get(_date);
				System.out.printf("\nThe text stored on the textArea in this date(%d.%d.%d): %s",_date.getDay(),_date.getMonth(),_date.getYear(), _memoText);
				UI._textArea.setText(_memoText);
			}
		}
	}

	private boolean checkDate() {
		_date = DataInput.getDate();
		return true;
	}

	//Not used at all
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}

}
