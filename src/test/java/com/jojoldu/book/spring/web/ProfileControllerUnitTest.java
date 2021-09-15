package com.jojoldu.book.spring.web;


import org.junit.Test;
import org.mockito.Mock;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.security.core.parameters.P;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ProfileControllerUnitTest {
@Test
    public void  real_profile이_조회된다(){
    //given
    String  expectedProfile ="real";
    MockEnvironment env = new MockEnvironment();
    env.addActiveProfile(expectedProfile);
    env.addActiveProfile("oauth");
    env.addActiveProfile("real-db");

    ProfileController controller = new ProfileController(env);
    //when
    String profile = controller.profile();
    //then
    assertThat(profile).isEqualTo(expectedProfile);
}
@Test
    public  void  active_profile이_없으면_default가_조회된다(){
    //given
    String expectProfile ="default";
    MockEnvironment env =new MockEnvironment();
    ProfileController controller =new ProfileController(env);
    //when
    String profile =controller.profile();
    //then
    assertThat(profile).isEqualTo(expectProfile);
}

}
