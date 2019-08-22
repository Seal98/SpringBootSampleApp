package com.example.sweater.controller;

import com.example.sweater.domain.Message;
import com.example.sweater.domain.Role;
import com.example.sweater.domain.User;
import com.example.sweater.repos.MessageRepo;
import com.example.sweater.repos.UserRepo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping
    public String userList(Model model){
        List<Message> m = messageRepo.fetchEmpDeptDataRightJoin();
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "userlist";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "usereditor";
    }

    @GetMapping(params = {"sampleparam"})
    public String sampleRequest(@RequestParam(name = "sampleparam") String sample, Model model){

        return "userlist";
    }

    @PostMapping
    public String save(@RequestParam("userId") User user, @RequestParam Map<String, String> form, @RequestParam("username") String username){
        user.setUsername(username);
        Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
        for(String key : form.keySet()){
            if(roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepo.save(user);
        return "redirect:/user";
    }

}
