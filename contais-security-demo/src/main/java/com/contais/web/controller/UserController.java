package com.contais.web.controller;

import com.contais.dto.User;
import com.contais.exception.UserNotExistException;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @DeleteMapping("/{id:\\d+}")
    public void delere(@PathVariable String id){
        System.out.println(id);
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors){

        if (errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> {
                FieldError filedError = (FieldError) error;
                String message = filedError.getField() + " " + filedError.getDefaultMessage();
                System.out.println(message);
            });
        }

        System.out.println(user);
        user.setId("1");
        return user;
    }
    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult errors){

        if (errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        System.out.println(user);
        user.setId("1");
        return user;
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(@RequestParam(name = "username", required = true, defaultValue = "contais") String nickname) throws Exception {

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

//        throw new UserNotExistException(id);

        System.out.println("进入getInfo方法");

        User user = new User();
        user.setUsername("contais");
        return user;
    }
}
