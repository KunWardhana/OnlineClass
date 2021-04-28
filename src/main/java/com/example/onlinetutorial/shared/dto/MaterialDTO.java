package com.example.onlinetutorial.shared.dto;

import com.example.onlinetutorial.io.entity.ClassEntity;

import java.io.Serializable;
import java.util.List;

public class MaterialDTO implements Serializable {
    private static final long serialVersionUID = 129559275676822020L;

    private long id;
    private String materialid;
    private String materialname;
    private String materiallink;
    private String materialnote;
    private List<ClassDTO> classEntities;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMaterialid() {
        return materialid;
    }

    public void setMaterialid(String materialid) {
        this.materialid = materialid;
    }

    public String getMaterialname() {
        return materialname;
    }

    public void setMaterialname(String materialname) {
        this.materialname = materialname;
    }

    public String getMateriallink() {
        return materiallink;
    }

    public void setMateriallink(String materiallink) {
        this.materiallink = materiallink;
    }

    public String getMaterialnote() {
        return materialnote;
    }

    public void setMaterialnote(String materialnote) {
        this.materialnote = materialnote;
    }

    public List<ClassDTO> getClassEntities() {
        return classEntities;
    }

    public void setClassEntities(List<ClassDTO> classEntities) {
        this.classEntities = classEntities;
    }
}
