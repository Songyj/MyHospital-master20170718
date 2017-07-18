package com.example.songyanjun.myhospital.Fragement4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.songyanjun.myhospital.Style.BorderTextView1;
import com.example.songyanjun.myhospital.Fragement1.Bottom_Toolbar;
import com.example.songyanjun.myhospital.Style.CircleImageView;
import com.example.songyanjun.myhospital.Fragement1.MyItemDecoration;
import com.example.songyanjun.myhospital.R;

import java.util.ArrayList;
import java.util.List;

public class self_EvaluationActivity extends AppCompatActivity {
    private List<Evaluate> evaList = new ArrayList<Evaluate>();
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self__evaluation);

        toolbar = (Toolbar) findViewById(R.id.eva_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(self_EvaluationActivity.this, Bottom_Toolbar.class);
                intent.putExtra("id",3);
                startActivity(intent);
            }
        });
        CircleImageView circleImageView = (CircleImageView) findViewById(R.id.circleview);
        circleImageView.setImageResource(R.drawable.user);
        TextView doc_name = (TextView) findViewById(R.id.doc_name);
        doc_name.setText("张医生");
        BorderTextView1 doc_department = (BorderTextView1)  findViewById(R.id.doc_department);
        doc_department.setText("消化道科");
        BorderTextView1 doc_edu = (BorderTextView1)  findViewById(R.id.doc_education);
        doc_edu.setText("博士");
        TextView doc_post = (TextView)  findViewById(R.id.doc_post);
        doc_post.setText("主治医师");

        ImageView flag = (ImageView) findViewById(R.id.flag);
        flag.setImageResource(R.drawable.flag);
        ImageView lett = (ImageView) findViewById(R.id.lett);
        lett.setImageResource(R.drawable.letter);
        ImageView bag = (ImageView) findViewById(R.id.bag);
        bag.setImageResource(R.drawable.redbag);
        ImageView count = (ImageView) findViewById(R.id.count);
        count.setImageResource(R.drawable.count);

        TextView flag_num = (TextView)  findViewById(R.id.flag_num);
        flag_num.setText("15");
        TextView lett_num = (TextView)  findViewById(R.id.lett_num);
        lett_num.setText("20");
        TextView bag_num = (TextView)  findViewById(R.id.bag_num);
        bag_num.setText("10");
        TextView count_num = (TextView)  findViewById(R.id.count_num);
        count_num.setText("20000");



        initEvas();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.eva_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        EvaAdapter adapter = new EvaAdapter(evaList);
        recyclerView.addItemDecoration(new MyItemDecoration(this));
        recyclerView.setAdapter(adapter);
        Button commit = (Button)findViewById(R.id.eva_commit);
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DoubleCheck().show(getSupportFragmentManager(),"activity_p_doublecheck1");
            }
        });
//        ImageButton back = (ImageButton)findViewById(R.id.eva_Btn_backhome);
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.setClass(self_EvaluationActivity.this,MainActivity.class);
//                startActivity(intent);
//            }
//        });

        }
    private void initEvas() {
        for (int i = 0; i <20 ; i++) {
            Evaluate star = new Evaluate(("评价项目：")+(i+1), R.drawable.star);
            evaList.add(star);
        }
    }



}