package io.github.janahrens.example02.domain;

import io.github.janahrens.example02.api.CreateUserAPIRequest;
import io.github.janahrens.example02.db.entity.User;
import io.github.janahrens.example02.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Page<User> getAll() {
    List<User> all = userRepository.findAll();
    return new PageImpl<>(all, null, all.size());
  }

  public long createUser(CreateUserRequest createUserRequest) {
    User u = new User();
    u.setName(createUserRequest.getUsername());
    User savedUser = userRepository.saveAndFlush(u);
    return savedUser.getId();
  }

  public User getUser(Long userId) {
    return userRepository.findOne(userId);
  }
}
