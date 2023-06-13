package es.aplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class App {

	public static void main(String[] args) {

		SpringApplication.run(App.class, args);

	}
	
	@Bean
	public SpringDataDialect springDataDialect() {
		return new SpringDataDialect();
	}

}
