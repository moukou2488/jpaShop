package com.jpaproject.shop.controller.order;

import com.jpaproject.shop.domain.Order;
import com.jpaproject.shop.domain.User;
import com.jpaproject.shop.domain.item.Item;
import com.jpaproject.shop.repository.OrderSearch;
import com.jpaproject.shop.service.ItemService;
import com.jpaproject.shop.service.OrderService;
import com.jpaproject.shop.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;
    private final ItemService itemService;

    @GetMapping("/order")
    public String createForm(Model model) {
        List<User> users = userService.findUsers();
        List<Item> items = itemService.findItems();

        model.addAttribute("users", users);
        model.addAttribute("items", items);

        return "order/orderForm";
    }

    @PostMapping("/order")
    public String order(@RequestParam("userId") Long userId,
                        @RequestParam("itemId") Long itemId,
                        @RequestParam("count") int count) {
        orderService.order(userId, itemId, count);
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String orderList(@ModelAttribute("orderSearch") OrderSearch orderSearch, Model model) {
        List<Order> orders = orderService.findOrders(orderSearch);
        model.addAttribute("orders", orders);
        return "order/orderList";
    }

    @PostMapping("/orders/{orderId}/cancel")
    public String cancelOrder(@PathVariable Long orderId) {
        orderService.cancelOrder(orderId);
        return "redirect:/orders";
    }
}
