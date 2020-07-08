package fractions;

import java.util.*;

public class Fraction {
	private Scanner scan = new Scanner(System.in);
	private int num = 1;
	private int denom = 1;

	public Fraction() {
	}

	public Fraction(int n, int d) {
		super();
		setFraction(n, d);
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getDenom() {
		return denom;
	}

	public void setDenom(int denom) {
		this.denom = denom;
	}

	public void setFraction(int n, int d) {
		this.num = n;
		this.denom = d;
		reduce();
		// Fill in code ... don't forget to reduce
	}

	public Fraction add(Fraction op) {
		// Fill in code ... don't forget to reduce
		// Algebra HINT: a/b + c/d = (a*d + b*c)/(b*d)
		return new Fraction(
				(this.num * op.getDenom() + this.denom * op.getNum()),
				(this.denom * op.getDenom())
				);
	}

	public Fraction subtract(Fraction op) {
		// Fill in code ... don't forget to reduce
		// Algebra HINT: a/b - c/d = (a*d - b*c)/(b*d)
		return new Fraction(
				(this.num * op.getDenom() - this.denom * op.getNum()),
				(this.denom * op.getDenom())
				);
	}

	public Fraction multiply(Fraction op) {
		// Fill in code ... don't forget to reduce
		// Algebra HINT: a/b * c/d = (a*c)/ (b*d)
		return new Fraction(
				(this.num * op.getNum()),
				(this.denom * op.getDenom())
				);
	}

	public Fraction divide(Fraction op) {
		// Fill in code ... don't forget to reduce
		// Algebra HINT: a/b / c/d = (a*d)/ (b*c)
		return new Fraction(
				(this.num * op.getDenom()),
				(this.denom * op.getNum())
				);
	}

	private void reduce() {
		// Pseudo code:
		// set smaller = minimum ( abs(num), abs(denom));
		// Loop through the possible divisors: 2, 3, 4, ... smaller
		// For each possible divisor:
		// while (num and denom are evenly divisible by divisor)
		// {
		// num /= divisor;
		// denom /= divisor;
		// smaller /= divisor;
		// }
		
		int smaller = Math.min(Math.abs(num), Math.abs(denom));
		for(int d = 2; d <= smaller; d++) {
			while(num % d == 0 && denom % d == 0) {
				num /= d;
				denom /= d;
				smaller /= d;
			}
		}
	}

	public boolean equals(Fraction f) {
		// Assuming all fractions are reduced. Fill in code
		return this.num == f.getNum() && this.denom == f.getDenom();
	}

	public String toString() {
		// Fill in code
		return this.num + "/" + this.denom;
	}

	public void readin(String label) {
		while (true) // Keep trying if bad input is received
		{
			System.out.print(label);
			String temp = scan.next();
			temp = temp.trim(); // get rid of white space at the beginning and end
			int index = temp.indexOf('/');
			if (index >= 0) {
				String numStr = temp.substring(0, index);
				String denomStr = temp.substring(index + 1);
				int n = Integer.parseInt(numStr);
				int d = Integer.parseInt(denomStr);
				setFraction(n, d);
				return;
			} else
				System.out.println("Input Fraction missing / ");
		} // Keep trying until you get it right
	}

	public static void main(String[] args) {
		Fraction f1 = new Fraction();
		Fraction f2 = new Fraction();
		Fraction f3 = null;
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println(); // Add a blank line
			System.out.print("Enter operation: + - * / q (q ==> quit) : ");
			String input = scan.next();
			if (input.charAt(0) == 'q')
				break; // All done

			f1.readin("Enter Fraction 1: ");
			f2.readin("Enter Fraction 2: ");
			System.out.println("f1 = " + f1);
			System.out.println("f2 = " + f2);

			if (f1.equals(f2))
				System.out.println("f1 and f2 are equal");
			else
				System.out.println("f1 and f2 are not equal");

			switch (input.charAt(0)) {
			case '+':
				f3 = f1.add(f2);
				System.out.println("f1+f2=" + f3);
				break;
			case '-':
				f3 = f1.subtract(f2);
				System.out.println("f1-f2=" + f3);
				break;
			case '*':
				f3 = f1.multiply(f2);
				System.out.println("f1*f2=" + f3);
				break;
			case '/':
				f3 = f1.divide(f2);
				System.out.println("f1/f2=" + f3);
				break;
			default:
				System.out.println("Illegal command: " + input);
				break;
			}
		} // end of while loop
		System.out.println("Bye");
		scan.close();

	} // end of main
}