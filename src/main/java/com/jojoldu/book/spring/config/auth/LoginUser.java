package com.jojoldu.book.spring.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 이 어노미테이션이 생성 될 수 있는 위치를 지정합니다.
                                // 파라미터로 지정했으니 메소드의 파라미터로 선언된 객체에서만 사용할수 있습니다.
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
