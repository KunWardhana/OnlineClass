package com.example.onlinetutorial.shared.dto;


import java.io.Serializable;

public class Header_MaterialDTO implements Serializable {
    private static final long serialVersionUID= 8627815716685111799L;

    private long id;
    ClassDTO classDTO;
    MaterialDTO materialDTO;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ClassDTO getClassEntity() {
        return classDTO;
    }

    public void setClassEntity(ClassDTO classEntity) {
        this.classDTO = classEntity;
    }

    public MaterialDTO getMaterialEntity() {
        return materialDTO;
    }

    public void setMaterialEntity(MaterialDTO materialEntity) {
        this.materialDTO = materialEntity;
    }
}
