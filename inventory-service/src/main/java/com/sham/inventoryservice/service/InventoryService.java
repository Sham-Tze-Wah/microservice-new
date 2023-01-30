package com.sham.inventoryservice.service;

import com.sham.inventoryservice.model.Inventory;
import com.sham.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;


    public boolean isInStock(String skuCode) {
        Optional<Inventory> inventoryOptional = inventoryRepository.findBySkuCode(skuCode);
        return inventoryOptional.isPresent()?true:false;
    }
}
