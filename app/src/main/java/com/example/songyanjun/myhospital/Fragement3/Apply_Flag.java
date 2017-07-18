package com.example.songyanjun.myhospital.Fragement3;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SaveCallback;
import com.example.songyanjun.myhospital.Fragement1.Bottom_Toolbar;
import com.example.songyanjun.myhospital.R;
import com.example.songyanjun.myhospital.utils.CropUtils;
import com.example.songyanjun.myhospital.utils.DialogPermission;
import com.example.songyanjun.myhospital.utils.FileUtil;
import com.example.songyanjun.myhospital.utils.PermissionUtil;
import com.example.songyanjun.myhospital.utils.SharedPreferenceMark;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static com.example.songyanjun.myhospital.R.drawable.alb;
import static com.example.songyanjun.myhospital.R.drawable.star1;
import static com.example.songyanjun.myhospital.R.id.apply_img;
import static com.example.songyanjun.myhospital.R.id.text_room;
import static com.example.songyanjun.myhospital.R.id.text_time;



/**
 * Created by songyanjun on 2017/7/5.
 */

public class Apply_Flag extends AppCompatActivity implements DataCallBack {

    public static final String TAG = "SaveStateActivity";
    private byte[] mImageBytes = null;
    public String type1;
    public TextView time;
    private TextView title;
    private TextView de_type;

    private ArrayList<EditText> info = new ArrayList<EditText>();
    private Toolbar toolbar;
    private  String award_type;
    private EditText person3;
    private EditText room;
    private EditText person2;
    private EditText person1;
    private Editable text_state;
    private boolean n=true;
    private int i;
    private Drawable drawable1;
    private Drawable[] drawable;
    private EditText editText;
    private Button submit;
    private Button upload;

    private ImageView pic;

    private static final int REQUEST_CODE_TAKE_PHOTO = 4;
    private static final int REQUEST_CODE_ALBUM = 2;
    private static final int REQUEST_CODE_CROUP_PHOTO = 3;

    private File file;
    private Uri uri;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            Log.v(TAG, savedInstanceState.getString("data"));
//            time.setText(savedInstanceState.getString("time"));
        }
        setContentView(R.layout.apply_fl);

        toolbar = (Toolbar) findViewById(R.id.apply_fl_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Apply_Flag.this, Bottom_Toolbar.class);
                intent.putExtra("id",2);
                startActivity(intent);
            }
        });

        title =(TextView)findViewById(R.id.Apply_Type);
        award_type = getIntent().getStringExtra("apply_type");
//        Log.d("apply_type","get"+ award_type);
        title.setText(award_type);

        de_type = (TextView)findViewById(R.id.text_department);
        init_de_type ();
        setDe_type();
        de_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                de_type.setCompoundDrawables(null,null,drawable[2],null);
                Intent intent = new Intent(Apply_Flag.this,Type.class);
                intent.putExtra("apply_type", award_type);
                startActivityForResult(intent,1);
            }
        });

        pic = (ImageView)findViewById(R.id.apply_img);
        person1 = (EditText)findViewById(R.id.text_person1);
        person1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                person1.setCompoundDrawables(null,null,null,null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });




        person2 = (EditText)findViewById(R.id.text_person2);
        person2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                person2.setCompoundDrawables(null,null,null,null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        room = (EditText)findViewById(R.id.text_room);
        room.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                room.setCompoundDrawables(null,null,null,null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        person3 = (EditText)findViewById(R.id.text_person3);
        person3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                person3.setCompoundDrawables(null,null,null,null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        time = (TextView)findViewById(text_time);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                time.setCompoundDrawables(null,null,null,null);
                DatePickerFragment datePickerFragment = new DatePickerFragment();
                datePickerFragment.show(getSupportFragmentManager(),"data_picker");
            }
        });
