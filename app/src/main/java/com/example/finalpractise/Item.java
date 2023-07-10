package com.example.finalpractise;

public class Item {
    private int imageResId;
    private String text;

    private int videoResId;

    public Item(int imageResId, String text,int videoResId) {
        this.imageResId = imageResId;
        this.text = text;
        this.videoResId = videoResId;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getText() {
        return text;
    }

    public int getVideoResId() {
        return videoResId;
    }
}