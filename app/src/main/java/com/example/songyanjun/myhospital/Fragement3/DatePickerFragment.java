package com.example.songyanjun.myhospital.Fragement3;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by songyanjun on 2017/7/4.
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private String date;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //得到Calendar类实例，用于获取当前时间
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        //返回DatePickerDialog对象
        //因为实现了OnDateSetListener接口，所以第二个参数直接传入this
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    //实现OnDateSetListener接口的onDateSet()方法
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//        //这样子写就将选择时间的fragment和选择日期的fragment完全绑定在一起
//        //使用的时候只需直接调用DatePickerFragment的show()方法
//        //即可选择完日期后选择时间
        if (getActivity() instanceof DataCallBack) {
            DataCallBack dataCallBack = (DataCallBack) getActivity();
            Log.d("Time", "Time年" + year + "月" + monthOfYear + "日" + dayOfMonth);
            date = year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日";
            dataCallBack.getData(date);
//        }

//        date = year + "年" + (monthOfYear+1) + "月" + dayOfMonth + "日";
//        Log.i("date", "onDateSet: "+date);
//        Fragment3 page3 = (Fragment3) getActivity().getSupportFragmentManager().findFragmentByTag("Page3");
////        page3.setText(date);
        }
    }

}