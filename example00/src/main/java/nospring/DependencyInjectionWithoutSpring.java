package nospring;

public class DependencyInjectionWithoutSpring {

    public static void main(String[] args) {
        LocalUserRepository userRepository = new LocalUserRepository();
        UserService userService = new UserService(userRepository);

        userService.addUser(new User("Foo Bar1"));

        userRepository.findAll()
                .stream()
                .map(User::getName)
                .forEach(System.out::println);
    }

}
