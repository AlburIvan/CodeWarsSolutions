package com.raworkstudio.codewars.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Ivan Alburquerque on 5/10/2017.
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE) //can use in class only.
public @interface Builder {

    String className() default "$$";

}
