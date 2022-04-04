package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class congthuc extends AppCompatActivity {
    ImageView back,anh;
    TextView tt,nguyenlieu,congthuc,gia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congthuc);
        Bundle bundle=getIntent().getExtras();
        if(bundle==null)
            return;
        anhxa();
        monan Monan= (monan) bundle.get("Monan");
        Picasso.get().load(Monan.getAvt()).into(anh);
        tt.setText(Monan.getMonanname());
        nguyenlieu.setText(Monan.getNguyenlieu());
        congthuc.setText(Monan.getCongthuc());
        gia.setText(Monan.getTien());
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(congthuc.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void anhxa()
    {
        back=findViewById(R.id.exit);
        anh=findViewById(R.id.img_content);
        tt=findViewById(R.id.title);
        nguyenlieu=findViewById(R.id.nguyenlieu);
        congthuc=findViewById(R.id.congthuc);
        gia=findViewById(R.id.gia);
    }
}