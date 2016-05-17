package io.github.janahrens.hellospring;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Example01Application {

	private final Logger log = Logger.getLogger(Example01Application.class);

    @Autowired
    ApplicationContext applicationContext;

    /**
     * Provides a way to look at the state of the {@link ApplicationContext} after dependency injection has been done.
     */
	@PostConstruct
	private void init() {
		log.info("Hello World! There are " + applicationContext.getBeanDefinitionCount() + " beans defined.");
	}

	public static void main(String[] args) {
		SpringApplication.run(Example01Application.class, args);
	}
}
