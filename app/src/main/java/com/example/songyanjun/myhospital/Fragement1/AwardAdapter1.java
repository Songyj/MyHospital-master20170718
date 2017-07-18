package com.example.songyanjun.myhospital.Fragement1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.avos.avoscloud.AVObject;
import com.example.songyanjun.myhospital.R;

import java.util.List;
import com.squareup.picasso.Picasso;
/**
 * Created by Lenovo on 2017/7/11.
 */

public class AwardAdapter1 extends RecyclerView.Adapter<AwardAdapter1.MainViewHolder> {
    private Context mContext;
    private List<AVObject> mList;

    public AwardAdapter1(List<AVObject> list, Context context) {
        this.mContext = context;
        this.mList = list;
    }
    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_list_main, parent, false));
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, final int position) {
        holder.mType.setText((CharSequence)mList.get(position).get("title"));
        holder.mMan1_apart.setText((CharSequence)mList.get(position).get("text_department"));
        holder.mMan1.setText((CharSequence)mList.get(position).get("text_person1"));
        holder.mTime.setText((CharSequence)mList.get(position).get("text_time"));
        holder.mMan3.setText((CharSequence)mList.get(position).get("text_person3"));
        Picasso.with(mContext).load(mList.get(position).getAVFile("image") == null ? "www" : mList.get(position).getAVFile("image").getUrl()).transform(new RoundedTransformation(9, 0)).into(holder.mAward_img);
               holder.mItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("goodsObjectId", mList.get(position).getObjectId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {
        private TextView mType;
        private TextView mMan1_apart;
        private TextView mMan1;
        private TextView mMan3;
        private TextView mTime;
        private ImageView mAward_img;
        private CardView mItem;


        public MainViewHolder(View itemView) {
            super(itemView);
            mType = (TextView) itemView.findViewById(R.id.award_type1);
            mMan1_apart = (TextView) itemView.findViewById(R.id.award_man1_apart1);
            mMan1 = (TextView) itemView.findViewById(R.id.text_person1);
            mMan3 = (TextView) itemView.findViewById(R.id.text_person3);
            mAward_img = (ImageView) itemView.findViewById(R.id.apply_img1);
            mTime = (TextView) itemView.findViewById(R.id.award_time);
            mItem = (CardView) itemView.findViewById(R.id.item_main);


        }
    }
}
