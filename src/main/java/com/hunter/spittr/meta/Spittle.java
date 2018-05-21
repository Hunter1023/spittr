package com.hunter.spittr.meta;

import javax.validation.constraints.Size;
import java.util.Date;

public class Spittle {
    private Long id;

    @Size(min = 1, max = 280, message = "微博不得为空，且要少于140字")
    private String message;

    private Date time;

    public Spittle() {
    }

    public Spittle(String message, Date time) {
        this.id = null;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
