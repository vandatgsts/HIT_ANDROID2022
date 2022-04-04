package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Monan_apdapter extends RecyclerView.Adapter<Monan_apdapter.Viewhodel> {
    private Context context;
    private List<monan> Listmonan;

    public Monan_apdapter(Context context, List<monan> listmonan) {
        this.context = context;
        Listmonan = listmonan;
    }

    @NonNull
    @Override
    public Viewhodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.activity_monan,parent,false);
        Viewhodel viewhodel=new Viewhodel(view);
        return viewhodel;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewhodel holder, int position) {
        monan Monan=Listmonan.get(position);
        position =holder.getAdapterPosition();
        Picasso.get().load(Listmonan.get(position).getAvt()).into(holder.foodimg);
        holder.foodName.setText(Monan.getMonanname());
        holder.foodPrice.setText(Monan.getTien());
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hiencongthuc(Monan);
            }
        });
    }
    public void hiencongthuc(monan Monan)
    {
        Intent intent=new Intent(context,congthuc.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("Monan",Monan);
        intent.putExtras(bundle);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
    @Override
    public int getItemCount() {
        return Listmonan.isEmpty()?0:Listmonan.size();
    }

    public class Viewhodel extends RecyclerView.ViewHolder {
        private ImageView foodimg;
        private TextView foodName,foodPrice;
        LinearLayout item;
        public Viewhodel(@NonNull View itemView) {
            super(itemView);
            foodimg=itemView.findViewById(R.id.anhmonan);
            foodName=itemView.findViewById(R.id.tenmonan);
            foodPrice=itemView.findViewById(R.id.giamonan);
            item=itemView.findViewById(R.id.item);
        }
    }
}
