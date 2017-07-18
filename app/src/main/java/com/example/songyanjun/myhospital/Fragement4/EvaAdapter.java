package com.example.songyanjun.myhospital.Fragement4;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.songyanjun.myhospital.R;

import java.util.List;

public class EvaAdapter extends RecyclerView.Adapter<EvaAdapter.ViewHolder>{

    private List<Evaluate> mevaList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View evaView;
        ImageView evaImage;
        TextView evaName;

        public ViewHolder(View view) {
            super(view);
            evaView = view;
            evaImage = (ImageView) view.findViewById(R.id.eva_image);
            evaName = (TextView) view.findViewById(R.id.eva_name);
        }
    }

    public EvaAdapter(List<Evaluate> evaList) {
        mevaList = evaList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.evaluate_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.evaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Evaluate eva1 = mevaList.get(position);
//                Toast.makeText(v.getContext(), "you clicked view " + eva1.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.evaImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Evaluate eva2 = mevaList.get(position);
//                Toast.makeText(v.getContext(), "you clicked image " + eva2.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Evaluate eva = mevaList.get(position);
        holder.evaImage.setImageResource(R.drawable.img);
        holder.evaName.setText(eva.getName());
    }

    @Override
    public int getItemCount() {
        return mevaList.size();
    }

}