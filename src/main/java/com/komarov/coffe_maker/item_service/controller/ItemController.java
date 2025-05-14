package com.komarov.coffe_maker.item_service.controller;

import com.komarov.coffe_maker.item_service.model.dto.ItemDTO;
import com.komarov.coffe_maker.item_service.model.dto.ItemListViewDTO;
import com.komarov.coffe_maker.item_service.service.ItemService;
import com.komarov.coffe_maker.item_service.util.ApiError;
import com.komarov.coffe_maker.item_service.util.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/v1/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<ItemListViewDTO>> getItems() {
        return ResponseEntity.ok(itemService.findAll());
    }

    @GetMapping(path = "/category/{id}")
    public ResponseEntity<List<ItemListViewDTO>> getItemsByCategory(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.findByCategoryId(id));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.findById(id));
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ApiError> handleItemNotFoundException(ItemNotFoundException e) {
        ApiError error = new ApiError(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
