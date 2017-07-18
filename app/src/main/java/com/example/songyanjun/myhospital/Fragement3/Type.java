package com.example.songyanjun.myhospital.Fragement3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.songyanjun.myhospital.R;

import java.util.ArrayList;

/**
 * Created by songyanjun on 2017/7/3.
 */


public class Type extends AppCompatActivity {

    private Toolbar toolbar;



    private String type="普内科";
    private  String award_type;
    private  String award_time;

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
        award_type = getIntent().getStringExtra("apply_type");
        award_time = getIntent().getStringExtra("apply_time");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("apply_type", award_type);
                intent.putExtra("de_type",type);
                setResult(RESULT_OK,intent);
                finish();
            }
        });


    }

    private void initAward() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        chose_type = new ArrayList<String>();


        chose_type.add("普内科");
        chose_type.add("神经内科");
        chose_type.add("皮肤科");
        chose_type.add("儿科");
        chose_type.add("老年病科");
        chose_type.add("感染病科");
        chose_type.add("康复医学科");
        chose_type.add("营养科");
        chose_type.add("呼吸道科");
        chose_type.add("消化道科");
        chose_type.add("中医");
        chose_type.add("精神卫生科");


        chose_type.add("眼科");
        chose_type.add("耳鼻咽喉科");
        chose_type.add("骨科");
        chose_type.add("口腔科");
        chose_type.add("普外科");
        chose_type.add("心胸外科");
        chose_type.add("整形外科");
        chose_type.add("神经外科");
        chose_type.add("泌尿外科");
        chose_type.add("肿瘤外科");
        chose_type.add("肛肠外科");
        chose_type.add("普胸外科");
        chose_type.add("妇产科");
        chose_type.add("麻醉科");


        chose_type.add("超声影像室");
        chose_type.add("血液病科");
        chose_type.add("心电图室");
        chose_type.add("注射室");
        chose_type.add("放射科");
        chose_type.add("输血科");
        chose_type.add("收费处");
        chose_type.add("药房");

        Chose_Type adapter = new Chose_Type(Type.this,chose_type);
        adapter.setOnItemClickListener(new Chose_Type.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//              Toast.makeText(Type.this, "click " + chose_type.get(position), Toast.LENGTH_SHORT).show();
                type = chose_type.get(position);
            }
        });
        recyclerView.addItemDecoration(new MyItemDecoration1(this));
        recyclerView.setAdapter(adapter);
    }
}
