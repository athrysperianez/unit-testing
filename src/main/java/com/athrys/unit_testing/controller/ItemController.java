package com.athrys.unit_testing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athrys.unit_testing.business.ItemService;
import com.athrys.unit_testing.model.Item;

@RestController
public class ItemController {

	@Autowired
	private ItemService bussinesService;

	@GetMapping("/dummy")
	public Item obtainDummy() {
		return new Item(1, "Ball", 10, 100);
	}

	@GetMapping("/item")
	public Item obtainItem() {
		return bussinesService.getItem();
	}

	@GetMapping("/all")
	public List<Item> abtainAll() {
		return bussinesService.getAll();
	}
}
