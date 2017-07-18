package com.example.songyanjun.myhospital.Fragement1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.GetCallback;
import com.example.songyanjun.myhospital.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Lenovo on 2017/7/11.
 */

public class DetailActivity extends AppCompatActivity {
    private TextView mType;
    private TextView mMan1_apart;
    private TextView mMan1;
    private TextView mMan2;
    private TextView mMan3;
    private TextView mTime;
    private ImageView mAward_img;
    private TextView mRoom;
    private CardView mItem;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // getSupportActionBar()item_list_main.setTitle(getString(R.string.detail));

        toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        mType = (TextView) findViewById(R.id.award_type);
        mMan1 = (TextView) findViewById(R.id.text_person1);
        mMan1_apart = (TextView) findViewById(R.id.text_apartment);
        mMan2 = (TextView) findViewById(R.id.text_person2);
        mMan3 = (TextView) findViewById(R.id.text_person3);
        mAward_img = (ImageView)findViewById(R.id.apply_img);
        mTime = (TextView) findViewById(R.id.text_time);
        mItem = (CardView) findViewById(R.id.item_main);
        mRoom = (TextView)findViewById(R.id.text_room);
        String goodsObjectId = getIntent().getStringExtra("goodsObjectId");
        AVObject avObject = AVObject.createWithoutData("Product", goodsObjectId);
        avObject.fetchInBackground("owner", new GetCallback<AVObject>() {
            @Override
            public void done(AVObject avObject, AVException e) {

                mMan1_apart.setText(avObject.getString("text_department"));
                mMan1.setText(avObject.getString("text_person1"));
                mMan2.setText(avObject.getString("text_person2"));
                mMan3.setText(avObject.getString("text_person3"));
                mType.setText(avObject.getString("title"));
                mTime.setText(avObject.getString("text_time"));
                mRoom.setText(avObject.getString("text_room"));
                Picasso.with(DetailActivity.this).load(avObject.getAVFile("image") == null ? "www" : avObject.getAVFile("image").getUrl()).into(mAward_img);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
