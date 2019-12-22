package org.cnt.psb.startup.event;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author lixinjie
 * @since 2019-10-28
 */
//@Component
public class AppRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("AppRunner : ApplicationRunner is running");
	}

}
