package fractions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FractionsTest {
	@Test
	void test1() {
		Fraction f = new Fraction(1, 3);
		Fraction f2 = new Fraction(4, 6);
		assertEquals("1/1", f.add(f2).toString());
		assertFalse(f.equals(f2));
	}
	@Test
	void test2() {
		Fraction f = new Fraction(5, 25);
		Fraction f2 = new Fraction(10, 50);
		assertEquals("2/5", f.add(f2).toString());
		assertTrue(f.equals(f2));		
	}
	@Test
	void test3() {
		Fraction f = new Fraction(7, 30);
		Fraction f2 = new Fraction(11, 20);
		assertEquals("47/60", f.add(f2).toString());
		assertFalse(f.equals(f2));
	}
	@Test
	void test4() {
		Fraction f = new Fraction(11, 12);
		Fraction f2 = new Fraction(4, 5);
		assertEquals("7/60", f.subtract(f2).toString());
		assertFalse(f.equals(f2));
	}
	@Test
	void test5() {
		Fraction f = new Fraction(5, 6);
		Fraction f2 = new Fraction(1, 4);
		assertEquals("5/24", f.multiply(f2).toString());
		assertFalse(f.equals(f2));
	}
	@Test
	void test6() {
		Fraction f = new Fraction(6, 7);
		Fraction f2 = new Fraction(1, 12);
		assertEquals("72/7", f.divide(f2).toString());
		assertFalse(f.equals(f2));
	}
}
