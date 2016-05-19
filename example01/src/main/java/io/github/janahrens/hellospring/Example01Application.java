package io.github.janahrens.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ratpack.spring.config.EnableRatpack;

@SpringBootApplication
@EnableRatpack
public class Example01Application {

  public static void main(String[] args) {
    SpringApplication.run(Example01Application.class, args);
  }

}
