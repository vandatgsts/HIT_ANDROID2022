package com.example.buoi3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class login extends AppCompatActivity {
    private EditText tk,mk;
    private CheckBox luu;
    private Button dangnhap,dangky;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        tk= (EditText) findViewById(R.id.idtaikhoan);
        mk=(EditText) findViewById(R.id.idmatkhau);
        dangnhap=findViewById(R.id.dangnhap);
        dangky=findViewById(R.id.dangky);
        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(login.this, main.class);
                acccout ACC=new acccout(tk.getText().toString(),mk.getText().toString());
                ACC.tk=tk.getText().toString();
                ACC.mk=mk.getText().toString();
                intent.putExtra("accout",ACC);
//
//                String AC=tk.getText().toString();
//                intent.putExtra("tk",AC);
//                String Mk=mk.getText().toString();
//                intent.putExtra("mk",Mk);
//                Boolean check=luu.isChecked();
//                intent.putExtra("check",check);
                startActivity(intent);
            }
        });
        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(login.this,register.class);
                startActivity(intent);
            }
        });
    }
}