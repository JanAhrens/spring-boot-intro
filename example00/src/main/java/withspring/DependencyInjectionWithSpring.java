package withspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DependencyInjectionWithSpring {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Bean
    UserRepository userRepository() {
        return new LocalUserRepository();
    }

    @PostConstruct
    public void init() {
        userService.addUser(new User("Foo Bar1"));

        userRepository.findAll()
                .stream()
                .map(User::getName)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(DependencyInjectionWithSpring.class, args);
    }

}
