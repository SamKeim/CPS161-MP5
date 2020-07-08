package date_array;

public class MyDate {
	String month;
	int day;
	int year;
	
	public MyDate(String month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	@Override
	public String toString() {
		return String.format("%s %d, %d", month, day, year);
	}
	
}