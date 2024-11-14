package cn.xiaosuli.bookmall.model;

import androidx.annotation.DrawableRes;

import java.util.ArrayList;
import java.util.List;

import cn.xiaosuli.bookmall.R;

public class BookItem {

    public static List<BookItem> getBookList() {
        var list = new ArrayList<BookItem>();
        for (int i = 0; i < 3; i++) {
            list.add(new BookItem(R.drawable.book1, "计算机组成原理(第3版)", "唐朔飞", "高等教育出版社", "35.00"));
            list.add(new BookItem(R.drawable.book2, "计算机网络教材", "谢希仁", "电子工业出版社", "45.00"));
            list.add(new BookItem(R.drawable.book3, "成事之道", "未知作者", "未知出版社", "99.00"));
            list.add(new BookItem(R.drawable.book4, "Python编程：从入门到实践", "未知作者", "人民邮电出版社", "109.80"));
            list.add(new BookItem(R.drawable.book5, "计算机科学导论", "贝赫鲁兹·佛罗赞(Behrouz A.Forouzan)", "机械工业出版社", "89.00"));
            list.add(new BookItem(R.drawable.book6, "计算机组成与设计硬件软件接口", "未知作者", "机械工业出版社", "169.00"));
            list.add(new BookItem(R.drawable.book7, "Java编程思想", "陈昊鹏", "人民邮电出版社", "100.00"));
            list.add(new BookItem(R.drawable.book8, "算法导论", "科曼", "机械工业出版社", "128.00"));
            list.add(new BookItem(R.drawable.book9, "人工智能", "Stuart J. Russell,Peter Norvig", "清华大学出版社", "58.20"));
            list.add(new BookItem(R.drawable.book10, "算法竞赛", "罗勇军，郭卫斌", "清华大学出版社", "168.00"));
            list.add(new BookItem(R.drawable.book11, "这就是ChatGPT", "斯蒂芬·沃尔弗拉姆", "人民邮电出版社", "59.00"));
            list.add(new BookItem(R.drawable.book12, "Python数据分析-从零基础入门到案例实战", "余本国", "北京理工大学出版社", "89.00"));
            list.add(new BookItem(R.drawable.book13, "深入理解高并发编程:JDK核心技术", "冰河", "电子工业出版社", "129.00"));
            list.add(new BookItem(R.drawable.book14, "算法图解+啊哈算法", "Aditya Bhargava 啊哈磊", "人民邮电出版社", "94.00"));
            list.add(new BookItem(R.drawable.book15, "Jetpack Compose 从入门到实战", "王鹏，关振智，曾思淇", "机械工业育出版社", "109.00"));
            list.add(new BookItem(R.drawable.book16, "Arduino 入门基础教程", "余静", "人民邮电出版社", "49.00"));
            list.add(new BookItem(R.drawable.book17, "Apache Pulsar实战", "戴维·克杰鲁姆加德", "人民邮电出版社", "109.80"));
            list.add(new BookItem(R.drawable.book18, "Python语言程序设计", "教育部考试中心", "高等教育出版社", "48.00"));
            list.add(new BookItem(R.drawable.book19, "C++ Primer Plus中文版第6版", "张海龙", "人民邮电出版社", "118.00"));
            list.add(new BookItem(R.drawable.book20, "Visual Studio Code 权威指南", "韩骏", "电子工业出版社", "99.00"));
        }
        return list;
    }

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

    public BookItem(Integer cover, String bookName, String author, String publishingHouse, String price) {
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
