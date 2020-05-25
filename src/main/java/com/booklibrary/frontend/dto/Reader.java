package com.booklibrary.frontend.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reader {

  private int id;

  private String firstName;

  private String lastName;

  private String phoneNumber;

  private String email;

  private Address address;

  private List<Book> books;

  public void addBook(Book book) {
    books.add(book);
  }

  public void removeBook(Book book) {
    books.indexOf(book);
  }
}
