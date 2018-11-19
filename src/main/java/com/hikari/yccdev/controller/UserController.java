package com.hikari.yccdev.controller;


import com.hikari.yccdev.domain.User;
import com.hikari.yccdev.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/person/save")
    public User save(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        if(userRepository.save(user)) {
            System.out.printf("hikari success 用户是: %s 哦 \n", user);
        }
        return user;
    }
}
