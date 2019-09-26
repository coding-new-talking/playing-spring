package org.cnt.psb.conditionann;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author lixinjie
 * @since 2019-09-26
 */
@Configuration
public class ConditionAnnotation {

	@ConditionalOnProperty(prefix = "studying",
			name = "computer", havingValue = "1024",
			matchIfMissing = false)
	@Component
	public static class OnProperty {
		private Logger log = LoggerFactory.getLogger(this.getClass());
		@PostConstruct
		public void init() {
			log.info("OnProperty => 被注册");
		}
	}
	
	@ConditionalOnClass(name = "java.time.LocalDateTime")
	@Component
	public static class OnClass {
		private Logger log = LoggerFactory.getLogger(this.getClass());
		@PostConstruct
		public void init() {
			log.info("OnClass => 被注册");
		}
	}
	
	@ConditionalOnBean(value = OnProperty.class)
	@Component
	public static class OnBean {
		private Logger log = LoggerFactory.getLogger(this.getClass());
		@PostConstruct
		public void init() {
			log.info("OnBean => 被注册");
		}
	}
	
	@ConditionalOnSingleCandidate(value = OnBean.class)
	@Component
	public static class OnSingleCandidate {
		private Logger log = LoggerFactory.getLogger(this.getClass());
		@PostConstruct
		public void init() {
			log.info("OnSingleCandidate => 被注册");
		}
	}
	
	@ConditionalOnResource(resources = "application.yml")
	@Component
	public static class OnResource {
		private Logger log = LoggerFactory.getLogger(this.getClass());
		@PostConstruct
		public void init() {
			log.info("OnResource => 被注册");
		}
	}
}
