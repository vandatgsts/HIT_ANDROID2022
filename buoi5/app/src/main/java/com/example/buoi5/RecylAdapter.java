package com.example.buoi5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecylAdapter extends RecyclerView.Adapter<RecylAdapter.ViewHolder> {
    Context context;
    List<String> list;

    public RecylAdapter(Context context,List<String> list) {
        this.list = list;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(this.context).inflate(R.layout.item_rely,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String str=list.get(position);
        holder.textView.setText(str);
    }



    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.txt);
        }
    }
}
