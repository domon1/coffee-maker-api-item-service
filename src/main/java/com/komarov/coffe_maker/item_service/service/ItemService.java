package com.komarov.coffe_maker.item_service.service;

import com.komarov.coffe_maker.item_service.model.Item;
import com.komarov.coffe_maker.item_service.model.dto.ItemDTO;
import com.komarov.coffe_maker.item_service.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item findById(Long id) {
        return itemRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<ItemDTO> findByCategoryId(Long id) {
        return itemRepository.findAllByCategory_Id(id).stream().map(ItemDTO::new).toList();
    }

    public List<ItemDTO> findAll() {
        return itemRepository.findAll().stream().map(ItemDTO::new).toList();
    }

    private ItemDTO convertToDTO(Item item){
        return new ItemDTO(item);
    }

    private Item convertToEntity(ItemDTO item) {
        return findById(item.id());
    }
}
