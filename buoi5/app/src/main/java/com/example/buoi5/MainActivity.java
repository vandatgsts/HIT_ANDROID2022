package com.example.buoi5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=findViewById(R.id.recy);
        List<String> list= new ArrayList<>();
        list=Tao();
        RecylAdapter adapter = new RecylAdapter(this,list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    public static List Tao()
    {
        List<String> list= new ArrayList<>();
        list.add("Van Dat1");list.add("Van Dat2");list.add("Van Dat3");list.add("Van Dat4");list.add("Van Dat5");list.add("Van Dat6");
        return list;
    }
}