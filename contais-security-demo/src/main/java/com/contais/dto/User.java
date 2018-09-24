package com.contais.dto;

import com.contais.validator.MyConstraint;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * @author Contais
 * @version 1.0
 * @description com.contais.dto
 * @date 2018/8/14
 */
@Data
public class User {

    public interface UserSimpleView{};
    public interface UserDetailView extends UserSimpleView{};

    @JsonView(UserSimpleView.class)
    @ApiModelProperty("用户id")
    private String id;

    @JsonView(UserSimpleView.class)
    @MyConstraint(message = "div valid annotation")
    @ApiModelProperty("用户名")
    private String username;

    @JsonView(UserDetailView.class)
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty("密码")
    private String password;

    @JsonView(UserSimpleView.class)
    @ApiModelProperty("生日")
    private Date birthday;


}
