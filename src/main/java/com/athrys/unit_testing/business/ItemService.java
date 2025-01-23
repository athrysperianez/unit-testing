package com.athrys.unit_testing.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.athrys.unit_testing.data.ItemRepository;
import com.athrys.unit_testing.model.Item;

@Component
public class ItemService {

	@Autowired
	private ItemRepository repository;

	public Item getItem() {
		return new Item(1, "Ball", 10, 100);
	}

	public List<Item> getAll() {
		List<Item> result = repository.findAll();
		
		result.forEach(current -> {
			current.setValue(current.getQuantity() * current.getPrice());
		});
		
		return result;
	}
}
