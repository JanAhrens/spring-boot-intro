package io.github.janahrens.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ratpack.handling.Handler;
import ratpack.spring.config.EnableRatpack;
import ratpack.spring.config.RatpackProperties;

@SpringBootApplication
@EnableRatpack
public class Example02Application {

    /**
     * The Ratpack application uses configurations from the {@link RatpackProperties}.
     *
     * @return a configured Ratpack {@link Handler}
     */
    @Bean
	public Handler handler() {
        return ctx -> ctx.render("Hello World.");
	}

	public static void main(String[] args) {
		SpringApplication.run(Example02Application.class, args);
	}
}
