package com.jojoldu.book.spring.web.dto;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_테스트(){

        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name , amount);
        //then
        assertThat(dto.getName()).isEqualTo(name);  //테스트 검증 라이브러리의 검증 메소드
                                                    //검증하고 싶은 대상을 메소드 인자로 받습니다.
        assertThat(dto.getAmount()).isEqualTo(amount);



    }
}
