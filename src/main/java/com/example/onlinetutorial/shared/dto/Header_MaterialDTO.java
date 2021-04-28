package com.example.onlinetutorial.shared.dto;


import java.io.Serializable;

public class Header_MaterialDTO implements Serializable {
    private static final long serialVersionUID= 8627815716685111799L;

    private long id;
    ClassDTO classEntity;
    MaterialDTO materialEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ClassDTO getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassDTO classEntity) {
        this.classEntity = classEntity;
    }

    public MaterialDTO getMaterialEntity() {
        return materialEntity;
    }

    public void setMaterialEntity(MaterialDTO materialEntity) {
        this.materialEntity = materialEntity;
    }
}
