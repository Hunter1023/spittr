package com.hunter.spittr.meta;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Spitter {

    private long id;

    @Pattern(regexp = "^[a-zA-Z0-9_]{5,16}$", message = "{username.size}")
    private String username;

    @Size(min = 8, max = 25, message = "{password.size}")
    private String password;

    /*Email的验证，前端的input type设为email时，就对其进行了格式的把控
            干脆把email格式的验证完全交给前端；关于Email有效性的判断之后再实现*/
    @Email(regexp = "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$",
            message = "{email.valid}")
    private String email;

    private String headIcon;

    @Pattern(regexp = "^[\u4e00-\u9fa5a-zA-Z0-9_]{4,16}$", message = "{nickname.size")
    private String nickname;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
