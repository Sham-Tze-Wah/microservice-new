package com.sham.inventoryservice.controller;

import com.sham.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/post")
    public ResponseEntity<?> create(@RequestParam("skuCode") String skuCode,
                                    @RequestParam("quantity") int quantity){
        return new ResponseEntity<>(inventoryService.createInventory(skuCode, quantity), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<?> get(@RequestParam List<String> skuCode){
        return new ResponseEntity<>(inventoryService.isInStock(skuCode), HttpStatus.OK);
    }

}
