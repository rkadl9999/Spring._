package Hyeonuk.Blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @GetMapping("/")
    public String home() {
        return "index";
    }
}
