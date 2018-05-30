package com.hunter.spittr.meta;

import javax.validation.constraints.Size;
import java.util.Date;

public class Spittle {
    private Long id;

    @Size(min = 1, max = 280, message = "微博不得为空，且要少于140字")
    private String message;

    private Date time;

    private Long userId;

    //非数据库内容
    private String username;

    public Spittle() {
    }

    public Spittle(String message, Date time, Long userId) {
        this.id = null;
        this.message = message;
        this.time = time;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTime(Date time) {
        this.time = time;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
