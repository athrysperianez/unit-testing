package com.athrys.unit_testing.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.athrys.unit_testing.data.ItemRepository;
import com.athrys.unit_testing.model.Item;

@ExtendWith(SpringExtension.class)
public class ItemBusinessTest {

	@Mock
	private ItemRepository repository;

	@InjectMocks
	private ItemService business;

	@BeforeEach
	public void before() {
		System.out.println("TESTING!");
	}

	@Test
	public void calculateSumFromData() {
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(2, "Test", 10, 20),
				new Item(24, "Test2", 12, 2123123), new Item(909, "Test3", 1, 1)));

		List<Item> items = business.getAll();

		assertEquals(200, items.get(0).getValue());
	}
}
