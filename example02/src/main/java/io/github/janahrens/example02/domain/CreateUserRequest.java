package io.github.janahrens.example02.domain;

/**
 * Helps to reduce coupling between the REST API request and the service layer.
 */
public interface CreateUserRequest {
  String getUsername();
}
