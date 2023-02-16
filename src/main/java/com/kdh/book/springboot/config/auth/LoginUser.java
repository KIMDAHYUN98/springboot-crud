package com.kdh.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 생성될 수 있는 위치 지정
@Retention(RetentionPolicy.RUNTIME) // 어노테이션 클래스로 지정
public @interface LoginUser {

}
