package com.jojoldu.book.spring.web;

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
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        SessionUser user =(SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getName());
        }
        return "index";
    }
    @GetMapping("/posts/new")
    public String index1(Model model1) {
        model1.addAttribute("posts", postsService.findDesc());
        return "newindex";
    }
    @GetMapping("/api/v1/posts/revise/{id}")
    public String revise(@PathVariable Long id ){
        postsService.revise(id);
        return "/";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id ,Model model){
        PostsResponseDto dto =postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }

}
