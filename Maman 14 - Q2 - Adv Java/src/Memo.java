
public class Memo {

	private Date _date;
	private String _memoText;
	
	@Override
	public boolean equals(Object obj) {
		if (this._date.getDay() == (((Date) obj).getDay()) &&
			this._date.getMonth() == (((Date) obj).getMonth()) &&
			this._date.getYear() == (((Date) obj).getYear()))
				return true;
		return false;
	}
}
