package string_array;

public class Application {

	
	public static void main(String args[]) {
		String[] firstNames = {"George", "Fred", "Sam", "Mary", "Sarah", "Bella", "Joy", "Rita", "Marta", "Sue", "Nancy"};
		for(int i = firstNames.length - 1; i >= 0; i--) {
			System.out.print(firstNames[i] + " ");
		}
	}
}
