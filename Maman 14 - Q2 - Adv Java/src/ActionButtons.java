

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ActionButtons extends JPanel implements MouseListener{

	private static final long serialVersionUID = 2893209635495576609L; //generated some serial

	private JButton _get;
	private JButton _set;
	
	private Date _date;
	private String _memoText;

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
		if (((JButton) e.getComponent()).getText().equals("Save"))
			if (checkDate())
			{
				_memoText = UI._textArea.getText();
				HandleFileMemo._hashtable.put(_date, _memoText); //initializing the hash table
			}

		if (((JButton) e.getComponent()).getText().equals("Display"))
			if (checkDate())
			{
				_memoText = HandleFileMemo._hashtable.get(_date);
				UI._textArea.setText(_memoText);
			}
	}

	private boolean checkDate() { //TODO add here validation of legal date, that gets from the DAte class
		if (DataInput.getDate() != null){
			_date = DataInput.getDate();
			return true;
		}
		else
			return false;
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
