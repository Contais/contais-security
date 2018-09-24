package com.contais.web.controller;

import com.contais.dto.User;
import com.contais.exception.UserNotExistException;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @ApiOperation("删除用户")
    public void delere(@ApiParam("用户id") @PathVariable String id){
        System.out.println(id);
    }

    @PutMapping("/{id:\\d+}")
    @ApiOperation("更新用户信息")
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
    @ApiOperation("创建用户")
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
    @ApiOperation("查询用户列表")
    public List<User> query(@ApiParam("用户昵称") @RequestParam(name = "username", required = true, defaultValue = "contais") String nickname) throws Exception {

        System.out.println(nickname);

        ArrayList<User> list = new ArrayList<>();
        list.add(new User());
        list.add(new User());
        list.add(new User());
        return list;
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation("查询用户详情")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@ApiParam("用户id") @PathVariable String id){

//        throw new UserNotExistException(id);

        System.out.println("进入getInfo方法");

        User user = new User();
        user.setUsername("contais");
        return user;
    }
}
