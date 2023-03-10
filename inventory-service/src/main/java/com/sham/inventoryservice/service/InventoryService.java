package com.sham.inventoryservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sham.inventoryservice.dto.InventoryPojo;
import com.sham.inventoryservice.dto.InventoryResponse;
import com.sham.inventoryservice.model.Inventory;
import com.sham.inventoryservice.repository.InventoryRepository;
import com.sham.inventoryservice.service.mapper.InventoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    private final InventoryMapper inventoryMapper;

    @SneakyThrows //try catch better
    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        log.info("Wait Started");
        Thread.sleep(10000);
        log.info("Wait Started");
        List<Inventory> inventoryOptional = inventoryRepository.findBySkuCodeIn(skuCode);
        return inventoryOptional.stream()
                .map(inventory -> InventoryResponse.builder()
                .skuCode(inventory.getSkuCode())
                .isInStock(inventory.getQuantity() > 0)
                .build()
                ).collect(Collectors.toList());
    }

    public InventoryPojo createInventory(String skuCode, int quantity) {
        Inventory inventory1 = new Inventory();
        inventory1.setSkuCode(skuCode);
		inventory1.setQuantity(quantity);
		inventoryRepository.save(inventory1);
		return inventoryMapper.entityToPojo(inventory1);
    }
}
