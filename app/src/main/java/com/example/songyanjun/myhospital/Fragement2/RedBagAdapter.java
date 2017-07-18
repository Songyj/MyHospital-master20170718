package com.example.songyanjun.myhospital.Fragement2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.songyanjun.myhospital.R;

import java.util.List;

/**
 * Created by songyanjun on 2017/4/10.
 */

public class RedBagAdapter extends RecyclerView.Adapter<RedBagAdapter.AwardViewHolder>{
    private Context mContext;
    private List<String> mDatas;
    private List<String> aDatas1;
    private List<String> aDatas2;
    private List<String> bDatas1;
    private List<String> bDatas2;
    private List<String> cDatas1;
    private List<String> timeDatas;
    private LayoutInflater inflater;

    public RedBagAdapter(Context contexts, List<String> data, List<String> man1,List<String> man2_apart, List<String> man2, List<String> man3, List<String> time){

        this.mContext = contexts;
        this.mDatas = data;
//        this.aDatas1 = man1_apart;
        this.aDatas2 = man1;
        this.bDatas1 = man2_apart;
        this.bDatas2 = man2;
        this.cDatas1 = man3;
        this.timeDatas = time;
        inflater= LayoutInflater.from(mContext);
    }

    @Override
    public int getItemCount() {
        // TODO Auto-generated method stub
        return mDatas.size();
    }

    @Override
    public void onBindViewHolder(RedBagAdapter.AwardViewHolder holder, final int position) {

        holder.type.setText( mDatas.get(position));
//        holder.man1_apart.setText(aDatas1.get(position));
        holder.man2_apart.setText(bDatas1.get(position));
        holder.man1.setText(aDatas2.get(position));
        holder.man2.setText(bDatas2.get(position));
        holder.man3.setText(cDatas1.get(position));

        holder.time.setText(timeDatas.get(position));
        holder.img.setImageResource(R.drawable.img);
    }
    @Override
    public RedBagAdapter.AwardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_award_redbag,parent,false);
        RedBagAdapter.AwardViewHolder holder=new RedBagAdapter.AwardViewHolder(view);
        return holder;
    }

    class AwardViewHolder extends RecyclerView.ViewHolder {

        TextView type;
//        TextView man1_apart;
        TextView man1;
        TextView man2_apart;
        TextView man2;
        TextView man3;
        TextView time;
        ImageView img;

        public AwardViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.award_img);
            type = (TextView) view.findViewById(R.id.award_type);
//            man1_apart = (TextView) view.findViewById(R.id.award_man1_apart);
            man1 = (TextView) view.findViewById(R.id.award_man1);
            man2_apart = (TextView) view.findViewById(R.id.award_man2_apart);
            man2 = (TextView) view.findViewById(R.id.award_man2);
            man3 = (TextView) view.findViewById(R.id.award_man3);
            time = (TextView) view.findViewById(R.id.award_time);
        }

    }

}
