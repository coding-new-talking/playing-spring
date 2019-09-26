package org.cnt.psb.conditionann;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author lixinjie
 * @since 2019-09-26
 */
@Configuration
public class ProfileConfig {

	
	@Profile("default")
	@Component
	public static class Default {
		private Logger log = LoggerFactory.getLogger(this.getClass());
		@PostConstruct
		public void init() {
			log.info("profile => default");
		}
	}
	
	@Profile("prod")
	@Component
	public static class Prod {
		private Logger log = LoggerFactory.getLogger(this.getClass());
		@PostConstruct
		public void init() {
			log.info("profile => prod");
		}
	}
}
