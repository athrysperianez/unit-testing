package com.athrys.unit_testing.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athrys.unit_testing.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {}
