package com.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entities.Inventory;
import com.inventory.repository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository repo;
	
	public void saveProduct(Inventory inventory) {
		repo.save(inventory);
		
	}

	public void updateStatus(Inventory inventory, long id) {
		Inventory inv = new Inventory();
		inv.setId(id);
		inv.setProduct_name(inventory.getProduct_name());
		inv.setQuantity(inventory.getQuantity());
		inv.setPrice(inventory.getPrice());
		
		repo.save(inv);
	}

	public List<Inventory> getProduct() {
		List<Inventory> products = repo.findAll();
		return products;
	}

	public void deleteProduct(long id) {
	repo.deleteById(id);
		
	}

	public Inventory productGetById(long id) {
		Optional<Inventory> product = repo.findById(id);
		Inventory inventory = product.get();
		return inventory;
	}
	
	
	
	

}
