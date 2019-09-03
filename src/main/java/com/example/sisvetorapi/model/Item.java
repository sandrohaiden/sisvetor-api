package com.example.sisvetorapi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 100, nullable = false)
	private String nome;
	
	@ManyToMany
	@JoinTable(name = "item_sub_item", joinColumns = 
	{@JoinColumn(name = "item_id")}, inverseJoinColumns = {@JoinColumn(name = "sub_item_id")})
	private Set<SubItem> subitens = new HashSet<SubItem>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<SubItem> getSubitens() {
		return subitens;
	}

	public void setSubitens(Set<SubItem> subitens) {
		this.subitens = subitens;
	}

}
