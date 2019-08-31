package com.example.sisvetorapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sisvetorapi.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
