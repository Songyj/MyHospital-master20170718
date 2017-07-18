package com.example.songyanjun.myhospital.Fragement3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.songyanjun.myhospital.R;

import java.util.List;

/**
 * Created by songyanjun on 2017/7/4.
 */

public class Chose_Type extends RecyclerView.Adapter<Chose_Type.AwardViewHolder>{
    private Context mContext;
    private List<String> mDatas;
    private LayoutInflater inflater;
    private  Chose_Type.AwardViewHolder holder;

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }
    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public Chose_Type(Context contexts, List<String> type){

        this.mContext = contexts;
        this.mDatas = type;

        inflater= LayoutInflater.from(mContext);
    }

    @Override
    public int getItemCount() {
        // TODO Auto-generated method stub
//        Log.d("size","size"+ mDatas.size());
        return mDatas.size();


    }

    @Override
    public  void onBindViewHolder(final Chose_Type.AwardViewHolder holder, final int position) {

        holder.type_text.setText(mDatas.get(position));
//        Log.d("次数","次数"+ position);
            //为ItemView设置监听器
            holder.type_text.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if(mOnItemClickListener != null){
                        int position = holder.getLayoutPosition();
//                        Log.d("pos","pos"+position);// 1
                        mOnItemClickListener.onItemClick(holder.itemView,position); }
                    return false;
                }
            });
    }
    @Override
    public Chose_Type.AwardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_type_chose,parent,false);
        holder=new Chose_Type.AwardViewHolder(view);
        return holder;
    }

    class AwardViewHolder extends RecyclerView.ViewHolder {

        TextView type_text;

        public AwardViewHolder(View view) {
            super(view);
            type_text = (TextView) view.findViewById(R.id.type_chose);
//            Log.d("输出表单","输出表单");

        }

    }

}
