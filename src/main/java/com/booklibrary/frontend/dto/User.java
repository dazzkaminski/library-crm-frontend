package com.booklibrary.frontend.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

  @NotNull(message = "Username is required")
  @Size(min = 3, message = "Minimum 3 characters")
  private String userName;

  @NotNull(message = "Email is required")
  @Email(message = "Wrong format of the email address")
  private String email;

  @NotNull(message = "Password is required")
  @Size(min = 6, message = "Minimum 6 characters")
  private String password;

  @NotNull(message = "Role is required")
  private String role;
}
