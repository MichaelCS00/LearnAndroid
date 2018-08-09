package com.example.michaelcs.materialtest;

/**
 * Create by MichaelCS on 2018/8/9 12:11
 * Email: junhong@turingpic.com
 */
public class Book {
    private String name;
    private int imageId;
    public Book(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
