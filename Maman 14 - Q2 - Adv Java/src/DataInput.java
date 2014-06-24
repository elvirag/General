import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 * the JPanel that controls the date buttons.
 * Chose to implement it not together with ActionButtons
 * so not to make a mess and make this class implement two interfaces,
 * although there is no problem with that.
 * Has three combo boxes that get their content from the user.
 * Sets the date that is used for the memos.
 */
public class DataInput extends JPanel implements ActionListener{

	private static final long serialVersionUID = 8186318871472318509L;//some generated serial

	JComboBox<Integer> _dayCombo; //the days JComboBox
	//Content of "days"
	private Integer[] _days = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
	JComboBox<Integer> _monthCombo; //the days JComboBox
	private Integer[] _months = {1,2,3,4,5,6,7,8,9,10,11,12}; //Content of "months"
	JComboBox<Integer> _yearCombo; //the days JComboBox
	private Integer[] _years = {1970,1971,1972,1973,1974,1975,1976,1977,1978,1979,
								1980,1981,1982,1983,1984,1985,1986,1987,1988,1989,
								1990,1991,1992,1993,1994,1995,1996,1997,1998,1999,
								2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,
								2010,2011,2012,2013,2014,2015,2016,2017,2018,2019,2020}; //Content of "years"

	private Integer day = 1; //the day that is in the combo-box - set to default values
	private Integer month = 1; //the month that is in the combo-box  - set to default values
	private Integer year = Date.MIN_YEAR; //the year that is in the combo-box  - set to default values


	/**
	 * The constructor of this class.
	 * It creates the JComboboxes, adds their action listeners, adds tool-tips and adds the to the panel.
	 */
	public DataInput(){
		_dayCombo = new JComboBox<>(_days); //Creating the days JComboBox and setting it's content
		_dayCombo.addActionListener(this); //Adding an action listener to it.
		_dayCombo.setToolTipText("Day"); //Tool-tip
		this.add(_dayCombo); //Adding it to the panel
		_monthCombo = new JComboBox<>(_months); //Creating the days JComboBox and setting it's content
		_monthCombo.addActionListener(this); //Adding an action listener to it.
		_monthCombo.setToolTipText("Month"); //Tool-tip
		this.add(_monthCombo); //Adding it to the panel
		_yearCombo = new JComboBox<>(_years); //Creating the days JComboBox and setting it's content
		_yearCombo.addActionListener(this); //Adding an action listener to it.
		_yearCombo.setToolTipText("Year"); //Tool-tip
		this.add(_yearCombo); //Adding it to the panel
	}

	
	/**
	 * This is the method actionPerformed().
	 * Gets the date from user, till date is whole.
	 */
	public void actionPerformed(ActionEvent e) {
		@SuppressWarnings("unchecked")//Saves the selected item.
		Integer comboInt = (Integer) ((JComboBox<Integer>) e.getSource()).getSelectedItem();
		if (e.getSource() == _dayCombo) //gets the day property
				day = comboInt; //saves it to the object relevant field
		if (e.getSource() == _monthCombo) //gets the day property
				month = comboInt; //saves it to the object relevant field
		if (e.getSource() == _yearCombo) //gets the day property
				year = comboInt; //saves it to the object relevant field
	}


	/**
	 * This creates a Date object from the information in the combo boxes.
	 * If one of the dates was set differently, it shows the date you actually going to save to,
	 * adjusting the combo boxes according to the actual Date object created.
	 * @return the real date that was set.
	 */
	public Date getDate(){
		Date _internalDate = new Date(day,month,year); //Creates the Date object using the parameters from the combo boxes
		_dayCombo.setSelectedIndex(_internalDate.getDay() - 1); //Sets the combo boxes to show this object
		_monthCombo.setSelectedIndex(_internalDate.getMonth() -1); //Sets the combo boxes to show this object
		_yearCombo.setSelectedIndex(_internalDate.getYear() - Date.MIN_YEAR); //Sets the combo boxes to show this object
		return _internalDate; //return the date.
	}
}
