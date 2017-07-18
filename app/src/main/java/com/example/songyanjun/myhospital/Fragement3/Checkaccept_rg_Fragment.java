package com.example.songyanjun.myhospital.Fragement3;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.songyanjun.myhospital.R;

/**
 * Created by songyanjun on 2017/7/7.
 */

public class Checkaccept_rg_Fragment extends DialogFragment {

    private TextView ap_type;
    private TextView de_type;
    private EditText person1;
    private EditText person2;
    private EditText room;
    private TextView time;
    private EditText person3;
    private EditText person4;
    private EditText person5;
    private TextView ap_type_1;
    private TextView de_type_1;
    private TextView person1_1;
    private TextView person2_1;
    private TextView room_1;
    private TextView time_1;
    private TextView person3_1;
    private TextView person4_1;
    private TextView person5_1;

    private TextView rb_type;
    private TextView rb_type_1;

    private TextView amount;
    private TextView amount_1;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = inflater.inflate(R.layout.check_accept_rb, container,false);

        rb_type = (TextView)getActivity().findViewById(R.id.text_rb_type);
        amount = (TextView)getActivity().findViewById(R.id.text_amount);

        de_type = (TextView)getActivity().findViewById(R.id.text_department);
        person1 = (EditText) getActivity().findViewById(R.id.text_person1);
        person2 = (EditText) getActivity().findViewById(R.id.text_person2);
        room = (EditText) getActivity().findViewById(R.id.text_room);
        time = (TextView)getActivity().findViewById(R.id.text_time);
        person3 = (EditText) getActivity().findViewById(R.id.text_person3);
        person4 = (EditText) getActivity().findViewById(R.id.text_person4);
        person5 = (EditText) getActivity().findViewById(R.id.text_person5);


        rb_type_1 = (TextView)view.findViewById(R.id.text_rb_type);
        amount_1 = (TextView)view.findViewById(R.id.text_amount);
        de_type_1 = (TextView)view.findViewById(R.id.text_department);
        person1_1 = (TextView)view.findViewById(R.id.text_person1);
        person2_1 = (TextView)view.findViewById(R.id.text_person2);
        room_1 = (TextView)view.findViewById(R.id.text_room);
        time_1 = (TextView)view.findViewById(R.id.text_time);
        person3_1 = (TextView) view.findViewById(R.id.text_person3);
        person4_1 = (TextView) view.findViewById(R.id.text_person4);
        person5_1 = (TextView) view.findViewById(R.id.text_person5);


        rb_type_1.setText(rb_type.getText().toString());
        de_type_1.setText(de_type.getText().toString());
        amount_1.setText(amount.getText().toString());
        person1_1.setText(person1.getText().toString());
        room_1.setText(room.getText().toString());
        person2_1.setText(person2.getText().toString());
        time_1.setText(time.getText().toString());
        person3_1.setText(person3.getText().toString());
        person4_1.setText(person4.getText().toString());
        person5_1.setText(person5.getText().toString());

//        Toast.makeText(getContext(), "time"+ time.getText().toString(), Toast.LENGTH_SHORT).show();
        builder.setView(view);

        Button btnno = (Button)view.findViewById(R.id.Btn_No);
        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dismiss();
            }
        });
        Button btnyes = (Button)view.findViewById(R.id.Btn_Yes);
        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                Intent intent = new Intent(getContext(),SucceedActivity.class);
                startActivity(intent);

            }
        });

        return view;


    }

}
