package com.booklibrary.frontend.controller;

import com.booklibrary.frontend.dto.Reader;
import com.booklibrary.frontend.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/readers")
public class ReaderController {

  @Autowired
  private ReaderService readerService;

  @GetMapping("/list")
  public String listReaders(Model model) {

    model.addAttribute("readers", readerService.getReaders());

    return "readers/readers-list";
  }

  @GetMapping("/showFormForAdd")
  public String showFormForAdd(Model model) {

    Reader reader = new Reader();

    model.addAttribute("reader", reader);

    return "readers/readers-form";
  }

  @GetMapping("/showFormForUpdate")
  public String showFormForUpdate(@RequestParam("id") int id, Model model) {

    Reader reader = readerService.getReader(id);

    model.addAttribute("reader", reader);

    return "readers/readers-form";
  }

  @PostMapping("/save")
  public String save(@ModelAttribute("reader") Reader reader) {

    readerService.createReader(reader);

    return "redirect:/readers/list";
  }


  @GetMapping("/delete")
  public String delete(@RequestParam("id") int id) {

    readerService.delete(id);

    return "redirect:/readers/list";
  }
}
