package com.jpaproject.shop.controller;

import com.jpaproject.shop.domain.item.Book;
import com.jpaproject.shop.domain.item.Item;
import com.jpaproject.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/items/new")
    public String createForm(Model model) {
        model.addAttribute("form", new BookForm());
        return "items/createItemForm";
    }

    @PostMapping("/items/new")
    public String create(BookForm bookForm) {
        Book book = Book.builder()
                .name(bookForm.getName())
                .price(bookForm.getPrice())
                .stockQuantity(bookForm.getStockQuantity())
                .isbn(bookForm.getIsbn())
                .author(bookForm.getAuthor())
                .build();

        itemService.saveItem(book);

        return "redirect:/";

    }

    @GetMapping("/items")
    public String list(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }
}
