package com.jojoldu.book.spring.web;

import com.jojoldu.book.spring.config.auth.LoginUser;
import com.jojoldu.book.spring.config.auth.dto.SessionUser;
import com.jojoldu.book.spring.service.PostsService;
import com.jojoldu.book.spring.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    //메인 화면
    @GetMapping("/")
    public String index( ) {
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
    public String info(Model model){
        model.addAttribute("posts",postsService.findAllDesc());

        return "blog/blog";
    }

    //블로그 포스트 이동
    @GetMapping("/posts/posts/{id}")
    public String post(@PathVariable Long id, Model model){
        PostsResponseDto dto  =postsService.findById(id);
        model.addAttribute("posts",dto);

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
    public String  dev(){
        return  "dev/dev";
    }

    //검색 결과창 이동
    @GetMapping("/posts/search/{title}")
    public String search(@PathVariable String title , Model model){
        PostsResponseDto dto =postsService.findByTitle(title);
        return "blog/posts_search";
    }

}

