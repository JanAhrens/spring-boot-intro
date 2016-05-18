package withspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DependencyInjectionWithSpring {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    UserRepository userRepository() {
        return new LocalUserRepository();
    }

    @PostConstruct
    private void init() {
        userService.addUser(new User("Foo Bar1"));

        userRepository.findAll()
                .stream()
                .map(User::getName)
                .forEach(System.out::println);
    }

    @PostConstruct
    private void debug() {
        System.out.println("There are " + applicationContext.getBeanDefinitionCount() + " beans defined.");
    }

    public static void main(String[] args) {
        SpringApplication.run(DependencyInjectionWithSpring.class, args);
    }

}
