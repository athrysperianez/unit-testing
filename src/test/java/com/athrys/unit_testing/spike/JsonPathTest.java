package com.athrys.unit_testing.spike;

import static com.jayway.jsonpath.JsonPath.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;

public class JsonPathTest {

	@Test
	public void learning() {
		String data = "[" + "{\"id\":1000, \"name\":\"Pencil\", \"quantity\":5},"
				+ "{\"id\":1001, \"name\":\"Pencil\", \"quantity\":5},"
				+ "{\"id\":1002, \"name\":\"Pencil\", \"quantity\":5},"
				+ "{\"id\":1003, \"name\":\"Card Sharp\", \"quantity\":1000}" + "]";

		DocumentContext context = parse(data);
		int length = context.read("$.length()");
		List<Integer> ids = context.read("$..id");

		assertThat(length).isEqualTo(4);
		assertThat(ids).containsExactly(1000, 1001, 1002, 1003);

		System.out.println(context.read("$.[1]").toString());
		System.out.println(context.read("$.[0:1]").toString());
		System.out.println(context.read("$.[?(@.name=='Card Sharp')]").toString());
		System.out.println(context.read("$.[?(@.quantity==5)]").toString());

	}
}