package org.cnt.psb.startup.event;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author lixinjie
 * @since 2019-10-28
 */
public class AcEvent01 implements ApplicationListener<ApplicationStartingEvent> {

	@Override
	public void onApplicationEvent(ApplicationStartingEvent event) {
		System.out.println("AcEvent01 : starting");
	}

}
