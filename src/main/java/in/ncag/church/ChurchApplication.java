package in.ncag.church;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
public class ChurchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChurchApplication.class, args);
		System.out.println("I am running");
	}
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}

