package com.komarov.coffe_maker.item_service.model.dto;

import com.komarov.coffe_maker.item_service.model.Item;

import java.math.BigDecimal;

public record ItemDTO(
        Long id,
        String name,
        String description,
        BigDecimal price,
        String imageUrl,
        String category
        ) {
    public ItemDTO(Item item){
        this(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getPrice(),
                item.getImageUrl(),
                item.getCategory().getName()
        );
    }
}
