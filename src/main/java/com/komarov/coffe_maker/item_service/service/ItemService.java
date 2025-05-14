package com.komarov.coffe_maker.item_service.service;

import com.komarov.coffe_maker.item_service.model.dto.ItemDTO;
import com.komarov.coffe_maker.item_service.model.dto.ItemListViewDTO;
import com.komarov.coffe_maker.item_service.repository.ItemRepository;
import com.komarov.coffe_maker.item_service.util.ItemNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemDTO findById(Long id) {
        return itemRepository.findItemById(id).orElseThrow(() -> new ItemNotFoundException(id));
        //return itemRepository.findItemById(id).orElse(ItemDTO.from(new Item()));
    }

    public List<ItemListViewDTO> findByCategoryId(Long id) {
        return itemRepository.findAllByCategory_Id(id).stream().map(ItemListViewDTO::new).toList();
    }

    public List<ItemListViewDTO> findAll() {
        return itemRepository.findAll().stream().map(ItemListViewDTO::new).toList();
    }
}
