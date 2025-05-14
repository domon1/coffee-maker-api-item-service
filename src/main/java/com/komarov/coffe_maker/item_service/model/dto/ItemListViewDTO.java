package com.komarov.coffe_maker.item_service.model.dto;

import com.komarov.coffe_maker.item_service.model.Item;

import java.math.BigDecimal;

public record ItemListViewDTO(
        Long id,
        String name,
        String imageUrl,
        BigDecimal price
) {
    public ItemListViewDTO(Item item) {
        this(
                item.getId(),
                item.getName(),
                item.getImageUrl(),
                item.getPrice()
        );
    }
}
