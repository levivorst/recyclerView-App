package com.example.recyclerviewapp;

import com.google.firebase.storage.StorageReference;

public class dataModel {


    String name;
    String version;
    int _id;
    int image;


    public dataModel(String name, String version, int _id, int image){
        this.name= name;
        this.version = version;
        this._id= _id;
        this.image=image;
    }


    public String getName(){
        return name;
    }

    public String getVersion(){
        return version;
    }
    public int get_id(){
        return _id;
    }
    public int getImage(){
        return image;
    }
}
