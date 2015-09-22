package com.theyavikteam.mockatacore.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MockFloat {
    String name();
    float min() default 0.0f;
    float max() default 500.0f;
    int nullable() default 0;
}