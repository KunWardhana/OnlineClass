package com.example.onlinetutorial.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "materialtabel")
public class MaterialEntity implements Serializable {
    private static final long serialVersionUID = -3650266302760546568L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private String materialid;

    @Column(nullable = false)
    private String materialname;

    @Column(nullable = false)
    private String materiallink;

    @Column(nullable = false)
    private String materialnote;

    @OneToMany(mappedBy = "classcol", fetch = FetchType.LAZY)
    private List<Header_MaterialEntity> classEntities = new ArrayList<>();


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

    public List<Header_MaterialEntity> getClassEntities() {
        return classEntities;
    }

    public void setClassEntities(List<Header_MaterialEntity> classEntities) {
        this.classEntities = classEntities;
    }
}
