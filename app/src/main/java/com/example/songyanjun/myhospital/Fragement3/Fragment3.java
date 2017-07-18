package com.example.songyanjun.myhospital.Fragement3;

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

public class Fragment3 extends Fragment {

    public Button time;
    Button type1;
    Button type2;
    Button type3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        private RecyclerView recyclerView;
//        private RecyclerView rateView;
//        Log.i(TAG, "onCreateView: fragment3");
        View view = inflater.inflate(R.layout.award_apply, container, false);
        type1 = (Button)view.findViewById(R.id.type_flag);
        type2 = (Button)view.findViewById(R.id.type_lett);
        type3 = (Button)view.findViewById(R.id.type_redbag);

        type1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),Apply_Flag.class);
                intent.putExtra("apply_type",type1.getText());
                startActivity(intent);
            }
        });

        type2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),Apply_Flag.class);
                intent.putExtra("apply_type",type2.getText());
                startActivity(intent);
            }
        });

        type3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),Apply_Redbag.class);
                startActivity(intent);
            }
        });

//
//
        return view;
    }
}







