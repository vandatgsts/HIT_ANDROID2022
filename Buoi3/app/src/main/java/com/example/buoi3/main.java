package com.example.buoi3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class main extends AppCompatActivity {
    private TextView tk,mk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Intent intent=getIntent();
        acccout ACC=intent.getParcelableExtra("accout");
        tk=findViewById(R.id.tk);
        mk=findViewById(R.id.mk);
        tk.setText(ACC.getTk());
        mk.setText(ACC.getMk());

    }
}