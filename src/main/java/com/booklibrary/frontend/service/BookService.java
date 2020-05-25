package com.booklibrary.frontend.service;

import com.booklibrary.frontend.dto.Book;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {

  @Value("${library.books.endpoint}")
  private String endpoint;

  @Autowired
  private RestTemplate restTemplate;

  public List<Book> getBooks() {

    Book[] books = restTemplate.getForObject(endpoint, Book[].class);

    return Arrays.asList(Optional.ofNullable(books).orElse(new Book[0]));
  }

  public List<Book> search(String title) {

    Book[] books = restTemplate.getForObject(endpoint + "/search/" + title, Book[].class);

    return Arrays.asList(Optional.ofNullable(books).orElse(new Book[0]));
  }

  public Book getBook(int id) {

    Book reader = restTemplate.getForObject(endpoint + "/" + id, Book.class);

    return reader;
  }

  public void createBook(Book reader) {
    restTemplate.postForObject(endpoint, reader, Book.class);
  }

  public void delete(int id) {
    restTemplate.delete(endpoint + "/" + id);
  }
}
