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
    private String nickname;
    //用于展示动态对应的用户头像缩略图
    private String thumbnail;

    public Spittle() {
    }

    public Spittle(String message, Date time, Long userId,
                   String nickname, String thumbnail) {
        this.id = null;
        this.message = message;
        this.time = time;
        this.userId = userId;
        this.nickname = nickname;
        this.thumbnail = thumbnail;
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


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
