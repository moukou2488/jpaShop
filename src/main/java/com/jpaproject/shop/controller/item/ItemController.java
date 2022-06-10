package com.jpaproject.shop.controller.item;

import com.jpaproject.shop.controller.item.BookForm;
import com.jpaproject.shop.domain.item.Album;
import com.jpaproject.shop.domain.item.Book;
import com.jpaproject.shop.domain.item.Item;
import com.jpaproject.shop.domain.item.Movie;
import com.jpaproject.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    private final ModelMapper modelMapper;

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

    @GetMapping("/items/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {
        Item item = itemService.findOne(itemId);

        if (item instanceof Book) {
            Book book = (Book) item;
            BookForm form = modelMapper.map(book, BookForm.class);
            model.addAttribute("form", form);
        } else if (item instanceof Movie) {
            Movie movie = (Movie) item;
            MovieForm form = modelMapper.map(movie, MovieForm.class);
            model.addAttribute("form", form);
        } else if (item instanceof Album) {
            Album album = (Album) item;
            AlbumForm form = modelMapper.map(album, AlbumForm.class);
            model.addAttribute("form", form);
        }


        return "items/updateItemForm";
    }

    @PostMapping("/items/{itemId}/edit")
    public String updateItem(@ModelAttribute("form") ItemDto itemDto,@PathVariable Long itemId) {
        itemService.updateItem(itemId,itemDto);

        return "redirect:/items";
    }


}
