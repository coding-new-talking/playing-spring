package org.cnt.psb;

import org.cnt.psb.startup.event.AcEvent01;
import org.cnt.psb.startup.event.AcEvent02;
import org.cnt.psb.startup.event.AcEvent03;
import org.cnt.psb.startup.event.AcEvent04;
import org.cnt.psb.startup.event.AcEvent05;
import org.cnt.psb.startup.event.AcEvent06;
import org.cnt.psb.startup.event.AcInit01;
import org.cnt.psb.startup.event.AcInit02;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PlayingSbApplication {

	public static void main(String[] args) {
		//SpringApplication.run(PlayingSbApplication.class, args);
		SpringApplication sa = new SpringApplication(PlayingSbApplication.class);
		sa.addInitializers(new AcInit01(), new AcInit02());
		sa.addListeners(new AcEvent01(), new AcEvent02(), new AcEvent03(), new AcEvent04(), new AcEvent05(), new AcEvent06());
		ConfigurableApplicationContext cac = sa.run(args);
	}

}
