package com.example.songyanjun.myhospital.Fragement2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.songyanjun.myhospital.Fragement1.MyItemDecoration;
import com.example.songyanjun.myhospital.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songyanjun on 2017/6/17.
 */

public class Frag4 extends Fragment{
    private RecyclerView recyclerView_all;
    Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.award_all, container, false);
        recyclerView_all = (RecyclerView) view.findViewById(R.id.view_all);

        initAward();
        return view;

    }
    private void initAward() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView_all.setLayoutManager(layoutManager);

        List<String> typeset = new ArrayList<String>();
        for (int i = 0; i < 20; i++){
            typeset.add("Number"+(i+1));
        }

        List<String> man1 = new ArrayList<String>();
        for (int i = 0; i < 20; i++){
            man1.add("医生"+(i+1));
        }
        List<String> man2_apart = new ArrayList<String>();
        for (int i = 0; i < 20; i++){
            man2_apart.add("病房"+(i+1));
        }
        List<String> man2 = new ArrayList<String>();
        for (int i = 0; i < 20; i++){
            man2.add("病人"+(i+1));
        }
        List<String> man3 = new ArrayList<String>();
        for (int i = 0; i < 20; i++){
            man3.add("医师"+(i+1));
        }

        List<String> timeset = new ArrayList<String>();
        for (int i = 0; i < 20; i++){
            timeset.add("2017年10月"+(i+1)+"日");
        }

        RedBagAdapter alladapter = new RedBagAdapter(getActivity(),typeset,man1,man2_apart,man2,man3,timeset);
        recyclerView_all.addItemDecoration(new MyItemDecoration(getActivity()));
        recyclerView_all.setAdapter(alladapter);
    }
}
