package com.athrys.unit_testing.spike;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class HamcrestMatchersTest {

	@Test
	public void learning() {
		List<Integer> numbers = Arrays.asList(12, 15, 45);
		String veryImportantData = "Balatro Balatrez";

		assertThat(numbers, hasSize(3));
		assertThat(numbers, hasItems(12, 45));
		assertThat(numbers, everyItem(greaterThan(1)));
		assertThat(numbers, everyItem(lessThan(90)));

		assertThat(veryImportantData, startsWith("Ba"));
		assertThat(veryImportantData, endsWith("z"));
		assertThat(veryImportantData, not(endsWith("uwu")));
	}
}
