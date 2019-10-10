package org.cnt.psb.env.propfile;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author lixinjie
 * @since 2019-10-09
 */
@PropertySource("greeting.properties")
@PropertySource("mode.properties")
@Configuration
public class PropConfig {

}
