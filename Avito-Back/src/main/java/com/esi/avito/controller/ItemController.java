package com.esi.avito.controller;

import com.esi.avito.model.Item;
import com.esi.avito.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.saveItem(item);
    }

    @GetMapping("/{id}")
    public Optional<Item> getItem(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }

    @GetMapping("/user/firebase/{firebaseUserId}")
    public List<Item> getItemsByFirebaseUserId(@PathVariable String firebaseUserId) {
        return itemService.getItemsByFirebaseUserId(firebaseUserId);
    }
}
