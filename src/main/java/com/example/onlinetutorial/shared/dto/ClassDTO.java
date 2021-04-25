package com.example.onlinetutorial.shared.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class ClassDTO implements Serializable {
    private static final long serialVersionUID= -6979430123613106034L;
    private long id;
    private String classname;
    private LocalDateTime classDateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public LocalDateTime getClassDateTime() {
        return classDateTime;
    }

    public void setClassDateTime(LocalDateTime classDateTime) {
        this.classDateTime = classDateTime;
    }
}
