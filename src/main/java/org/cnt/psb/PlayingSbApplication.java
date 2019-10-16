package org.cnt.psb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PlayingSbApplication {

	public static void main(String[] args) {
		//SpringApplication.run(PlayingSbApplication.class, args);
		SpringApplication sa = new SpringApplication(PlayingSbApplication.class);
		ConfigurableApplicationContext cac = sa.run(args);
	}

}
