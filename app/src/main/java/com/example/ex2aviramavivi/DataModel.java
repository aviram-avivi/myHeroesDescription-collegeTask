package com.example.ex2aviramavivi;

public class DataModel {
    String name;
    String description;
    int id_;
    int image;

    public DataModel(String name, String description, int id_, int image){
        this.name = name;
        this.description = description;
        this.id_ = id_;
        this.image = image;
    }

    public String getName(){return name;}
    public String getDescription(){return description;}
    public int getId_(){return id_;}
    public int getImage(){return image;}
}
