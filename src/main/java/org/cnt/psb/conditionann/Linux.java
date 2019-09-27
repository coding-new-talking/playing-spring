package org.cnt.psb.conditionann;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Conditional;

/**
 * @author lixinjie
 * @since 2019-09-27
 */
@Target({ TYPE, METHOD })
@Retention(RUNTIME)
@Documented
@Conditional(LinuxCondition.class)
public @interface Linux {

}
