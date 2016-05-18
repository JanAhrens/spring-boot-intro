package io.github.janahrens.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import ratpack.handling.Handler;
import ratpack.spring.config.EnableRatpack;
import ratpack.spring.config.RatpackProperties;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableRatpack
public class Example01Application {

  public static void main(String[] args) {
    SpringApplication.run(Example01Application.class, args);
  }

}
