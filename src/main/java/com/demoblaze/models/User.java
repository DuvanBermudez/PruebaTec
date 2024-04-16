package com.demoblaze.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {
    private String name;
    private String creditCard;
    private String strUserName;
    private String strPassword;
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public User(String strUserName, String strPassword) {
        this.strUserName = strUserName+now.format(formatter);
        this.strPassword = strPassword;
    }

    public User(){
        this.name = "Duvan";
        this.creditCard = "12321434523";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getStrUserName() {
        return strUserName;
    }

    public void setStrUserName(String strUserName) {
        this.strUserName = strUserName;
    }

    public String getStrPassword() {
        return strPassword;
    }

    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }
}
