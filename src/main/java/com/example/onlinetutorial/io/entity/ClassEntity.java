package com.example.onlinetutorial.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ClassEntity implements Serializable {
    private static final long serialVersionUID = 3766950894830135757L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private String classname;

    @Column(nullable = false)
    private String classid;

    @Column(nullable = false)
    private LocalDateTime classDateTime;

    @OneToMany(orphanRemoval = true, mappedBy = "classEntity", cascade = CascadeType.ALL)
    private List<UserEntity> userEntities = new ArrayList<>();

    @OneToMany(mappedBy = "materialEntity", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Header_MaterialEntity> materialEntities = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public List<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(List<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    public List<Header_MaterialEntity> getMaterialEntities() {
        return materialEntities;
    }

    public void setMaterialEntities(List<Header_MaterialEntity> materialEntities) {
        this.materialEntities = materialEntities;
    }
}
