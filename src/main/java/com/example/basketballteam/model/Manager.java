package com.example.basketballteam.model;

public class Manager {
    private int managerId;
    private String managerPassword;
    private String managerName;
    private String managerTel;
    private int managerPower;
    private String managerImage;

    public Manager() {

    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerTel() {
        return managerTel;
    }

    public void setManagerTel(String managerTel) {
        this.managerTel = managerTel;
    }

    public int getManagerPower() {
        return managerPower;
    }

    public void setManagerPower(int managerPower) {
        this.managerPower = managerPower;
    }

    public String getManagerImage() {
        return managerImage;
    }

    public void setManagerImage(String managerImage) {
        this.managerImage = managerImage;
    }

    public Manager(int managerId, String managerPassword, String managerName, String managerTel, int managerPower, String managerImage) {
        this.managerId = managerId;
        this.managerPassword = managerPassword;
        this.managerName = managerName;
        this.managerTel = managerTel;
        this.managerPower = managerPower;
        this.managerImage = managerImage;

    }
}
