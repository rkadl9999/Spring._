package Hyeonuk.Blog.controller;

import Hyeonuk.Blog.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @PostMapping("/join")
    public String signUp(Member memberForm) {
        return "index";
    }
}
