package com.example.bui4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.TestLooperManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class secon_fragment extends Fragment {

    private TextView tk,mk;
    private View mview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mview= inflater.inflate(R.layout.fragment_secon_fragment, container, false);
        tk=mview.findViewById(R.id.tk2);
        mk=mview.findViewById(R.id.mk2);
        return mview;
    }
    public void AcData(User user)
    {
        tk.setText(user.getTaikhoan());
        mk.setText(user.getMatkhau());
    }
}