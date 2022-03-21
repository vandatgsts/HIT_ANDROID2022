package com.example.btvnbuoi5;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class Waifu_Adaptor extends RecyclerView.Adapter<Waifu_Adaptor.ViewHolder> {
    Context context;
    List<Waifu> list1;

    public Waifu_Adaptor(Context context, List<Waifu> list) {
        this.context = context;
        this.list1 = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(this.context).inflate(R.layout.waifu,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Waifu waifu=list1.get(position);
        holder.image.setImageResource(waifu.getImage());
        holder.type.setText(waifu.getType());
        holder.name.setText(waifu.getName());
        holder.price.setText(waifu.getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.itemView.setBackgroundColor(Color.parseColor("#F2C0E5"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list1.isEmpty()?0:list1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView type,name,price;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            type=itemView.findViewById(R.id.type);
            name=itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);
            image=itemView.findViewById(R.id.imag1e);
        }
    }
}
