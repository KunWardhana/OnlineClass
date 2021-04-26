package com.example.onlinetutorial.ui.model.request;

import java.time.LocalDateTime;

public class ClassRequest {
    private String classname;
    private LocalDateTime classDateTime;

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
