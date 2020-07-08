package date_array;

public class DateArray {
	public static void main(String args[]) {
		MyDate[] dateArray = {
				new MyDate("May", 16, 1984),
				new MyDate("November", 14, 1978),
				new MyDate("September", 21, 1980),
				new MyDate("July", 3, 1987)			
		};
		for(int i = dateArray.length - 1; i >= 0; i--){
			System.out.println(dateArray[i].toString());
		}
	}
}
