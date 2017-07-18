package com.example.songyanjun.myhospital.Fragement1;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.songyanjun.myhospital.Fragement2.Fragment2;
import com.example.songyanjun.myhospital.Fragement3.DataCallBack;
import com.example.songyanjun.myhospital.Fragement3.Fragment3;
import com.example.songyanjun.myhospital.Fragement4.Fragment4;
import com.example.songyanjun.myhospital.R;

/**
 * Created by songyanjun on 2017/5/3.
 */

public class Bottom_Toolbar extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener,DataCallBack {

    private RadioGroup rg_tab_bar;
    private RadioButton rb_homepage;
    private RadioButton rb_department;
    private RadioButton rb_award;
    private RadioButton rb_evaluate;
    private ViewPager vpager;
    private RadioButton[] rbs;
    private Drawable[] drs;

    private ToolbarAdapter mAdapter;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    public int id;
    public String award_type;
    public String text;
    private Fragment3 fragment3;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_toolbar);
        mAdapter = new ToolbarAdapter(getSupportFragmentManager(), (Context) this);
        vpager = (ViewPager) findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        int id = getIntent().getIntExtra("id",0);
        String award_type = getIntent().getStringExtra("type");
        Log.d("你的标签", "id: "+id);
        vpager.setCurrentItem(id);
        vpager.addOnPageChangeListener(this);
        bindViews();
        switch (id){
            case 0:{
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.vpager, new Fragment1())
                    .addToBackStack(null)
                    .commit();
                rb_homepage.setChecked(true);
                break;
            }
            case 1:{
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.vpager, new Fragment2())
                        .addToBackStack(null)
                        .commit();
                rb_department.setChecked(true);
                break;
            }
            case 2:{
                fragment3 = new Fragment3();
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.vpager, fragment3,"Page3")
                        .addToBackStack(null)
                        .commit();
                rb_award.setChecked(true);
//                Log.d("Text","Text"+onTest());
                break;
            }
            case 3:{
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.vpager, new Fragment4())
                        .addToBackStack(null)
                        .commit();
                rb_evaluate.setChecked(true);
                break;
            }
        }

    }

        private void bindViews() {
            rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
            rb_homepage = (RadioButton) findViewById(R.id.rb_homepage);
            rb_department = (RadioButton) findViewById(R.id.rb_department);
            rb_award = (RadioButton) findViewById(R.id.rb_award);
            rb_evaluate = (RadioButton) findViewById(R.id.rb_evaluate);
            rg_tab_bar.setOnCheckedChangeListener(this);

            rbs = new RadioButton[4];
            drs = new Drawable[4];
//初始化控件，中间大个的，周围小弟
            rbs[0] = rb_homepage;
            rbs[1] = rb_department;
            rbs[2] = rb_award;
            rbs[3] = rb_evaluate;

            for (RadioButton rb : rbs) {
                //挨着给每个RadioButton加入drawable限制边距以控制显示大小
                drs = rb.getCompoundDrawables();
                //获取drawables
                Rect r = new Rect(0, 0, drs[1].getMinimumWidth()/4, drs[1].getMinimumHeight()/4);
                //定义一个Rect边界
                drs[1].setBounds(r);
               // 给drawable设置边界
//            if (rb.getId() == R.id.rb_evaluate) {
//                r = new Rect(0, 0, drs[1].getMinimumWidth(), drs[1].getMinimumHeight());
//                drs[1].setBounds(r);
//            }
//              为某一控件添加特定条件
                rb.setCompoundDrawables(null,drs[1],null,null);
                //添加限制给控件
            }
        }

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            Log.d("checked","check="+checkedId);
            switch (checkedId) {
                case R.id.rb_homepage:
                    vpager.setCurrentItem(PAGE_ONE);
                    break;
                case R.id.rb_department:
                    vpager.setCurrentItem(PAGE_TWO);
                    break;
                case R.id.rb_award:
                    vpager.setCurrentItem(PAGE_THREE);
                    break;
                case R.id.rb_evaluate:
                    vpager.setCurrentItem(PAGE_FOUR);
                    break;

            }
        }

        //重写ViewPager页面切换的处理方法
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
            if (state == 2) {
                switch (vpager.getCurrentItem()) {
                    case PAGE_ONE:
                        rb_homepage.setChecked(true);
                        break;
                    case PAGE_TWO:
                        rb_department.setChecked(true);
                        break;
                    case PAGE_THREE:
                        rb_award.setChecked(true);
                        break;
                    case PAGE_FOUR:
                        rb_evaluate.setChecked(true);
                        break;
                }
            }
        }
    @Override
    public void getData(String data) {
        //data即为fragment调用该函数传回的日期时间

//       Fragment3 fragment3 = (Fragment3) getSupportFragmentManager().findFragmentByTag("Page3");
//
//        fragment3.setText(data);
        this.data = data;
    }
//    @Override
//    public String onTest()
//
//    {
//        this.text =  award_type;
//        Log.d("text1","text1"+award_type);
//        return text;
//
//    }


}

