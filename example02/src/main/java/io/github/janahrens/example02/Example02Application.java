package io.github.janahrens.example02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class Example02Application {

  public static void main(String [] args) {
    SpringApplication.run(Example02Application.class, args);
  }

}
