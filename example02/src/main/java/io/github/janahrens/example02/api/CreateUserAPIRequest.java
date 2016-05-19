package io.github.janahrens.example02.api;

import io.github.janahrens.example02.domain.CreateUserRequest;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class CreateUserAPIRequest implements CreateUserRequest {

  @NotBlank
  @Length(max = 10)
  private String username;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

}
