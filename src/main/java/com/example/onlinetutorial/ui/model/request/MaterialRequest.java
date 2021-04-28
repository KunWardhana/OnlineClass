package com.example.onlinetutorial.ui.model.request;

import com.example.onlinetutorial.io.entity.ClassEntity;

import java.util.List;

public class MaterialRequest {
    private String materialname;
    private String materiallink;
    private String materialnote;

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
}
