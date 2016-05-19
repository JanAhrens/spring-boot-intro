package io.github.janahrens.example02.domain;

import io.github.janahrens.example02.api.CreateUserAPIRequest;
import io.github.janahrens.example02.db.entity.User;
import io.github.janahrens.example02.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAll() {
    return userRepository.findAll();
  }

  public long createUser(CreateUserRequest createUserRequest) {
    User u = new User();
    u.setName(createUserRequest.getUsername());
    User savedUser = userRepository.saveAndFlush(u);
    return savedUser.getId();
  }
}
