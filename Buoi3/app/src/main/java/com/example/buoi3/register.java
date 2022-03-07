package com.example.buoi3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    private EditText taikhoan,matkhau,laimatkhau;
    private CheckBox dieukhoan;
    private Button dangky;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getId();
        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register.this,main.class);
                acccout ACC=new acccout();

        if(matkhau.getText().toString().compareTo(laimatkhau.getText().toString())!=0)
        {
           Toast toast=Toast.makeText(getApplicationContext(),"mat khau khong dung",Toast.LENGTH_SHORT);
            toast.show();
        }
        else if(!dieukhoan.isChecked())
        {
            Toast toast=Toast.makeText(getApplicationContext(),"hay dong y voi dieu khoan",Toast.LENGTH_SHORT);
            toast.show();

        } else{
                ACC.setTk(taikhoan.getText().toString());
                ACC.setMk(matkhau.getText().toString());
                intent.putExtra("accout",ACC);
                startActivity(intent);
            }
            }
        });
    }
    public void getId()
    {
        taikhoan=findViewById(R.id.idtaikhoan);
        matkhau=findViewById(R.id.idmatkhau);
        laimatkhau=findViewById(R.id.idmatkhau2);
        dangky=findViewById(R.id.dangky);
        dieukhoan=findViewById(R.id.check);
    }
}