package com.dharanaditya.pragatiapp.Model;

/**
 * Created by dharan1011 on 29/11/16.
 */

// Todo : Review before final release

public class Examination extends Notification{
    public Examination() {

    }

    public Examination(String branch, String sem, String head, String body, String author, String link) {
        super(branch, sem, head, body, author, link);
    }

    @Override
    public String toString() {
        return "Notification{" +
                "branch='" + getBranch() + '\'' +
                ", sem='" + getSem() + '\'' +
                ", head='" + getHead() + '\'' +
                ", body='" + getBody() + '\'' +
                ", timestamp='" + getTimestamp() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", link='" + getLink() + '\'' +
                ", read=" + read +
                '}';
    }
}
