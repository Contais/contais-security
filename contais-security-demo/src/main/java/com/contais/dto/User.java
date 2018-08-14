package com.contais.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Contais
 * @version 1.0
 * @description com.contais.dto
 * @date 2018/8/14
 */
@Getter
@Setter
public class User {

    public interface UserSimpleView{};
    public interface UserDetailView extends UserSimpleView{};

    @JsonView(UserSimpleView.class)
    private String username;

    @JsonView(UserDetailView.class)
    private String password;
}
