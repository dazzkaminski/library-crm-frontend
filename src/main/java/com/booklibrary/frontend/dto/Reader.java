package com.booklibrary.frontend.dto;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Reader {

  private int id;

  @NotNull(message = "First name is required")
  @Size(min = 2, message = "Minimum 2 characters")
  private String firstName;

  @NotNull(message = "Last name is required")
  @Size(min = 2, message = "Minimum 2 characters")
  private String lastName;

  @NotNull(message = "Email is required")
  @Size(min = 9, message = "Minimum 9 numbers")
  private String phoneNumber;

  @NotNull(message = "Email is required")
  @Email(message = "No a valid email address")
  private String email;

  @Valid
  private Address address;

  private List<Book> books;

  public void addBook(Book book) {
    books.add(book);
  }

  public void removeBook(Book book) {
    books.indexOf(book);
  }
}
