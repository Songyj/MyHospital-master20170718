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


public class Type1 extends AppCompatActivity {

    private Toolbar toolbar;



    private String type="现金红包";

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
                Intent intent = new Intent();
                intent.putExtra("rb_type",type);
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


        chose_type.add("退还现金红包");
        chose_type.add("退还外币红包");
        chose_type.add("退还支付宝红包");
        chose_type.add("退还微信红包");
        chose_type.add("退还超市卡");
        chose_type.add("退还贵重物品");


        Chose_Type adapter = new Chose_Type(Type1.this,chose_type);
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
