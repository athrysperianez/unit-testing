package com.athrys.unit_testing.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.athrys.unit_testing.data.SomeDataService;

public class SomeBusinessStubTest {

	class SomedataServiceStub implements SomeDataService {

		@Override
		public int[] allData() {
			return new int[] { 5, 5 };
		}

	}

	@Test
	public void calculateSumFromData() {
		SomeBusinessImpl business = new SomeBusinessImpl();

		business.setSomeDataService(new SomedataServiceStub());
		
		
		int actual = business.calculateSumUsingDataService();
		int expected = 10;

		assertEquals(actual, expected);
	}
}
