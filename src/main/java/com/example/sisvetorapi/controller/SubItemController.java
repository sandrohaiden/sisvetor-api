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

import com.example.sisvetorapi.exception.ResourceNotFoundException;
import com.example.sisvetorapi.model.Item;
import com.example.sisvetorapi.model.SubItem;
import com.example.sisvetorapi.repository.SubItemRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class SubItemController {
	
	@Autowired
	SubItemRepository subItemRepository;
	
	@GetMapping("/subitens")
	public List<SubItem> getAllSubItens(){
		return subItemRepository.findAllByOrderByNomeAsc();
	}
	
	@GetMapping("/subitens/search")
	public List<SubItem> finByNome(@RequestParam("nome")String nome){
		return subItemRepository.findByNomeContainingIgnoreCase(nome);
	}
	
	@PostMapping("/subitens")
	public SubItem adicionarSubItem(@Valid @RequestBody SubItem subItem) {
		return subItemRepository.save(subItem);
	}
	
	@PutMapping("subitens/{id}")
	public SubItem updateSubItem(@PathVariable(value = "id") Long id, @Valid @RequestBody SubItem newItem) {
		SubItem subItem = subItemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Item", "id", id));
		newItem.setId(id);
		return subItemRepository.save(newItem);
	}
	
	@DeleteMapping("subitens/{id}")
	public ResponseEntity<?> deleteSubItem(@PathVariable(value = "id") Long id) {
		SubItem subItem = subItemRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", id));

	    subItemRepository.delete(subItem);

	    return ResponseEntity.ok().build();
	}
}
