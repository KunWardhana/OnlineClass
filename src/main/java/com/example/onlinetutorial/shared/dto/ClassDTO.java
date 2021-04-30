package com.example.onlinetutorial.shared.dto;

import com.example.onlinetutorial.io.entity.MaterialEntity;
import com.example.onlinetutorial.io.entity.UserEntity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class ClassDTO implements Serializable {
    private static final long serialVersionUID= -6979430123613106034L;
    private String classid;
    private String classname;
    private LocalDateTime classDateTime;
//    private List<UserDTO> listUser;
    private MaterialDTO materialDTO;

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

//    public List<UserDTO> getUserEntities() {
//        return listUser;
//    }
//
//    public void setUserEntities(List<UserDTO> userEntities) {
//        this.listUser = userEntities;
//    }

    public MaterialDTO getMaterialEntities() {
        return materialDTO;
    }

    public void setMaterialEntities(MaterialDTO materialEntities) {
        this.materialDTO = materialEntities;
    }
}
