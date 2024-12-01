package com.dawn.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @GetMapping("update/{id}")
    String detailUpdateItem(@PathVariable("id") Long id, Model model) {
        Item findItem = itemService.findByIdItems(id);
        model.addAttribute("item", findItem);

        return "update";
    }

    @PostMapping("/update")
    String putItem(@Validated @ModelAttribute Item item, BindingResult bindingResult, Model model) {
        itemService.putItem(item); // 서비스 호출
        return "redirect:list";
    }

    @GetMapping("/delete")
    ResponseEntity<String> deleteItem(@RequestParam Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.status(200).body("삭제완료");
    }
}
