package com.example.btvnbuoi5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyview);
        List<Waifu> list=new ArrayList<>();
        list=(waifuList());
        Waifu_Adaptor adapter=new Waifu_Adaptor(this,list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
    static List<Waifu> waifuList()
    {
        List<Waifu> list =new ArrayList<>();
        list.add(new Waifu(R.drawable.g1,"waifu1","Gioi tinh: Nu","Gia: 100.000.000"));
        list.add(new Waifu(R.drawable.g2,"waifu2","Gioi tinh: Nu","Gia: 200.000.000"));
        list.add(new Waifu(R.drawable.g3,"waifu3","Gioi tinh: Nu","Gia: 3.000.000.000"));
       // list.add(new Waifu(R.drawable.g4,"waifu4","Gioi tinh: Nu","Gia: 400.000.000"));
        list.add(new Waifu(R.drawable.g5,"waifu5","Gioi tinh: Nu","Gia: 500.000.000"));
        list.add(new Waifu(R.drawable.g6,"waifu6","Gioi tinh: Nu","Gia: 1.000.000.000"));
        list.add(new Waifu(R.drawable.g7,"waifu7","Gioi tinh: Nu","Gia: 700.000.000"));
        list.add(new Waifu(R.drawable.g8,"waifu8","Gioi tinh: Nu","Gia: 800.000.000"));
        return list;
    }
}