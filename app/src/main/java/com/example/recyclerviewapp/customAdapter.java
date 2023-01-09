package com.example.recyclerviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class customAdapter extends RecyclerView.Adapter<customAdapter.MyviewHolder>{
    FirebaseStorage storage = FirebaseStorage.getInstance();

    private ArrayList<dataModel> dataSet;

    public customAdapter(ArrayList<dataModel> dataSet){
        this.dataSet = dataSet;
    }



    public static class MyviewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView  textViewName;
        TextView textViewVersion;
        ImageView imageView;


        public MyviewHolder(View itemView){
            super(itemView);


            cardView = itemView.findViewById(R.id.cardPage);
            textViewName= itemView.findViewById(R.id.textView);
            textViewVersion = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        MyviewHolder myviewHolder = new MyviewHolder(view);


        return myviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        ImageView  imageView = holder.imageView;
        CardView cardView = holder.cardView;

//        StorageReference gsReference = storage.getReferenceFromUrl(MyDATA.drawableArrays[position]);
            textViewName.setText(dataSet.get(position).getName());
            textViewVersion.setText(dataSet.get(position).getVersion());


            imageView.setImageResource(dataSet.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
