package com.example.ex2aviramavivi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    private ArrayList<DataModel> dataSet;
    private ItemClickListener clickListener;

    public CustomAdapter(ArrayList<DataModel> dataSet, ItemClickListener clickListener){
        this.dataSet = dataSet;
        this.clickListener = clickListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView textViewName;
        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            textViewName = itemView.findViewById(R.id.textViewNameForCard);
            imageViewIcon = itemView.findViewById(R.id.imageViewForCard);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int posTemp = position;

        TextView textViewName = holder.textViewName;
        ImageView imageView = holder.imageViewIcon;
        CardView cardView = holder.cardView;

        textViewName.setText(dataSet.get(position).getName());
        imageView.setImageResource(dataSet.get(position).getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onItemClick(dataSet.get(posTemp));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    public interface ItemClickListener{
        public void onItemClick(DataModel dataSet);
    }
}
