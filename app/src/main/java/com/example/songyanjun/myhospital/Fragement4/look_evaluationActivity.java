package com.example.songyanjun.myhospital.Fragement4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.songyanjun.myhospital.Fragement1.Bottom_Toolbar;
import com.example.songyanjun.myhospital.Fragement1.MyItemDecoration;
import com.example.songyanjun.myhospital.R;

import java.util.ArrayList;
import java.util.List;

public class look_evaluationActivity extends AppCompatActivity {
    private Context mContext;
    Toolbar toolbar;
        private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.look_evaluation);
        toolbar = (Toolbar) findViewById(R.id.look_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(look_evaluationActivity.this, Bottom_Toolbar.class);
                intent.putExtra("id",3);
                startActivity(intent);
            }
        });

        initMes();

    }
    private void initMes() {
        recyclerView = (RecyclerView) findViewById(R.id.look_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        List<String> titleset = new ArrayList<String>();
        for (int i = 0; i < 20; i++){
            titleset.add("Title"+(i+1));
        }

        List<String> messet = new ArrayList<String>();
        for (int i = 0; i < 20; i++){
            messet.add("评价详情"+(i+1));
        }


        List<String> timeset = new ArrayList<String>();
        for (int i = 0; i < 20; i++){
            timeset.add("XXXX年XX月"+(i+1)+"日");
        }

        MesAdapter mesadapter = new MesAdapter(look_evaluationActivity.this,titleset,messet,timeset);
        recyclerView.addItemDecoration(new MyItemDecoration(this));
        recyclerView.setAdapter(mesadapter);
    }
}
