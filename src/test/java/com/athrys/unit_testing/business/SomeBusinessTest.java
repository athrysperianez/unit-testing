package com.athrys.unit_testing.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SomeBusinessTest {

	@Test
	public void calculateSumBasic() {
		SomeBusinessImpl business = new SomeBusinessImpl();

		int actual = business.calculateSum(new int[] { 1, 2, 3 });
		int expected = 6;

		assertEquals(actual, expected);
	}

	@Test
	public void calculateSumEmpty() {
		SomeBusinessImpl business = new SomeBusinessImpl();

		int actual = business.calculateSum(new int[] {});
		int expected = 0;

		assertEquals(actual, expected);
	}

	@Test
	public void calculateSumOneVal() {
		SomeBusinessImpl business = new SomeBusinessImpl();

		int actual = business.calculateSum(new int[] { 5 });
		int expected = 5;

		assertEquals(actual, expected);
	}

	@Test
	public void calculateSumFromData() {
		SomeBusinessImpl business = new SomeBusinessImpl();

		assertNotEquals(business.calculateSumUsingDataService(), 0);
	}
}
