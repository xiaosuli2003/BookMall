package cn.xiaosuli.firstapp;

import androidx.annotation.DrawableRes;

public class BookRvItem {
    @DrawableRes
    private Integer image;
    private String text;

    public BookRvItem(Integer image, String text) {
        this.image = image;
        this.text = text;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
