package com.dharanaditya.pragatiapp.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dharan1011 on 29/11/16.
 */

// Todo : Review before final release


public class Notification {
    private String branch, sem, head, body, timestamp, author, link;

    boolean read;


    public Notification() {

    }

    public Notification(String branch, String sem, String head, String body, String author, String link) {
        this.branch = branch;
        this.sem = sem;
        this.head = head;
        this.body = body;
        this.author = author;
        this.link = link;
        this.timestamp = new SimpleDateFormat("dd.MM.yy 'at' HH:mm").format(new Date());
        this.read = false;
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

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
                "branch='" + branch + '\'' +
                ", sem='" + sem + '\'' +
                ", head='" + head + '\'' +
                ", body='" + body + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", author='" + author + '\'' +
                ", link='" + link + '\'' +
                ", read=" + read +
                '}';
    }
}
