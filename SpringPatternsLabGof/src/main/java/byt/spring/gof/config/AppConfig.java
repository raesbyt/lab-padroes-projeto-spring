package byt.spring.gof.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import byt.spring.gof.services.ClienteService;
import byt.spring.gof.strategy.ClienteStrategy;

@Configuration
public class AppConfig {
	
	@Bean
	public ClienteStrategy strategy() {
		return new ClienteService();
	}

}
