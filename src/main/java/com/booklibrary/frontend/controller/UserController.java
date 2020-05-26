package com.booklibrary.frontend.controller;

import com.booklibrary.frontend.dto.User;
import com.booklibrary.frontend.service.BookService;
import com.booklibrary.frontend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
public class UserController {

  @Autowired private UserService userService;

  @GetMapping("/list")
  public String listUsers(Model model) {

    User user = new User();
    model.addAttribute("users", userService.getUsers());
    model.addAttribute("user", user);

    return "users/users-list";
  }

  @GetMapping("/add-form")
  public String showFormForAdd(Model model) {

    User user = new User();

    model.addAttribute("user", user);

    return "users/users-form";
  }

  @GetMapping("/update-form")
  public String showFormForUpdate(@RequestParam("id") int id, Model model) {

    User user = userService.getUser(id);

    model.addAttribute("user", user);

    return "users/users-form";
  }

  @GetMapping("/users-card")
  public String showUsersCard(@RequestParam("id") int id, Model model) {

    User user = userService.getUser(id);

    model.addAttribute(user);

    return "users/users-card";
  }

  @GetMapping("/search")
  public String search(@RequestParam("userName") String userName, Model model) {

    model.addAttribute("users", userService.search(userName));

    return "users/users-list";
  }

  @PostMapping("/save")
  public String save(@ModelAttribute("user") User user) {

    userService.createUser(user);

    return "redirect:/users/list";
  }

  @GetMapping("/delete")
  public String delete(@RequestParam("id") int id) {

    userService.delete(id);

    return "redirect:/users/list";
  }
}
