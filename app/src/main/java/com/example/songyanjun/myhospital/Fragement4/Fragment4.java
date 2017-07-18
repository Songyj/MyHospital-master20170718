package com.example.songyanjun.myhospital.Fragement4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.songyanjun.myhospital.R;

/**
 * Created by songyanjun on 2017/4/21.
 */

public class Fragment4 extends Fragment {
    public Button time;
    Button type1;
    Button type2;
    Button type3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        private RecyclerView recyclerView;
//        private RecyclerView rateView;
//        Log.i(TAG, "onCreateView: fragment3");
        View view = inflater.inflate(R.layout.evaluation, container, false);
        type1 = (Button)view.findViewById(R.id.type_eva);
        type2 = (Button)view.findViewById(R.id.type_check);

        type1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),self_EvaluationActivity.class);
                startActivity(intent);
            }
        });

        type2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),look_evaluationActivity.class);
                startActivity(intent);
            }
        });


//
//
        return view;
    }
    }
