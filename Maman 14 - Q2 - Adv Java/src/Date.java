

/**
 * This is the class that defines the Dates.
 * It validates and sets to default if something is wrong.
 */
public class Date{
	//The days in a month, so we can control input of dates.
	private static final int[] _daysPerMonth = { 31, 28, 31, 30, 31, 30, 31,
		31, 30, 31, 30, 31 };
	private static final int MAX_YEAR = 2020; // Because I want it that way
	public static final int MIN_YEAR = 1970; // Historic reasons ;)
	public static final int YEAR_MULT = 10000; //this will be used in parsing dates and also handling them here
	public static final int MONTH_MULT = 100; //same as above
	
	private int _day; //the day field.
	private int _month; //the month field.
	private int _year; //the year filed.

	/**
	 * The constructor. operates by getting the year, the month and the the day that fits the month.
	 * Setters are used so date will be legal.
	 * @param day - the day the user inputs
	 * @param month - the month the user inputs
	 * @param year - the year the user inputs
	 */
	public Date(int day, int month, int year) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}

	/**
	 * Hashing the date for the hashtable.
	 */
	@Override
	public int hashCode(){
		return _day + _month * MONTH_MULT + _year * YEAR_MULT;
	}

	// GETTERS
	public int getDay(){return _day;}
	public int getMonth(){return _month;}
	public int getYear(){return _year;}

	// SETTERS
	private void setDay(int day){ //day has to be compatible with the month.
		if (day > 0 && day <= _daysPerMonth[getMonth() - 1]) //if the date is in the range of the month, set it.
			_day = day;
		else if (_month == 2 && day == 29 //else if it's a month with 29.2, set it.
				&& (_year % 400 == 0 || (_year % 4 == 0 && _year % 100 != 0))) //leap years and non leap years included.
			_day = day;
		else 
			_day = 1; //A legal one.
	}

	private void setMonth(int month){ //sets the month. Supposed to work here because there are no illegal options in box.
		if (month > 0 && month <= 12)
			_month = month;
		else //Not supposed to happen here, because of the combo box.
			_month = 1; //month is set to January
	}

	private void setYear(int year) { //sets the year
		if (year > MIN_YEAR && year <= MAX_YEAR)
			_year = year;
		else _year = MIN_YEAR;
	}

	
	/**
	 * Using the equals() method so we can use this class as a hash.
	 */
	@Override
	public boolean equals(Object obj) {
		if (getDay() == (((Date) obj).getDay()) &&
				getMonth() == (((Date) obj).getMonth()) &&
				getYear() == (((Date) obj).getYear()))
			return true; //if all parameters are equal, the dates are equal
		return false; //else, they aren't.
	}

	
	/**
	 * The toString method.
	 * Used so the file can be read by humans. Else it looks like Date@436dsfds
	 * There isn't a problem besides this.
	 */
	public String toString(){
		Integer date = _day + _month * MONTH_MULT + _year * YEAR_MULT; //Using our parsing/hashing formula...
		return date + ""; //Turns the date to a string
	}
}

