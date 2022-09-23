package com.pw3.model;

public class Pessoa {

    private static int ID = 0;
    private Integer id;
    private String name;
    private String email;
    private String phone;

    
    public Pessoa() {
        id = -1;
        name = "";
        email = "";
        phone = "";
    }


    public Pessoa(String name, String email, String phone) {
        ID++;
        this.id = ID;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }


    public Pessoa(Integer id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }

}
