package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.entities.Inventory;
import com.inventory.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@PostMapping
	public void create(@RequestBody Inventory inventory) {
		inventoryService.saveProduct(inventory);
		
	}
	
	@PutMapping("{id}")
	public void update(@RequestBody Inventory inventory , @PathVariable("id")long id ) {
		inventoryService.updateStatus(inventory , id);
	}
	
	@GetMapping
	public List<Inventory> getProducts() {
		List<Inventory> product = inventoryService.getProduct();
		return product;
	}
	
	@DeleteMapping("{id}")
	public void deleteProduct(@PathVariable("id")long id) {
		inventoryService.deleteProduct(id);
	}
	
	@GetMapping("{id}")
	public Inventory productGetById(@PathVariable("id")long id) {
		Inventory product = inventoryService.productGetById(id);
		return product;
	}
	
}
