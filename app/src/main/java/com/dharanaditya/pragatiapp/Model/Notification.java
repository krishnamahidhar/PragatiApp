package com.dharanaditya.pragatiapp.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dharan1011 on 29/11/16.
 */

// Todo : Review before final release


public class Notification {
    private String title;
    private String messege;
    private String author;
    private String timeStamp;
    private String branch;
    private String sem;
    boolean read;

    public Notification() {
    }

    public Notification(String title, String messege, String author) {
        this.title = title;
        this.messege = messege;
        this.author = author;
        read = false;
        timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm").format(new Date());
    }

    public Notification(String branch, String title) {
        this.branch = branch;
        this.title = title;
        timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm").format(new Date());

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

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
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
