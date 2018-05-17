package com.hunter.spittr.meta;

import java.util.Date;

public class Spittle {
    private Long id;
    private String message;
    private Date time;


    public Spittle(String message, Date time) {
        id = null;
        this.message = message;
        this.time = time;
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

}
