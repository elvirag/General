

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ActionButtons extends JPanel implements MouseListener{

	private static final long serialVersionUID = 2893209635495576609L; //generated some serial

	JComboBox<Integer> _day;
	private Integer[] _days = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
	JComboBox<Integer> _month;
	private Integer[] _months = {0,1,2,3,4,5,6,7,8,9,10,11,12};
	JComboBox<Integer> _year;
	private Integer[] _years = {0,2010,2011,2012,2013,2014,2015,2016,2017,2018,2019,2020};
	private JButton _get;
	private JButton _set;

	public ActionButtons(){
		_day = new JComboBox<>(_days);
		this.add(_day);
		_month = new JComboBox<>(_months);
		this.add(_month);
		_year = new JComboBox<>(_years);
		this.add(_year);

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
		}

		if (((JButton) e.getComponent()).getText().equals("Display")){
			System.out.println("Displaying...");
		}
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
