import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;


public class DataInput extends JPanel implements ActionListener{

	private static final long serialVersionUID = 8186318871472318509L;//some generated serial

	JComboBox<Integer> _day;
	private Integer[] _days = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
	JComboBox<Integer> _month;
	private Integer[] _months = {0,1,2,3,4,5,6,7,8,9,10,11,12};
	JComboBox<Integer> _year;
	private Integer[] _years = {0,1983,2010,2011,2012,2013,2014,2015,2016,2017,2018,2019,2020};

	private static Integer day = 0;

	private static Integer month = 0;

	private static Integer year = 0;
	private static Date _internalDate;

	public DataInput(){
		_day = new JComboBox<>(_days);
		_day.addActionListener(this);
		this.add(_day);
		_month = new JComboBox<>(_months);
		_month.addActionListener(this);
		this.add(_month);
		_year = new JComboBox<>(_years);
		_year.addActionListener(this);
		this.add(_year);	
	}

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e) {
		do{
			if (e.getSource() instanceof JComboBox<?>){
				if (e.getSource() == _day)
					day = (Integer) ((JComboBox<Integer>) e.getSource()).getSelectedItem();
				if (e.getSource() == _month)
					month = (Integer) ((JComboBox<Integer>) e.getSource()).getSelectedItem();
				if (e.getSource() == _year)
					year = (Integer) ((JComboBox<Integer>) e.getSource()).getSelectedItem();
			}
		}while (day == 0 && month == 0 && year == 0);
	}
	
	public static Date getDate(){
		_internalDate = new Date(day,month,year);
		System.out.println("final day:" + _internalDate.getDay());
		System.out.println("final month: " + _internalDate.getMonth());
		System.out.println("final year: " + _internalDate.getYear());
		return _internalDate;
	}

}
