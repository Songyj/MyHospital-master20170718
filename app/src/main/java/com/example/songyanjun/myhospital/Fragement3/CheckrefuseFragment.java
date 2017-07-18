package com.example.songyanjun.myhospital.Fragement3;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.songyanjun.myhospital.R;

/**
 * Created by songyanjun on 2017/7/7.
 */

public class CheckrefuseFragment extends DialogFragment {

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//
        View view = inflater.inflate(R.layout.check_refuse, container,false);


        builder.setView(view);


        Button btnno = (Button)view.findViewById(R.id.Btn_Know);
        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dismiss();

            }
        });

        return view;


    }

}
