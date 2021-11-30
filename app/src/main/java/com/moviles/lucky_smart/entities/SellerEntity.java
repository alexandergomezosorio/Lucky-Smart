package com.moviles.lucky_smart.entities;

import java.io.Serializable;

public class SellerEntity implements Serializable {
    private int idSeller;
    private String emailSeller;
    private String passwordSeller;
    private String nameSeller;
    private String citySeller;
    private String nameShop;

    public int getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(int idSeller) {
        this.idSeller = idSeller;
    }

    public String getEmailSeller() {
        return emailSeller;
    }

    public void setEmailSeller(String emailSeller) {
        this.emailSeller = emailSeller;
    }

    public String getPasswordSeller() {
        return passwordSeller;
    }

    public void setPasswordSeller(String passwordSeller) {
        this.passwordSeller = passwordSeller;
    }

    public String getNameSeller() {
        return nameSeller;
    }

    public void setNameSeller(String nameSeller) {
        this.nameSeller = nameSeller;
    }

    public String getCitySeller() {
        return citySeller;
    }

    public void setCitySeller(String citySeller) {
        this.citySeller = citySeller;
    }

    public String getNameShop() {
        return nameShop;
    }

    public void setNameShop(String nameShop) {
        this.nameShop = nameShop;
    }
}

