package com.example.sisvetorapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sisvetorapi.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	List<Item> findByNomeContainingIgnoreCase(String nome);

}