//        if(time.getText().length()!=0){time.setCompoundDrawables(null,null,null,null);}


        info.add(person1);
        info.add(person2);
        info.add(person3);
        info.add(room);

        drawable1 = getDrawable(star1);
        Rect r = new Rect(0, 0, drawable1.getMinimumWidth()/2, drawable1.getMinimumHeight()/2);
        drawable1.setBounds(r);


        submit = (Button)findViewById(R.id.Btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if ("".equals(person1.getText().toString())) {
//                    Toast.makeText(getParentActivityIntent(), "请输入表彰人姓名", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if ("".equals(person2.getText().toString())) {
//                    Toast.makeText(getParentActivityIntent(), "请输入家属或病人姓名", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if ("".equals(person3.getText().toString())) {
//                    Toast.makeText(getParentActivityIntent() ,"请填表人姓名", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if ("".equals(de_type.getText().toString())) {
//                    Toast.makeText(getParentActivityIntent(), "请输入科室", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if ("".equals(time.getText().toString())) {
//                    Toast.makeText(getParentActivityIntent(), "请输入申请时间", Toast.LENGTH_SHORT).show();
//                    return;
//                }

                if(check()== true ){

                    AVObject product = new AVObject("Product");
                    product.put("title", title.getText().toString());
                    product.put("text_department", de_type.getText().toString());
                    product.put("text_person1", person1.getText().toString());
                    product.put("text_person2", person2.getText().toString());
                    product.put("text_room", room.getText().toString());
                    product.put("text_time", time.getText().toString());
                    product.put("text_person3", person3.getText().toString());
                    product.put("owner", AVUser.getCurrentUser());
                    product.put("image", new AVFile("productPic",mImageBytes));
                    product.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(AVException e) {
                            if (e == null) {

                            } else {

                                Toast.makeText(Apply_Flag.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    Intent intent = new Intent(Apply_Flag.this, Bottom_Toolbar.class);
                    intent.putExtra("id",2);
                    new CheckacceptFragment().show(getSupportFragmentManager(), "doublecheck");
                    Log.d("result","true");

                }else{
                    Log.d("result","false");
                    new CheckrefuseFragment().show(getSupportFragmentManager(), "doublecheck");

                }
            }
        });

        Button cam = (Button)findViewById(R.id.set_camera);
        Button alb = (Button) findViewById(R.id.take_photo);
        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 42);
            }
        });

        alb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadAvatarFromAlbumRequest();

            }
        });

        init();

            }


    public byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, len);
        }
        return byteArrayOutputStream.toByteArray();
    }


    public void init_de_type (){
        drawable = de_type.getCompoundDrawables();
        // 数组下表0~3,依次是:左上右下
        Rect r = new Rect(0, 0, drawable[2].getMinimumWidth()/5*2, drawable[2].getMinimumHeight()/5*2);
        drawable[2].setBounds(r);
        de_type.setCompoundDrawables(null, null, drawable[2],
                null);
    }

    public void setDe_type(){
        Log.d("get","mass"+type1);
        if(type1 == null)
        {
            de_type.setText("请选择科室");
            de_type.setGravity(Gravity.RIGHT);
            de_type.setTextColor(getResources().getColor(R.color.lightgray));
        }else
        {
            de_type.setText(type1);
            de_type.setGravity(Gravity.LEFT);
            de_type.setTextColor(getResources().getColor(R.color.darkgray));
        }

    }



    @Override
    public void getData(String data) {
        if(data.length()!=0){time.setCompoundDrawables(null,null,null,null);time.setText(data);}

    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==1 ){
            if(resultCode == RESULT_OK){
                type1 = data.getStringExtra("de_type");
                Log.d("de_type","get"+ type1);
                setDe_type();
                award_type = data.getStringExtra("apply_type");
                Log.d("apply_type","get"+ award_type);
            }

        }
        if (requestCode == 42 && resultCode == RESULT_OK) {
            try {
                pic.setImageBitmap(MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData()));
                mImageBytes = getBytes(getContentResolver().openInputStream(data.getData()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            if (resultCode != -1) {
            return;
        }
        if (requestCode == REQUEST_CODE_ALBUM && data != null) {
            Uri newUri;
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                newUri = Uri.parse("file:///" + CropUtils.getPath(this, data.getData()));
            } else {
                newUri = data.getData();
            }
            if (newUri != null) {
                startPhotoZoom(newUri);
            } else {
                Toast.makeText(this, "没有得到相册图片", Toast.LENGTH_LONG).show();
            }
        } else if (requestCode == REQUEST_CODE_TAKE_PHOTO) {
            startPhotoZoom(uri);
        } else if (requestCode == REQUEST_CODE_CROUP_PHOTO) {
            uploadAvatarFromPhoto();
        }}
    }



    public boolean check(){
        n = true;

        for(i=0;i<info.size();i++){
            editText = info.get(i);
            if(editText.getText().toString().length()==0){n=false;editText.setCompoundDrawables(drawable1,null,null,null);}

        }

        if(de_type.getText().toString()=="请选择科室"){n=false;de_type.setCompoundDrawables(drawable1,null,drawable[2],null);}
        if(time.getText().toString().length()==0){n=false;time.setCompoundDrawables(drawable1,null,null,null);}

        return n;
    }
    private void init() {
        file = new File(FileUtil.getCachePath(this), "user-avatar.jpg");
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            uri = Uri.fromFile(file);
        } else {
            //通过FileProvider创建一个content类型的Uri(android 7.0需要这样的方法跨应用访问)
//            uri = FileProvider.getUriForFile(MyApplication.getApp(), "com.yf.useravatar", file);
//            uri = FileProvider.getUriForFile(getApplication(), "com.yf.useravatar", file);

        }
    }



    /**
     * photo
     */
    private void uploadAvatarFromPhotoRequest() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(intent, REQUEST_CODE_TAKE_PHOTO);
    }

    /**
     * album
     */
    private void uploadAvatarFromAlbumRequest() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, REQUEST_CODE_ALBUM);
    }


    private void uploadAvatarFromPhoto() {
        compressAndUploadAvatar(file.getPath());

    }

    private void compressAndUploadAvatar(String fileSrc) {
        final File cover = FileUtil.getSmallBitmap(this, fileSrc);
//        String mimeType = "image/*";
//        requestBody = RequestBody.create(MediaType.parse(mimeType), file);
//        String fileName = cover.getName();
//        photo = MultipartBody.Part.createFormData("portrait", fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length()), requestBody);
        //Fresco设置圆形头像
//        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());
//        GenericDraweeHierarchy hierarchy = builder
//                .setDesiredAspectRatio(1.0f)
//                .setFailureImage(R.mipmap.ic_launcher)
//                .setRoundingParams(RoundingParams.fromCornersRadius(100f))
//                .build();
//
//        //加载本地图片
        Uri uri = Uri.fromFile(cover);
        Log.d("uri","get"+uri);
        pic.setImageURI(uri);


//        DraweeController controller = Fresco.newDraweeControllerBuilder()
//                .setOldController(mSimpleDraweeView.getController())
//                .setUri(uri)
//                .build();
//        mSimpleDraweeView.setHierarchy(hierarchy);
//        mSimpleDraweeView.setController(controller);

    }


    /**
     * 裁剪拍照裁剪
     *
     * @param uri
     */
    public void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.putExtra("crop", "true");// crop=true 有这句才能出来最后的裁剪页面.
        intent.putExtra("aspectX", 1);// 这两项为裁剪框的比例.
        intent.putExtra("aspectY", 1);// x:y=1:1
//        intent.putExtra("outputX", 400);//图片输出大小
//        intent.putExtra("outputY", 400);
        intent.putExtra("output", Uri.fromFile(file));
        intent.putExtra("outputFormat", "JPEG");// 返回格式
        startActivityForResult(intent, REQUEST_CODE_CROUP_PHOTO);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {

            case PermissionUtil.REQUEST_SHOWCAMERA:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    uploadAvatarFromPhotoRequest();

                } else {
                    if (!SharedPreferenceMark.getHasShowCamera()) {
                        SharedPreferenceMark.setHasShowCamera(true);
                        new DialogPermission(this, "关闭摄像头权限影响扫描功能");

                    } else {
                        Toast.makeText(this, "未获取摄像头权限", Toast.LENGTH_SHORT)
                                .show();
                    }
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


}