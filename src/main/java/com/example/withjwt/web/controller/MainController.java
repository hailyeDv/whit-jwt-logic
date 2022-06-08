package com.example.withjwt.web.controller;

import com.example.withjwt.web.dto.LoginDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

    @GetMapping
    public String main() {
        return "index";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute LoginDto loginDto) {
        return "login";
    }
}
