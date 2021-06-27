package webtech.projekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

//

@SpringBootApplication
public class ProjektApplication {
	@RequestMapping
	public static void main(String[] args) {
		SpringApplication.run(ProjektApplication.class, args);
	}

}
