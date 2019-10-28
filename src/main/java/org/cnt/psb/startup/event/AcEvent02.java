package org.cnt.psb.startup.event;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author lixinjie
 * @since 2019-10-28
 */
public class AcEvent02 implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
		System.out.println("AcEvent02 : environment is ok, " + event.getEnvironment());
	}

}
