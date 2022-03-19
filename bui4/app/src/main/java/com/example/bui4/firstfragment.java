package com.example.bui4;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class firstfragment extends Fragment {

    private EditText edittk,editmk;
    private Button send;
    private View mview;
    private IsendDataListener mIsendDataListener;
    public interface IsendDataListener
    {
        void sendData1(User user);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mIsendDataListener= (IsendDataListener) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mview= inflater.inflate(R.layout.fragment_firstfragment, container, false);
        edittk=mview.findViewById(R.id.tk);
        editmk=mview.findViewById(R.id.mk);
        send=mview.findViewById(R.id.chuyen);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData();
            }
        });
        return mview;
    }
    private void sendData()
    {
        User user=new User(edittk.getText().toString().trim(),editmk.getText().toString());
        mIsendDataListener.sendData1(user);

    }

}