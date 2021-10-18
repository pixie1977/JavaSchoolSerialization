package ru.common.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SampleController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable(required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/sample")
    public String showForm() {
        return "sample";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }


}
