package org.cnt.psb.startup.event;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author lixinjie
 * @since 2019-10-28
 */
@Order(Ordered.LOWEST_PRECEDENCE)
public class AcInit02 implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		System.out.println("AcInit02 : context is initializing, " + applicationContext);
	}

}
