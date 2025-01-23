package com.athrys.unit_testing.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

	String response = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

	@Test
	public void jsonAssert() throws JSONException {
		String expectedResponse = "{\"id\":1, \"price\":10,\"quantity\":100}";

		JSONAssert.assertEquals(expectedResponse, response, false);
	}

	@Test
	public void jsonAssertStrict() throws JSONException {
		String expectedResponse = "{\"id\":1, \"name\": \"Ball\",\"price\":10,\"quantity\":100}";

		JSONAssert.assertEquals(expectedResponse, response, true);
	}

	@Test
	public void jsonAssertNoEscape() throws JSONException {
		String expectedResponse = "{id:1, name: Ball,price:10,quantity:100}";

		JSONAssert.assertEquals(expectedResponse, response, false);
	}
}
