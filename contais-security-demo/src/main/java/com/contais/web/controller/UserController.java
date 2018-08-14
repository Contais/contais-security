package com.contais.web.controller;

import com.contais.dto.User;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Contais
 * @version 1.0
 * @description com.contais.web.controller
 * @date 2018/8/14
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(@RequestParam(name = "username", required = true, defaultValue = "contais") String nickname){

        System.out.println(nickname);

        ArrayList<User> list = new ArrayList<>();
        list.add(new User());
        list.add(new User());
        list.add(new User());
        return list;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable String id){
        User user = new User();
        user.setUsername("contais");
        return user;
    }
}
