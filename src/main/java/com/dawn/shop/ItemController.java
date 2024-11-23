package com.dawn.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/list")
    String list(Model model) {
        model.addAttribute("items", itemService.findAllItems());
        return "list";
    }

    @GetMapping("write")
    String write() {
        return "write";
    }

    @PostMapping("add_item")
    String addItem(@ModelAttribute Item item) {

        itemService.addItem(item);

        return "redirect:list";
    }

    @GetMapping("item/{id}")
    String detail(@PathVariable("id") Long id, Model model) {
        Item findItem = itemService.findByIdItems(id);
        model.addAttribute("item", findItem);

        return "item";
    }


}
