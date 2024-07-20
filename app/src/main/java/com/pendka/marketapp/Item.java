package com.pendka.marketapp;

public class Item {
    private int img;
    private String title;
    private String desc;

    public Item(int image, String title, String desc) {
        this.img = image;
        this.title = title;
        this.desc = desc;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String description) {
        desc = description;
    }
}
