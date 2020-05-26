package com.booklibrary.frontend.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

  private int id;

  @NotNull(message = "Title is required")
  @Size(min = 2, message = "Minimum 2 characters")
  private String title;

  @NotNull(message = "Description is required")
  @Size(min = 10, message = "Minimum 10 characters")
  private String description;

  @NotNull(message = "Author is required")
  @Size(min = 2, message = "Minimum 2 characters")
  private String author;

  @NotNull(message = "Publication date is required")

  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private String releaseDate;

  private boolean isAvailable;
}
