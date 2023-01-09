package com.example.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ArrayList<dataModel> dataSet;
    private LinearLayoutManager layoutManager;
    private customAdapter adapter;

    FirebaseStorage storage = FirebaseStorage.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView= findViewById(R.id.RecyclerViewCon);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setItemAnimator(new DefaultItemAnimator());


        dataSet=new ArrayList<dataModel>();


        for(int i=0;i<MyDATA.drawableArray.length ; i++){

//            FirebaseStorage storage = FirebaseStorage.getInstance();
//            StorageReference gsReference = storage.getReferenceFromUrl(MyDATA.drawableArrays[i]);


            dataSet.add(new dataModel(MyDATA.nameArray[i],MyDATA.vesionArray[i],MyDATA._id[i] ,MyDATA.drawableArray[i]));
        }
        adapter = new customAdapter(dataSet);
        recyclerView.setAdapter(adapter);

    }
}