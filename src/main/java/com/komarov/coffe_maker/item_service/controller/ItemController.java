package com.komarov.coffe_maker.item_service.controller;

import com.komarov.coffe_maker.item_service.model.dto.ItemDTO;
import com.komarov.coffe_maker.item_service.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/v1/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<?> getItems() {
        return ResponseEntity.ok(itemService.findAll());
    }

    @GetMapping(path = "/category/{id}")
    public ResponseEntity<?> getItemsByCategory(@PathVariable Long id){
        return ResponseEntity.ok(itemService.findByCategoryId(id));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getItemById(@PathVariable Long id){
        return ResponseEntity.ok(new ItemDTO(itemService.findById(id)));
    }
}
