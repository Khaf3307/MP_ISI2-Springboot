package com.esmt.sn.mpisi2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.esmt.sn.mpisi2.entities.Message;

@Controller
@RequestMapping("/api")
public class HomeController {

    @RequestMapping("/v1/message")
    public String getMessage(Model model) {
        model.addAttribute("message", new Message("Welcome to my website!"));
        return "index";
    }
}
