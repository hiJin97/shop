package com.dawn.shop;

import com.dawn.shop.common.exception.ItemNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {


    private final ItemRepository itemRepository;

    public void addItem(Item item) {
        itemRepository.save(item);
    }

    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    public Item findByIdItems(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Item Not found"));
    }

    public void putItem(Item item) {
        Item findItem = itemRepository.findById(item.getId()).orElseThrow(() -> new ItemNotFoundException("Item Not found"));

        findItem.setName(item.getName());
        findItem.setPrice(item.getPrice());

        itemRepository.save(findItem);
    }

}
