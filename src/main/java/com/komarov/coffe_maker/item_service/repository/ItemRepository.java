package com.komarov.coffe_maker.item_service.repository;

import com.komarov.coffe_maker.item_service.model.Item;
import com.komarov.coffe_maker.item_service.model.dto.ItemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByCategory_Id(Long id);

    Optional<ItemDTO> findItemById(Long id);
}
