package com.foryouinnet.common.annotation;

import com.foryouinnet.common.controller.BaseExceptionHandler;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Import({BaseExceptionHandler.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableBaseExceptionHandler {

}
