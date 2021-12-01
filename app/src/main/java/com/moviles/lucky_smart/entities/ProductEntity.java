package com.moviles.lucky_smart.entities;

import androidx.recyclerview.widget.RecyclerView;


import java.io.Serializable;

public class ProductEntity implements Serializable {
    private int idProduct;
    private String nameProduct;
    private int valueProduct;
    private String categoryProduct;
    private int amountProduct;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getValueProduct() {
        return valueProduct;
    }

    public void setValueProduct(int valueProduct) {
        this.valueProduct = valueProduct;
    }

    public String getCategoryProduct() {
        return categoryProduct;
    }

    public void setCategoryProduct(String categoryProduct) {
        this.categoryProduct = categoryProduct;
    }

    public int getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(int amountProduct) {
        this.amountProduct = amountProduct;
    }

}
