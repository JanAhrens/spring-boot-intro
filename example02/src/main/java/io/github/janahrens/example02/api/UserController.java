package io.github.janahrens.example02.api;

import io.github.janahrens.example02.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<?> index() {
    userService.getAll();
    return ResponseEntity.ok().build();
  }

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> create(@RequestBody @Valid CreateUserAPIRequest createUserAPIRequest, Errors errors) {
    if (errors.hasErrors()) {
      // TODO proper error handling
      return ResponseEntity.unprocessableEntity().build();
    } else {
      long id = userService.createUser(createUserAPIRequest);
      return ResponseEntity.created(URI.create("/users/" + id)).build();
    }
  }

}
