package com.athrys.unit_testing.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.athrys.unit_testineg.data.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

	@Mock
	private SomeDataService dataServiceMock;
	

	@InjectMocks
	private SomeBusinessImpl business = new SomeBusinessImpl();

	
	@Before
	public void before() {
		System.out.println("TESTING!");
	}
	
	@Test
	public void calculateSumFromData() {
		when(dataServiceMock.allData()).thenReturn(new int[] { 5, 5 });
		assertEquals(business.calculateSumUsingDataService(), 10);
	}
}
