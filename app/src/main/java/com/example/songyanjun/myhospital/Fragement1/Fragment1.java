package com.example.songyanjun.myhospital.Fragement1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.example.songyanjun.myhospital.Style.BorderTextView1;
import com.example.songyanjun.myhospital.Style.CircleImageView;
import com.example.songyanjun.myhospital.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by songyanjun on 2017/4/21.
 */

public class Fragment1 extends Fragment {
    private RecyclerView mRecyclerView;
    private AwardAdapter1 mRecyclerAdapter;
    private List<AVObject> mList = new ArrayList<>();

  //  private RecyclerView recyclerView_award;

    Context context;
    private CircleImageView circleImageView;

    public Fragment1() {
    }

    public Fragment1(Context _context) {
        context = _context;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: ");
    }

    Bundle mBundle = new Bundle();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.homepage, container, false);

//            setContentView(R.layout.homepage);

        circleImageView = (CircleImageView) view.findViewById(R.id.circleview);
        circleImageView.setImageResource(R.drawable.user);

        TextView doc_name = (TextView) view.findViewById(R.id.doc_name);
        doc_name.setText("张医生");
        BorderTextView1 doc_department = (BorderTextView1) view.findViewById(R.id.doc_department);
        doc_department.setText("消化道科");
        BorderTextView1 doc_edu = (BorderTextView1) view.findViewById(R.id.doc_education);
        doc_edu.setText("博士");
        TextView doc_post = (TextView) view.findViewById(R.id.doc_post);
        doc_post.setText("主治医师");
        circleImageView.setImageResource(R.drawable.user);
        ImageView flag = (ImageView)view.findViewById(R.id.flag);
        flag.setImageResource(R.drawable.flag);
        ImageView lett = (ImageView)view.findViewById(R.id.lett);
        lett.setImageResource(R.drawable.letter);
        ImageView bag = (ImageView)view.findViewById(R.id.bag);
        bag.setImageResource(R.drawable.redbag);
        ImageView count = (ImageView)view.findViewById(R.id.count);
        count.setImageResource(R.drawable.count);
//
        TextView flag_num = (TextView) view.findViewById(R.id.flag_num);
        flag_num.setText("15");
        TextView lett_num = (TextView) view.findViewById(R.id.lett_num);
        lett_num.setText("20");
        TextView bag_num = (TextView) view.findViewById(R.id.bag_num);
        bag_num.setText("10");
        TextView count_num = (TextView) view.findViewById(R.id.count_num);
        count_num.setText("20000");
//
//        recyclerView_award = (RecyclerView) view.findViewById(R.id.view_award);
//        initAward();

        mRecyclerView = (RecyclerView) view.findViewById(R.id.view_award);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mRecyclerAdapter = new AwardAdapter1(mList, this.getActivity());
        mRecyclerView.setAdapter(mRecyclerAdapter);
        initData();
        return view;
    }

    private void initData() {
        mList.clear();
        AVQuery<AVObject> avQuery = new AVQuery<>("Product");
        avQuery.orderByDescending("createdAt");
        avQuery.include("owner");
        avQuery.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                if (e == null) {
                    mList.addAll(list);
                    mRecyclerAdapter.notifyDataSetChanged();
                } else {
                    e.printStackTrace();
                }
            }
        });

//    private void initAward() {
//        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView_award.setLayoutManager(layoutManager);
//
//        List<String> typeset = new ArrayList<String>();
//        for (int i = 0; i < 20; i++){
//            typeset.add("Type"+(i+1));
//        }
//
//        List<String> man1_apart = new ArrayList<String>();
//        for (int i = 0; i < 20; i++){
//            man1_apart.add("科室"+(i+1));
//        }
//        List<String> man1 = new ArrayList<String>();
//        for (int i = 0; i < 20; i++){
//            man1.add("医生"+(i+1));
//        }
//        List<String> man2_apart = new ArrayList<String>();
//        for (int i = 0; i < 20; i++){
//            man2_apart.add("病房"+(i+1));
//        }
//        List<String> man2 = new ArrayList<String>();
//        for (int i = 0; i < 20; i++){
//            man2.add("病人"+(i+1));
//        }
//        List<String> man3 = new ArrayList<String>();
//        for (int i = 0; i < 20; i++){
//            man3.add("医师"+(i+1));
//        }
//
//        List<String> timeset = new ArrayList<String>();
//        for (int i = 0; i < 20; i++){
//            timeset.add("2017年10月"+(i+1)+"日");
//        }
//
//        AwardAdapter awardadapter = new AwardAdapter(getActivity(),typeset,man2_apart,man2,man3,timeset);
//        recyclerView_award.addItemDecoration(new MyItemDecoration(getActivity()));
//        recyclerView_award.setAdapter(awardadapter);
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        circleImageView.setImageResource(R.drawable.user);
//            initData();
//    }


//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//    }


    }
    @Override
    public void onPause () {
        super.onPause();
        circleImageView.setImageResource(R.drawable.user);
    }

}