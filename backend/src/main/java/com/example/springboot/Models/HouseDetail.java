package com.example.springboot.Models;

public class HouseDetail {
    public String Name;
    public String Owner;
    public String Rent;

    public HouseDetail(String name, String owner, String rent){
        this.Name = name;
        this.Owner = owner;
        this.Rent = rent;
    }

    public void SetDetails(String name, String owner, String rent){
        this.Name = name;
        this.Owner = owner;
        this.Rent = rent;
    }
}
