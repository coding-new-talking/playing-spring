package org.cnt.psb.env.yml;

import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.stereotype.Component;

/**
 * @author lixinjie
 * @since 2019-06-04
 */
@Component
public class YmlDesc {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;
	
	public void outputEnv() {
		log.info("list-list[2][1] => {}", environment.getProperty("list-list[2][1]"));
		log.info("map-map.k3.k32 => {}", environment.getProperty("map-map.k3.k32"));
	}
	
	@Value("${list-list[2][1]}")
	private String listList;
	
	@Value("${map-map.k3.k32}")
	private String mapMap;
	
	public void outputField() {
		log.info("listList => {}", listList);
		log.info("mapMap => {}", mapMap);
	}
	
	@PostConstruct
	public void init() {
		log.info("environment instanceof ConfigurableEnvironment={}", environment instanceof ConfigurableEnvironment);
		ConfigurableEnvironment ce = (ConfigurableEnvironment)environment;
		log.info("environment={}", ce);
		MutablePropertySources mps = ce.getPropertySources();
		mps.forEach(ps -> {
			log.info("============================================================");
			log.info("{}", ps);
			if (ps instanceof EnumerablePropertySource<?>) {
				String[] propertyNames = ((EnumerablePropertySource<?>)ps).getPropertyNames();
				Stream.of(propertyNames).forEach(pn -> log.info("{}={}", pn, ps.getProperty(pn)));
			}
		});
		
		outputEnv();
		outputField();
	}
}
