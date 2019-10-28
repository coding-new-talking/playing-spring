package org.cnt.psb.startup.event;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author lixinjie
 * @since 2019-10-28
 */
public class AcEvent05 implements ApplicationListener<ApplicationStartedEvent> {

	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		System.out.println("AcEvent05 : context refreshed, " + event.getApplicationContext());
	}

}
