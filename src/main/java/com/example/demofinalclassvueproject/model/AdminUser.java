package com.example.demofinalclassvueproject.model;

public class AdminUser {
    private int id;
    private String adminname;
    private String adminpsw;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdminpsw() {
        return adminpsw;
    }

    public void setAdminpsw(String adminpsw) {
        this.adminpsw = adminpsw;
    }
}
