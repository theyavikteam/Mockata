package com.theyavikteam.mockatacore.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MockLong {
    String name();
    long min() default 0L;
    long max() default 1000000L;
    int nullable() default 0;
}