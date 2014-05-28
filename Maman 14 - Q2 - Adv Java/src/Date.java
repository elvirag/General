

public class Date{

	private int _day;
	private int _month;
	private int _year;

	private static final int[] _daysPerMonth = { 31, 28, 31, 30, 31, 30, 31,
		31, 30, 31, 30, 31 };
	private static final int MAX_YEAR = 2083; // Because I want it that way
	private static final int MIN_YEAR = 1970; // Historic reasons ;)

	public Date(int day, int month, int year) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}


	@Override
	public int hashCode() {
		return _day + _month * 100 + _year * 10000;
	}

	// GETTERS
	public int getDay() {
		return _day;
	}

	public int getMonth() {
		return _month;
	}

	public int getYear() {
		return _year;
	}

	// SETTERS
	public void setDay(int day) {
		if (day > 0 && day <= _daysPerMonth[getMonth()])
			_day = day;
		else if (_month == 2 && day == 29
				&& (_year % 400 == 0 || (_year % 4 == 0 && _year % 100 != 0)))
			_day = day;
		else {
			System.out.println("Wrong day. Day set to 1");
			_day = 1;
		}
	}

	public void setMonth(int month) {
		if (month > 0 && month <= 12)
			_month = month;
		else {
			System.out.println("Wrong month. Month set to 1");
			_month = 1;
		}
	}

	public void setYear(int year) {
		if (year > MIN_YEAR && year <= MAX_YEAR)
			_year = year;
	}

	@Override
	public boolean equals(Object obj) {
		if (getDay() == (((Date) obj).getDay()) &&
				getMonth() == (((Date) obj).getMonth()) &&
				getYear() == (((Date) obj).getYear()))
			return true;
		return false;
	}

	public String toString(){
		Integer date = _day + _month * 100 + _year * 10000;
		return date + "";
	}

}

