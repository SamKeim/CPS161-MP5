package one_dimensional_array;
import java.util.Scanner;

public class OneDimensionalArrays {
	int[] createIntegers(int size_of_array) {
		int[] returnArray = new int[size_of_array];
		for(int i = 0; i < size_of_array; i++) {
			returnArray[i] = Integer.parseInt(i + "00");
		}
		return returnArray;
	}

	void printArray(int[] myArray) {
		for(int i = 0; i < myArray.length; i++) {
			System.out.println(myArray[i]);
		}
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter size of array to create: ");
		int num = keyboard.nextInt();
		OneDimensionalArrays oda = new OneDimensionalArrays();
		int[] intArray = oda.createIntegers(num);
		oda.printArray(intArray);
		keyboard.close();
	}
}