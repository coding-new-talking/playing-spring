package org.cnt.psb.startup.event;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author lixinjie
 * @since 2019-10-28
 */
@Order(Ordered.LOWEST_PRECEDENCE - 1)
public class AcInit01 implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		System.out.println("AcInit01 : context is initializing, " + applicationContext);
	}

}
