package com.dharanaditya.pragatiapp.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dharan1011 on 29/11/16.
 */

public class Notification {
    private String title;
    private String messege;
    private String author;
    private String timeStamp;
    boolean read;

    public Notification() {
    }

    public Notification(String title, String messege, String author) {
        this.title = title;
        this.messege = messege;
        this.author = author;
        read = false;
        timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date());
    }

    public Notification(String title, String messege) {
        this.title = title;
        this.messege = messege;
        read = false;
        timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "title='" + title + '\'' +
                ", messege='" + messege + '\'' +
                ", author='" + author + '\'' +
                ", timeStamp=" + timeStamp +
                ", read=" + read +
                '}';
    }
}
