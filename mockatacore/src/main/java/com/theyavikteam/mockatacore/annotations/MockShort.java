package com.theyavikteam.mockatacore.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MockShort {
    String name();
    short min() default 0;
    short max() default 100;
    int nullable() default 0;
}