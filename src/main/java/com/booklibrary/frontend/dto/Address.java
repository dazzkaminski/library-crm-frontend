package com.booklibrary.frontend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

  private int id;

  @NotNull(message = "Address is required")
  @Size(min = 1, message = "Minimum 1 number")
  private String address;

  @NotNull(message = "Address is required")
  @Size(min = 1, message = "Minimum 1 number")
  private String postCode;

  @NotNull(message = "Address is required")
  @Size(min = 1, message = "Minimum 1 number")
  private String city;

  private String county;
}
