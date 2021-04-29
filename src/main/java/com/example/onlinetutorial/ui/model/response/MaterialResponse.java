package com.example.onlinetutorial.ui.model.response;

public class MaterialResponse {

    private String materialid;
    private String materialname;
    private String materiallink;
    private String materialnote;
    private boolean isDeleted;

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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
