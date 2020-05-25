package com.booklibrary.frontend.controller;

import com.booklibrary.frontend.dto.Book;
import com.booklibrary.frontend.dto.Reader;
import com.booklibrary.frontend.service.BookService;
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
@RequestMapping("/books")
public class BooksController {

  @Autowired private BookService bookService;

  @Autowired private ReaderService readerService;

  @GetMapping("/list")
  public String listBooks(Model model) {

    Book book = new Book();
    model.addAttribute("books", bookService.getBooks());
    model.addAttribute("book", book);

    return "books/books-list";
  }

  @GetMapping("/borrow")
  public String borrow(@RequestParam("readerId") int readerId, Model model) {

    Book book = new Book();

    model.addAttribute("books", bookService.getBooks());

    model.addAttribute("book", book);

    model.addAttribute("readerId", readerId);

    return "books/borrow-list";
  }

  @GetMapping("/borrow/save")
  public String borrow(@RequestParam("readerId") int readerId, @RequestParam("bookId") int bookId) {

    Reader reader = readerService.getReader(readerId);
    Book book = bookService.getBook(bookId);

    book.setAvailable(false);
    reader.getBooks().add(book);

    readerService.createReader(reader);

    return "redirect:/readers/readers-card?id=" + readerId;
  }

  @GetMapping("/add-form")
  public String showFormForAdd(Model model) {

    Book book = new Book();

    model.addAttribute("book", book);

    return "books/books-form";
  }

  @GetMapping("/update-form")
  public String showFormForUpdate(@RequestParam("id") int id, Model model) {

    Book book = bookService.getBook(id);

    model.addAttribute("book", book);

    return "books/books-form";
  }

  @GetMapping("/book-card")
  public String showBooksCard(@RequestParam("id") int id, Model model) {

    Book book = bookService.getBook(id);

    model.addAttribute(book);

    return "books/book-card";
  }

  @GetMapping("/search")
  public String search(@RequestParam("title") String title, Model model) {

    model.addAttribute("books", bookService.search(title));

    return "books/books-list";
  }

  @PostMapping("/save")
  public String save(@ModelAttribute("book") Book book) {

    bookService.createBook(book);

    return "redirect:/books/list";
  }

  @GetMapping("/delete")
  public String delete(@RequestParam("id") int id) {

    bookService.delete(id);

    return "redirect:/books/list";
  }
}
