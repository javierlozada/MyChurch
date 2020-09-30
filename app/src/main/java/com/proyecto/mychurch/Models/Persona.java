package com.proyecto.mychurch.Models;

public class Persona {
    String id;
    String email;
    String name;
    String birthday;
    String image;

    public Persona(String id, String email, String name, String birthday, String image) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.birthday = birthday;
        this.image = image;
    }


    public Persona(String id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
