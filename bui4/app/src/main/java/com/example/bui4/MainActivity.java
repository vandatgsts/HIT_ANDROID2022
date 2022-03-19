package com.example.bui4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements firstfragment.IsendDataListener {
    private Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
       fragmentTransaction.add(R.id.flag1,new firstfragment());
       fragmentTransaction.add(R.id.flag2,new secon_fragment());
       fragmentTransaction.commit();
    }

    @Override
    public void sendData1(User user) {
        secon_fragment secon_fragment2= (secon_fragment) getSupportFragmentManager().findFragmentById(R.id.flag2);
        secon_fragment2.AcData(user);
    }


}