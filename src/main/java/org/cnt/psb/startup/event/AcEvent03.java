package org.cnt.psb.startup.event;

import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author lixinjie
 * @since 2019-10-28
 */
public class AcEvent03 implements ApplicationListener<ApplicationContextInitializedEvent> {

	@Override
	public void onApplicationEvent(ApplicationContextInitializedEvent event) {
		System.out.println("AcEvent03 : context is prepared, " + event.getApplicationContext());
	}

}
