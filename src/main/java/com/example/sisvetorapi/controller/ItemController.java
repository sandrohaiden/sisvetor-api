package com.example.sisvetorapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sisvetorapi.model.Item;
import com.example.sisvetorapi.model.SubItem;
import com.example.sisvetorapi.repository.ItemRepository;
import com.example.sisvetorapi.exception.ResourceNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ItemController {
	
	@Autowired
	ItemRepository itemRepository;
	
	@GetMapping("/itens")
	public List<Item> getAllItens(){
		return itemRepository.findAll();
	}
	
	@GetMapping("/itens/search")
	public List<Item> getByNome(@RequestParam("nome") String nome){
		return itemRepository.findByNomeContainingIgnoreCase(nome);
	}
	
	
	@PostMapping("/itens")
	public Item adicionarItem(@Valid @RequestBody Item item) {
		return itemRepository.save(item);
	}
	
	@GetMapping("/itens/{id}")
	public Item getItem(@PathVariable(value = "id") Long id) {
		return itemRepository.findById(id)
				.orElseThrow(() ->  new ResourceNotFoundException("Item", "id", id));
	}
	
	@PutMapping("itens/{id}")
	public Item updateItem(@PathVariable(value = "id") Long id, @Valid @RequestBody Item newItem) {
		Item item = itemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item", "id", id));
		newItem.setId(id);
		return itemRepository.save(newItem);
	}
	
	@DeleteMapping("itens/{id}")
	public ResponseEntity<?> deleteSubItem(@PathVariable(value = "id") Long id) {
		Item item = itemRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));

	    itemRepository.delete(item);

	    return ResponseEntity.ok().build();
	}
}
