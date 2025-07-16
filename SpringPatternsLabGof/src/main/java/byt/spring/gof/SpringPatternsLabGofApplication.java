package byt.spring.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringPatternsLabGofApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPatternsLabGofApplication.class, args);
	}

}
