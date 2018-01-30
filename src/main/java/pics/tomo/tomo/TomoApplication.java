package pics.tomo.tomo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


public class TomoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TomoApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TomoApplication.class);
	}
}
