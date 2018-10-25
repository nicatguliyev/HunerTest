package com.example.artservis.hunertest.Model;

/**
 * Created by Art Servis on 10/25/2018.
 */

public class DetailModel {
    private String detailName;
    private String price;
    private int detailImg;


    public DetailModel(String detailName, String price, int detailImg) {
        this.detailName = detailName;
        this.price = price;
        this.detailImg = detailImg;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getDetailImg() {
        return detailImg;
    }

    public void setDetailImg(int detailImg) {
        this.detailImg = detailImg;
    }
}
