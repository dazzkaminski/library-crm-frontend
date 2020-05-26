package com.booklibrary.frontend.controller;

import com.booklibrary.frontend.dto.Address;
import com.booklibrary.frontend.dto.Book;
import com.booklibrary.frontend.dto.Reader;
import com.booklibrary.frontend.service.BookService;
import com.booklibrary.frontend.service.ReaderService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/readers")
public class ReaderController {

  @Autowired private ReaderService readerService;

  @Autowired private BookService bookService;

  @InitBinder
  public void initBinder(WebDataBinder dataBinder) {

    StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

    dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
  }

  @GetMapping("/list")
  public String listReaders(Model model) {

    Reader reader = new Reader();
    model.addAttribute("readers", readerService.getReaders());
    model.addAttribute("reader", reader);

    return "readers/readers-list";
  }

  @GetMapping("/add-form")
  public String showFormForAdd(Model model) {

    Reader reader = new Reader();

    model.addAttribute("reader", reader);

    return "readers/readers-form";
  }

  @GetMapping("/return-book")
  public String returnBook(
      @RequestParam("readerId") int readerId, @RequestParam("bookId") int bookId) {

    Reader reader = readerService.getReader(readerId);

    Book book = bookService.getBook(bookId);
    book.setAvailable(true);
    bookService.createBook(book);

    reader.getBooks().remove(bookId - 1);
    readerService.createReader(reader);

    return "redirect:/readers/readers-card?=" + readerId;
  }

  @GetMapping("/update-form")
  public String showFormForUpdate(@RequestParam("id") int id, Model model) {

    Reader reader = readerService.getReader(id);

    model.addAttribute("reader", reader);

    return "readers/readers-form";
  }

  @GetMapping("/readers-card")
  public String showReadersCard(@RequestParam("id") int id, Model model) {

    Reader reader = readerService.getReader(id);

    model.addAttribute(reader);

    return "readers/readers-card";
  }

  @GetMapping("/search")
  public String search(@RequestParam("lastName") String lastName, Model model) {

    model.addAttribute("readers", readerService.search(lastName));

    return "readers/readers-list";
  }

  @PostMapping("/save")
  public String save(@Valid @ModelAttribute("reader") Reader reader, BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {

      return "readers/readers-form.html";
    }

    readerService.createReader(reader);

    return "redirect:/readers/list";
  }

  @GetMapping("/delete")
  public String delete(@RequestParam("id") int id) {

    readerService.delete(id);

    return "redirect:/readers/list";
  }
}
