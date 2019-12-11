package com.example.kuy.ui.home;

public class Model {
    int image;
    String name, title, desc;

    public Model(int image, String name, String desc,String title){
        this.image = image;
        this.name = name;
        this.desc = desc;
        this.title=title;

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String birth) {
        this.desc = desc;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




}
