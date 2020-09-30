package com.proyecto.mychurch.Models;

public class ModelFeed {
    int likes, comments, postpic, propic;
    String name, time, status;

    public ModelFeed(int likes, int comments, int postpic, String name, String time, String status, int propic) {
        this.likes = likes;
        this.comments = comments;
        this.postpic = postpic;
        this.name = name;
        this.time = time;
        this.status = status;
        this.propic = propic;
    }


    public int getPropic() {
        return propic;
    }

    public void setPropic(int propic) {
        this.propic = propic;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getPostpic() {
        return postpic;
    }

    public void setPostpic(int postpic) {
        this.postpic = postpic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
