package com.komarov.coffe_maker.item_service.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(Long id) {
        super(String.format("Товар с id: %d не найден", id));
    }
}
