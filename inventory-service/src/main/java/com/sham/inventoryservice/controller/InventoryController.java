package com.sham.inventoryservice.controller;

import com.sham.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/post")
    public ResponseEntity<?> create(){
        return new ResponseEntity<>("Created successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/get/{sku-code}")
    public ResponseEntity<?> get(@PathVariable("sku-code") String skuCode){
        return new ResponseEntity<>(inventoryService.isInStock(skuCode), HttpStatus.OK);
    }

}
