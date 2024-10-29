package cn.xiaosuli.firstapp;

import androidx.annotation.DrawableRes;

public class BookRvItem {
    @DrawableRes
    private Integer cover;
    /* 书名 */
    private String bookName;
    /* 作者 */
    private String author;
    /* 出版社 */
    private String publishingHouse;
    /* 价格 */
    private String price;

    public BookRvItem(Integer cover, String bookName, String author, String publishingHouse, String price) {
        this.cover = cover;
        this.bookName = bookName;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.price = price;
    }

    public Integer getCover() {
        return cover;
    }

    public void setCover(Integer cover) {
        this.cover = cover;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
