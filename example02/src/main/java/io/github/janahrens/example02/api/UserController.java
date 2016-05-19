package io.github.janahrens.example02.api;

import io.github.janahrens.example02.db.entity.User;
import io.github.janahrens.example02.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public Page<UserApiResponse> index() {
    Page<User> userPage = userService.getAll();
    return userPage.map(UserApiResponse::new);
  }

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> create(@RequestBody @Valid CreateUserAPIRequest createUserAPIRequest, Errors errors) {
    if (errors.hasErrors()) {
      // TODO proper error handling
      return ResponseEntity.unprocessableEntity().build();
    } else {
      long id = userService.createUser(createUserAPIRequest);
      return ResponseEntity.created(URI.create("/users/" + id)).build();
    }
  }

  @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> show(@PathVariable Long userId) {
    User u= userService.getUser(userId);
    if (u == null) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(new UserApiResponse(u));
    }
  }

}
