package com.example.buoi7;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DataSQLite dataSQLite;
    List<Note> list = new ArrayList<>();
    static RecyAdapter adapter;
    static RecyclerView recyclerView;
    Button create;
    EditText addContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       

        dataSQLite = new DataSQLite(this);

        recyclerView = findViewById(R.id.recy);
        create = findViewById(R.id.create);
        addContent = findViewById(R.id.addContent);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataSQLite.QueryData("INSERT INTO notes VALUES (null,'"+addContent.getText().toString()+"')");
                addContent.setText("");
                Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                getData();
            }
        });

        getData();
    }

    public void getData() {
        Cursor listNote = dataSQLite.getAllData("SELECT * FROM notes");
        list.clear();
        while (listNote.moveToNext()){
            int id= listNote.getInt(0);
            String content = listNote.getString(1);
            list.add(new Note(id, content));
        }
        adapter = new RecyAdapter(this, list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}