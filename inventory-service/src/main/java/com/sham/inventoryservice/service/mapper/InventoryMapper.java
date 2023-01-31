package com.sham.inventoryservice.service.mapper;

import com.sham.inventoryservice.dto.InventoryPojo;
import com.sham.inventoryservice.dto.InventoryResponse;
import com.sham.inventoryservice.model.Inventory;
import org.springframework.stereotype.Service;

@Service
public class InventoryMapper {
    public InventoryPojo entityToPojo(Inventory inventory){
        InventoryPojo inventoryPojo = new InventoryPojo();
        inventoryPojo.setId(inventory.getId());
        inventoryPojo.setSkuCode(inventory.getSkuCode());
        inventoryPojo.setQuantity(inventory.getQuantity());
        return inventoryPojo;
    }
}
