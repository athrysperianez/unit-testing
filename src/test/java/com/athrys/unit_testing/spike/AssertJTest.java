package com.athrys.unit_testing.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AssertJTest {

	@Test
	public void learning() {
		List<Integer> numbers = Arrays.asList(12, 16, 46);
		String veryImportantData = "Balatro Balatrez";

		assertThat(numbers).hasSize(3).contains(12, 46).allMatch(x -> x > 10).allMatch(x -> x % 2 == 0);
		assertThat(veryImportantData).isNotBlank().contains("Balatro").startsWith("B").endsWith("Z")
				.doesNotEndWith("A");
	}
}