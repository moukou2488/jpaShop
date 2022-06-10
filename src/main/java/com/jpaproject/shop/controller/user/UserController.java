package com.jpaproject.shop.controller.user;

import com.jpaproject.shop.domain.Address;
import com.jpaproject.shop.domain.User;
import com.jpaproject.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/new")
    public String createForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "users/createUsersForm";
    }

    @PostMapping("/users/new")
    public String create(@Valid UserForm userForm, BindingResult result) {

        if (result.hasErrors()) {
            return "users/createUsersForm";
        }

        Address address = new Address(userForm.getCity(), userForm.getStreet(), userForm.getZipcode());

        User user = User.builder()
                .name(userForm.getName())
                .address(address)
                .build();

        userService.join(user);
        return "redirect:/";
    }

    @GetMapping("/users")
    public String list(Model model) {
        model.addAttribute("users", userService.findUsers());
        return "users/userList";
    }
}
