package com.dharanaditya.pragatiapp.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dharan1011 on 29/11/16.
 */

// Todo : Review before final release

public class Examination {
    private String branch;
    private String year;
    private String sem;
    private String title;
    private String message;
    private String author;
    private String timeStamp;
    private String examDate;
    private String link;
    private boolean read;

    public Examination() {
    }

    public Examination(String branch, String year, String title, String message, String author,String sem) {
        this.branch = branch;
        this.year = year;
        this.title = title;
        this.message = message;
        this.author = author;
        this.sem = sem;
        timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm").format(new Date());

    }

    public Examination(String branch, String sem, String title) {
        this.branch = branch;
        this.sem = sem;
        this.title = title;
        timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm").format(new Date());
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
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
        return "Examination{" +
                "branch='" + branch + '\'' +
                ", year='" + year + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", author='" + author + '\'' +
                ", timeStamp=" + timeStamp +
                ", examDate='" + examDate + '\'' +
                ", link='" + link + '\'' +
                ", read=" + read +
                '}';
    }
}
