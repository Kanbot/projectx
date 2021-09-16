package com.jojoldu.book.spring.config.auth;


import com.jojoldu.book.spring.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().headers().frameOptions().disable().and().authorizeRequests().antMatchers("/", "/css/**",
                "images/**" , "/js/**","/h2-console/**","/profile","/posts/info","/posts/blog","/posts/posts","/posts/posts/**","/posts/dev","/posts/search","/posts/page").permitAll()
                .anyRequest().authenticated().and().logout().logoutSuccessUrl("/").and().oauth2Login().userInfoEndpoint()
                .userService(customOAuth2UserService);
    }

}
