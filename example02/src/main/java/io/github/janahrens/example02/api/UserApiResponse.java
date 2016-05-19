package io.github.janahrens.example02.api;

import io.github.janahrens.example02.db.entity.User;

public class UserApiResponse {
  private String username;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public UserApiResponse(User user) {
    username = user.getName();
  }

}
