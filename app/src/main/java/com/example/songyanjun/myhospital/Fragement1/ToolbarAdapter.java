package com.example.songyanjun.myhospital.Fragement1;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import com.example.songyanjun.myhospital.Fragement2.Fragment2;
import com.example.songyanjun.myhospital.Fragement3.Fragment3;
import com.example.songyanjun.myhospital.Fragement4.Fragment4;

/**
 * Created by songyanjun on 2017/5/3.
 */

public class ToolbarAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 4;
    private Fragment1 myFragment1 = null;
    private Fragment2 myFragment2 = null;
    private Fragment3 myFragment3 = null;
    private Fragment4 myFragment4 = null;
    private Context context = null;

    public ToolbarAdapter(FragmentManager fm, Context _context) {
        super(fm);
        context = _context;
        myFragment1 = new Fragment1();
        myFragment2 = new Fragment2();
        myFragment4 = new Fragment4();
        myFragment3 = new Fragment3();

    }


    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        Log.d("checked","position="+position);
        switch (position) {
            case Bottom_Toolbar.PAGE_ONE:
                fragment = myFragment1;
                break;
            case Bottom_Toolbar.PAGE_TWO:
                fragment = myFragment2;
                break;
            case Bottom_Toolbar.PAGE_THREE:
                fragment = myFragment3;
                break;
            case Bottom_Toolbar.PAGE_FOUR:
                fragment = myFragment4;
                break;
        }
        return fragment;
    }


}
