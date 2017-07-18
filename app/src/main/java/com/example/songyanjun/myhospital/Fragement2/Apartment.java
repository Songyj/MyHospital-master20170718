package com.example.songyanjun.myhospital.Fragement2;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.songyanjun.myhospital.R;

/**
 * Created by songyanjun on 2017/6/17.
 */

public  class Apartment extends AppCompatActivity{

    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;
    private TabLayout.Tab four;
    private TextView apar_name;
    private Toolbar toolbar1;
    public int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.award_type);

        toolbar1 = (Toolbar) findViewById(R.id.apartment_toolbar);
        setSupportActionBar(toolbar1);


        apar_name = (TextView)findViewById(R.id.apar_name);
        getBundle();
        ImageView flag = (ImageView)findViewById(R.id.flag);
        flag.setImageResource(R.drawable.flag);
        ImageView lett = (ImageView)findViewById(R.id.lett);
        lett.setImageResource(R.drawable.letter);
        ImageView bag = (ImageView)findViewById(R.id.bag);
        bag.setImageResource(R.drawable.redbag);
        ImageView count = (ImageView)findViewById(R.id.count);
        count.setImageResource(R.drawable.count);

        TextView flag_num = (TextView)findViewById(R.id.flag_num);
        flag_num.setText("15");
        TextView lett_num = (TextView)findViewById(R.id.lett_num);
        lett_num.setText("20");
        TextView bag_num = (TextView)findViewById(R.id.bag_num);
        bag_num.setText("10");
        TextView count_num = (TextView)findViewById(R.id.count_num);
        count_num.setText("20000");
        initViews();

        toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void getBundle() {
        Bundle bundle = this.getIntent().getExtras();
        String title = bundle.getString("TITLE");
        apar_name.setText(title);
    }

    private void initViews() {

        //使用适配器将ViewPager与Fragment绑定在一起
        TypeAdapter  typeAdapter = new TypeAdapter(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) findViewById(R.id.vpager);
        viewPager.setAdapter(typeAdapter);

        //将TabLayout与ViewPager绑定在一起
        TabLayout tabLayout= (TabLayout)findViewById(R.id.type_tabLayout);

        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.addTab(tabLayout.newTab().setText("全部"));
        tabLayout.addTab(tabLayout.newTab().setText("锦旗表扬"));
        tabLayout.addTab(tabLayout.newTab().setText("表扬信"));
        tabLayout.addTab(tabLayout.newTab().setText("退还红包"));
//        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        //指定Tab的位置
        one = tabLayout.getTabAt(0);
        two = tabLayout.getTabAt(1);
        three = tabLayout.getTabAt(2);
        four = tabLayout.getTabAt(3);

    }


}
