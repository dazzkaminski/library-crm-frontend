package com.booklibrary.frontend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

  private int id;

  private String title;

  private String description;

  private String author;

  private String releaseDate;

  private boolean isAvailable;
}
