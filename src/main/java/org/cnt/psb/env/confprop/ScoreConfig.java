package org.cnt.psb.env.confprop;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author lixinjie
 * @since 2019-09-25
 */
@EnableConfigurationProperties(ScoreProperties.class)
@Configuration
public class ScoreConfig {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private ScoreProperties scoreProperties;
	
	public ScoreConfig(ScoreProperties scoreProperties) {
		this.scoreProperties = scoreProperties;
	}
	
	@PostConstruct
	public void outputScoreProperties() {
		log.info("scores =>");
		log.info("{}", scoreProperties.getScores());
		log.info("awards =>");
		log.info("{}", scoreProperties.getAwards());
	}
}
