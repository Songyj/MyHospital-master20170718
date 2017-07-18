package com.example.songyanjun.myhospital.Fragement3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.songyanjun.myhospital.Fragement1.Bottom_Toolbar;
import com.example.songyanjun.myhospital.R;

import java.util.ArrayList;

/**
 * Created by songyanjun on 2017/7/3.
 */


public class Department extends AppCompatActivity {

    private Toolbar toolbar;


    private String type;

    public RecyclerView recyclerView;
    private  ArrayList<String> chose_type = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type);
        toolbar = (Toolbar) findViewById(R.id.type_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        recyclerView = (RecyclerView)findViewById(R.id.type_f3);
        initAward();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Department.this, Bottom_Toolbar.class);
                intent.putExtra("type",type);
                intent.putExtra("id",2);
                startActivity(intent);
            }
        });


    }

    private void initAward() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

            chose_type = new ArrayList<String>();
            chose_type.add("收到锦旗");
            chose_type.add("收到表扬信");
            chose_type.add("拒收红包");

        Chose_Type adapter = new Chose_Type(Department.this,chose_type);
        adapter.setOnItemClickListener(new Chose_Type.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
              Toast.makeText(Department.this, "click " + chose_type.get(position), Toast.LENGTH_SHORT).show();
                type = chose_type.get(position);
            }
        });
        recyclerView.addItemDecoration(new MyItemDecoration1(this));
        recyclerView.setAdapter(adapter);
    }
}
