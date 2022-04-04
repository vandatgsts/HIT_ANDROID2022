package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private static Monan_apdapter monan_apdapter;
    private static List<monan> monanList=new ArrayList<>();
    private String url="https://appnote-codernon.herokuapp.com/api/monan";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        recyclerView=findViewById(R.id.recy);
        getData();
    }

    private void getData() {
        RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        monan Monan = new monan();
                        Monan.setMonanId(jsonObject.getInt("monanId"));
                        Monan.setMonanname(jsonObject.getString("moanname").toString());
                        Monan.setAvt(jsonObject.getString("avt").toString());
                        Monan.setNguyenlieu(jsonObject.getString("nguyenlieu").toString());
                        Monan.setCongthuc(jsonObject.getString("congthuc").toString());
                        Monan.setTien(jsonObject.getString("tien").toString());
                        monanList.add(Monan);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                    monan_apdapter = new Monan_apdapter(getApplicationContext(), monanList);
                    recyclerView.setAdapter(monan_apdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse: " + error.getMessage());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

}