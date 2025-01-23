package com.athrys.unit_testing.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.athrys.unit_testing.business.ItemService;
import com.athrys.unit_testing.model.Item;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private ItemService itemService;

	@Test
	public void basicHello() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/dummy").accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{ \"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"));

		mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().json(" {\"price\":10}"));
	}

	@Test
	public void mockService() throws Exception {

		when(itemService.getItem()).thenReturn(new Item(2, "Item", 10, 10));
		RequestBuilder request = MockMvcRequestBuilders.get("/item").accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{ id:2,name:Item,price:10,quantity:10}"));

	}
}
