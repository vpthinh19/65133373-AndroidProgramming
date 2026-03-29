package com.vpt.appcom;

import android.widget.ImageView;
import android.widget.TextView;

public class Data {
    private String name;
    private String price;
    private String description;
    private int avatar;

    public Data(int avatar, String description, String name, String price) {
        this.avatar = avatar;
        this.description = description;
        this.name = name;
        this.price = price;
    }

    public int getAvatar() {
        return avatar;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
