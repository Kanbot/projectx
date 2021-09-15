package com.jojoldu.book.spring.web;

import com.jojoldu.book.spring.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@RunWith - JUnit에 내장된 실행자 외에 다른 실행자를 실행 시킨다. SpringRunner를 실행자로 사용해 스프링 부트 테스트와 JUni 사이의 연결자
//역할을 한다.
@WebMvcTest(controllers =  HelloController.class,
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
        }
)
//@WebMvcTest - 여러 스프링 테스트 어노테이션 중 Web 에 집중 할 수 있는 어노테이션 입니다.선언할 경우 @Controller , @ControllerAdvice 등을 사용가능
// @service ,@component, @Repository 등은 사용 할 수 없다.
public class HelloControllerTest {

    @Autowired // @AutoWired - 스프링이 관리하는 빈을 주입 받는다.
    private MockMvc mvc; //웹 APi를 테스트 할 때 사용한다.스프링 MVC 테스트의 시작점이다. 이 클래스를 통해 HTTP GET,POST 등에 대한 API 테스트를 할 수 있다.

    @WithMockUser(roles="USER")
    @Test
    public  void hello가_리턴된다() throws Exception{
        String hello ="hello";
        mvc.perform(get("/hello")) //MockMvc 를 통해 /hello 주소로 http get 요청을 한다.체이닝잉 지원되어 여러 검증 기능을 이어서 선언 할 수 있다.
                .andExpect(status().isOk()) // mvc.perform의 결과를 검증합니다.http header의 status를 검증합니다.우리가 흔히 알고 있는 200,400
                // 500 등의 상태를 검증합니다. 여기선 OK 즉 200인지 아닌지를 검증합니다.
                .andExpect(content().string(hello)); // 응답 본문의 내용을 검증합니다. controller 에서 hello를 리턴하기 때문에 이 값이 맞는지 검증합니다.
    }
}
