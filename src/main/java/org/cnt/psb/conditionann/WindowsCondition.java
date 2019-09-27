package org.cnt.psb.conditionann;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author lixinjie
 * @since 2019-09-27
 */
public class WindowsCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		if (context.getEnvironment().getProperty("os.name").toLowerCase().contains("windows")) {
			return true;
		}
		return false;
	}

}
