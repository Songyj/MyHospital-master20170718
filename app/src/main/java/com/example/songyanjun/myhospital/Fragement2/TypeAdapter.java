package com.example.songyanjun.myhospital.Fragement2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by songyanjun on 2017/6/30.
 */

public class TypeAdapter extends FragmentPagerAdapter {


    private String[] mTitles = new String[]{"全部", "锦旗表彰", "表扬信","退还红包"};

    public TypeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new Frag2();
        } else if (position == 2) {
            return new Frag3();
        }else if (position==3){
            return new Frag4();
        }
        return new Frag1();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
//    private final int PAGER_COUNT = 4;
//    private Frag1 myFragment1 = null;
//    private Frag2 myFragment2 = null;
//    private Frag3 myFragment3 = null;
//    private Frag4 myFragment4 = null;
//    private Context context = null;
//
//    public TypeAdapter(FragmentManager fm, Context _context) {
//        super(fm);
//        context = _context;
//        myFragment1 = new Frag1();
//        myFragment2 = new Frag2();
//        myFragment4 = new Frag4();
//        myFragment3 = new Frag3();
//
//    }
//
//
//    @Override
//    public int getCount() {
//        return PAGER_COUNT;
//    }
//
//    @Override
//    public Object instantiateItem(ViewGroup vg, int position) {
//        return super.instantiateItem(vg, position);
//    }
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        System.out.println("position Destory" + position);
//        super.destroyItem(container, position, object);
//    }
//
//    @Override
//    public Fragment getItem(int position) {
//        Fragment fragment = null;
//        switch (position) {
//            case Apartment.PAGE_ONE1:
//                fragment = myFragment1;
//                break;
//            case Apartment.PAGE_TWO1:
//                fragment = myFragment2;
//                break;
//            case Apartment.PAGE_THREE1:
//                fragment = myFragment3;
//                break;
//            case Apartment.PAGE_FOUR1:
//                fragment = myFragment4;
//                break;
//        }
//        return fragment;
//    }
//

//}
