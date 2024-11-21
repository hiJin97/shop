package com.dawn.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    @GetMapping("/list")
    String list(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        return "list";
    }

    @GetMapping("write")
    String write() {
        return "write";
    }

    @PostMapping("add_item")
    String addItem(@ModelAttribute Item item) {

        itemRepository.save(item);

        return "redirect:list";
    }

    @GetMapping("item/{id}")
    String detail(@PathVariable("id") Long id, Model model) {
        Optional<Item> byId = itemRepository.findById(id);
        if (byId.isPresent()) {
            model.addAttribute("item", byId.get());
        } else {
            return "redirect:list";
        }
        return "item";

    }
}
