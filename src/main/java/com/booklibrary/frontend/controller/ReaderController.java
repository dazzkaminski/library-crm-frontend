package com.booklibrary.frontend.controller;

import com.booklibrary.frontend.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ReaderController {

  @Autowired
  private ReaderService readerService;

  @GetMapping("/readers-list")
  public String listReaders(Model model) {

    model.addAttribute("readers", readerService.getReaders());

    return "readers-list";
  }
}
