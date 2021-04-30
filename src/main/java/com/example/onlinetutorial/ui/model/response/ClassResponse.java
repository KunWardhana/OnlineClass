package com.example.onlinetutorial.ui.model.response;

import com.example.onlinetutorial.shared.dto.UserDTO;

import java.time.LocalDateTime;
import java.util.List;

public class ClassResponse {
    private String classid;
    private String classname;
    private LocalDateTime classDateTime;
    private List<UserDTO> list;

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
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


    public List<UserDTO> getList() {
        return list;
    }

    public void setList(List<UserDTO> list) {
        this.list = list;
    }
}
