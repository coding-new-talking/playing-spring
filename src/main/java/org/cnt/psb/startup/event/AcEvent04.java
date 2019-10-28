package org.cnt.psb.startup.event;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author lixinjie
 * @since 2019-10-28
 */
public class AcEvent04 implements ApplicationListener<ApplicationPreparedEvent> {

	@Override
	public void onApplicationEvent(ApplicationPreparedEvent event) {
		System.out.println("AcEvent04 : context loaded resource, " + event.getApplicationContext());
	}

}
