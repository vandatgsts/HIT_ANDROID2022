package com.example.mycaculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView insreen, outsreen;

    private String input,output;
    private Button p0,p1,p2,p3,p4,p5,p6,p7,p8,p9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insreen=(TextView) findViewById(R.id.input);
        outsreen=(TextView) findViewById(R.id.output);
    }
    public void buttonClick(View view)
    {
        Button button=(Button) view;
        String data =  button.getText().toString();
        switch (data)
        {
            case "C":
                if(insreen.length()>0)
                    input=input.substring(0,input.length()-1);
                break;
            case "=":
                Slove();
                output=input;
                input="";
                outsreen.setText(output);
                return ;
            case "AC":
                input="";
                break;
            default: {
                if (input == null)
                    input = "";
               //if(input=="X"||input=="÷"|| input=="-"||input=="+")
             //Slove();
                input += data;
            }

        }
        insreen.setText(input);

    }
    public void Slove()
    {
        if(input.split("\\+").length>=2) {
            String number[] = input.split("\\+");
            try {
                double Null=Double.parseDouble(number[0])+Double.parseDouble(number[1]);
                input=Null+"";
            }catch (Exception e) {
                System.out.println(e.fillInStackTrace());
            }
        }
        if(input.split("\\-").length>=2) {
            String number[] = input.split("\\-");
            try {
                double Null=Double.parseDouble(number[0])-Double.parseDouble(number[1]);
                input=Null+"";
            }catch (Exception e) {
                System.out.println(e.fillInStackTrace());
            }
        }
        if(input.split("\\÷").length>=2) {
            String number[] = input.split("\\÷");
            try {
                double Null=Double.parseDouble(number[0])/Double.parseDouble(number[1]);
                input=Null+"";
            }catch (Exception e) {
                System.out.println(e.fillInStackTrace());
            }
        }
        if(input.split("x").length>=2) {
            String number[] = input.split("x");
            try {
                double Null=Double.parseDouble(number[0])*Double.parseDouble(number[1]);
                input=Null+"";
            }catch (Exception e) {
                System.out.println(e.fillInStackTrace());
            }
        }

    }
    public double SumString(String s)
    {
        String number[]=s.split("");
        double anser=Double.parseDouble(number[0]);
        for(int i = 0;i<number.length; i++)
        {
            if(number[i]=="+")
            {
                anser+=Double.parseDouble(number[i+1]);
            }
            if(number[i]=="-")
            {
                anser-=Double.parseDouble(number[i+1]);
            }
            if(number[i]=="x")
            {
                anser*=Double.parseDouble(number[i+1]);
            }
            if(number[i]=="÷")
            {
                anser/=Double.parseDouble(number[i+1]);
            }
        }
        return anser;

    }
}