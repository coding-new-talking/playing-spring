package org.cnt.psb.startup.event;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author lixinjie
 * @since 2019-10-28
 */
//@Component
public class CmdRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("CmdRunner : CommandLineRunner is running");
	}

}
