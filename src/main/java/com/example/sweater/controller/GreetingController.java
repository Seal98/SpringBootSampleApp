package com.example.sweater.controller;

import com.example.sweater.domain.Message;
import com.example.sweater.domain.User;
import com.example.sweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    private final MessageRepo messageRepo;

    @Autowired
    public GreetingController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping("/")
    public String hello(String name, Map<String, Object> model) {
        return "hello";
    }

    @GetMapping("/main")
    public String greeting(Model model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);
        return "main";
    }

    @GetMapping("/nextPage")
    public String next(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        return "next";
    }

    @GetMapping("/prevPage")
    public String prev(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        model.put("messages", messageRepo.findAll());
        return "main";
    }

    @PostMapping("add")
    public String add(@RequestParam String text,
                      @RequestParam String tag,
                      @AuthenticationPrincipal User user,
                      Map<String, Object> model){
        Message message = new Message(text, tag, user);
        messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        return "main";
    }


    @PostMapping("filter")
    public String filter(@RequestParam String tag, Map<String, Object> model){
        Iterable<Message> messages = messageRepo.findByTag(tag);
        model.put("messages", messages);
        return "main";
    }

}