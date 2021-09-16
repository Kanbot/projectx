package com.jojoldu.book.spring.web;

import com.jojoldu.book.spring.config.auth.LoginUser;
import com.jojoldu.book.spring.config.auth.dto.SessionUser;
import com.jojoldu.book.spring.domain.posts.PostsRepository;
import com.jojoldu.book.spring.service.PostsService;
import com.jojoldu.book.spring.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    //메인 화면
    @GetMapping("/")
    public String index(@LoginUser SessionUser user ,Model model) {
        if (user != null) {
            model.addAttribute("name", user.getName());
        }
        return "home";
    }

    //경고 화면
    @GetMapping("/api/v1/posts/revise/{id}")
    public String revise(@PathVariable Long id ){
        postsService.revise(id);
        return "index/index";
    }

    //블로그 이동
    @GetMapping("/posts/blog")
    public String info(Model model ,@LoginUser SessionUser user){
        model.addAttribute("posts",postsService.findAllDesc());
        model.addAttribute("name",user);
        return "blog/blog";
    }

    //검색 기능
    @GetMapping("/posts/search")
    public String search( String search, Model model){
        model.addAttribute("posts",postsService.search(search));
        return "blog/blog";
    }

    //블로그 포스트 이동
    @GetMapping("/posts/posts/{id}")
    public String post(@PathVariable Long id, Model model,@LoginUser SessionUser user){

        model.addAttribute("posts",postsService.findById(id));
        model.addAttribute("name",user);
        return  "blog/post";}


    //블로그 글쓰기 이동
    @GetMapping("/posts/insert")
    public String insert(@LoginUser SessionUser user ,Model model){
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return  "blog/post_insert";
    }

    //블로그  글수정 이동
    @GetMapping("/posts/update/{id}")
    public String postsupdate(@PathVariable Long id ,Model model) {
        PostsResponseDto dto =postsService.findById(id);
        model.addAttribute("posts",dto);
        return  "blog/post_update"; }

    //테이블 이동
    @GetMapping("/posts/table")
    public String  table(Model model){

        model.addAttribute("posts",postsService.findAllDesc());
        return  "table/table";

    }

    //배포환경 이동
    @GetMapping("/posts/dev")
    public String  dev(@LoginUser SessionUser user,Model model){
        model.addAttribute("name",user);
        return  "dev/dev";
    }



    //로그인 이동
    @GetMapping("/posts/login")
    public String login(@LoginUser SessionUser user,Model model){
        model.addAttribute("name",user);
        return  "home";
    }




}

