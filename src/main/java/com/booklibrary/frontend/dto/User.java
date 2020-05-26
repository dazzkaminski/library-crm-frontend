package com.booklibrary.frontend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private int id;

  private String userName;

  private String email;

  private String password;

  private String role;
}
