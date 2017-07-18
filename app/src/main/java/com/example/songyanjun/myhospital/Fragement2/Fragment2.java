package com.example.songyanjun.myhospital.Fragement2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.songyanjun.myhospital.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by songyanjun on 2017/4/21.
 */

public class Fragment2 extends Fragment {
    private Context mContext;
    private GridView grid_photo;
    private BaseAdapter mAdapter = null;
    private ArrayList<MyIcon> mData = null;


    public Fragment2() {
    }
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: ");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.apartment,container,false);
        TextView txt_content = (TextView)view.findViewById(R.id.txt_content);
        mContext = getActivity();
        grid_photo = (GridView)view.findViewById(R.id.grid_photo);
        mData = new ArrayList<MyIcon>();
        for(int i=1;i<2;i++) {
            mData.add(new MyIcon(R.mipmap.hos001, "中医"));
            mData.add(new MyIcon(R.mipmap.hos002, "药房"));
            mData.add(new MyIcon(R.mipmap.hos003, "眼科"));
            mData.add(new MyIcon(R.mipmap.hos004,"牙科"));
            mData.add(new MyIcon(R.mipmap.hos005, "心胸科"));
            mData.add(new MyIcon(R.mipmap.hos006, "外科"));
            mData.add(new MyIcon(R.mipmap.hos007, "收费处"));
            mData.add(new MyIcon(R.mipmap.hos008, "皮肤科"));
            mData.add(new MyIcon(R.mipmap.hos009, "内科"));
            mData.add(new MyIcon(R.mipmap.hos010, "呼吸道科"));
            mData.add(new MyIcon(R.mipmap.hos011, "耳科"));
            mData.add(new MyIcon(R.mipmap.hos012, "妇产科"));
            mData.add(new MyIcon(R.mipmap.hos013, "骨科"));
            mData.add(new MyIcon(R.mipmap.hos014,"泌尿科"));
            mData.add(new MyIcon(R.mipmap.hos015, "儿科"));
            mData.add(new MyIcon(R.mipmap.hos016, "心电图室"));
            mData.add(new MyIcon(R.mipmap.hos017, "注射室"));
            mData.add(new MyIcon(R.mipmap.hos018, "消化道科"));

        }
        mAdapter = new ApartAdapter<MyIcon>(mData, R.layout.item_gridicon) {
            @Override
            public void bindView(ViewHolder holder, MyIcon obj) {
                holder.setImageResource(R.id.img_icon, obj.getiId());
                holder.setText(R.id.txt_icon, obj.getiName());
            }
        };


        grid_photo.setAdapter(mAdapter);

        grid_photo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getContext(),Apartment.class);

                Bundle bundle = new Bundle();
                String str = mData.get(position).getiName();
                bundle.putString("TITLE", str);
                intent.putExtras(bundle);

                startActivity(intent);


            }
        });
        return view;
    }
}
