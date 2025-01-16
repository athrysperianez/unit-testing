package com.athrys.unit_testing.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.athrys.unit_testing.data.SomeDataService;


@ExtendWith(SpringExtension.class)
public class SomeBusinessMockTest {

	@Mock
	private SomeDataService dataServiceMock;
	

	@InjectMocks
	private SomeBusinessImpl business = new SomeBusinessImpl();

	
	@BeforeEach
	public void before() {
		System.out.println("TESTING!");
	}
	
	@Test
	public void calculateSumFromData() {
		when(dataServiceMock.allData()).thenReturn(new int[] { 5, 5 });
		assertEquals(business.calculateSumUsingDataService(), 10);
	}
}
