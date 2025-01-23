package com.athrys.unit_testing.data;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.athrys.unit_testing.model.Item;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ItemRepositoryTest {

	@Autowired
	private ItemRepository repository;

	@Test
	public void findA() {
		List<Item> data = repository.findAll();

		assert (data.size() > 2);
	}

}
