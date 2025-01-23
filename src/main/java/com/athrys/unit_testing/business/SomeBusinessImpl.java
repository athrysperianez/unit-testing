package com.athrys.unit_testing.business;

import java.util.Arrays;

import com.athrys.unit_testing.data.SomeDataService;

public class SomeBusinessImpl {

	private SomeDataService someDataService;

	public int calculateSum(int[] data) {
		return Arrays.stream(data).reduce(Integer::sum).orElse(0);
	}
	
	public int calculateSumUsingDataService() {
		int sum = 0;
		
		int[] data = someDataService.allData();
		
		for(int value:data) {
			sum+=value;
		}
		
		return sum;
	}

	public SomeDataService getSomeDataService() {
		return someDataService;
	}

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}
	
}
