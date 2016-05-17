package withspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        boolean userExisting = this.userRepository.findAll()
                .stream()
                .anyMatch(u -> user.getName().equals(u.getName()));

        if (userExisting) {
            throw new RuntimeException("User already existing");
        } else {
            this.userRepository.save(user);
        }
    }

}
