package com.example.covidvaccine;

public class MainModel {

    String name,address,contact,h1pic,date,time,state,district;


    MainModel()
    {

    }
    public MainModel(String name, String address, String contact, String date, String time,String state,String district) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.h1pic = h1pic;
        this.date = date;
        this.time = time;
        this.state = time;
        this.district = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getH1pic() {
        return h1pic;
    }

    public void setH1pic(String h1pic) {
        this.h1pic = h1pic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public  String getState() {return state; }

    public  void getState(String state) { this.state = state;}

    public  String getDistrict() {return district; }

    public  void getDistrict(String district) { this.district = district;}



}
