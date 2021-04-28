package com.example.onlinetutorial.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Header_MaterialEntity implements Serializable {
    private static final long serialVersionUID= -2904541891716627468L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "classid")
    private ClassEntity classcol;

    @ManyToOne()
    @JoinColumn(name = "materialid")
    private MaterialEntity materialEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ClassEntity getClasscol() {
        return classcol;
    }

    public void setClasscol(ClassEntity classcol) {
        this.classcol = classcol;
    }

    public MaterialEntity getMaterialEntity() {
        return materialEntity;
    }

    public void setMaterialEntity(MaterialEntity materialEntity) {
        this.materialEntity = materialEntity;
    }
}
