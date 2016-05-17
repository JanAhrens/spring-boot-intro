package nospring;

public class UserService {

    private final UserRepository userRepository;

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
