package com.example.sisvetorapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sisvetorapi.model.SubItem;

public interface SubItemRepository extends JpaRepository<SubItem, Long> {
	List<SubItem> findAllByOrderByNomeAsc();
	
	List<SubItem> findByNomeContainingIgnoreCase(String nome);
}
