package com.example.songyanjun.myhospital.Fragement3;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.songyanjun.myhospital.R;

import java.io.File;

public class PhotoPickerFragment extends DialogFragment {
    public final static int REQUEST_IMAGE_SELECT = 2;
    private Button cam;

    private Button alb;

    private ImageView imageview;

    private static final int REQUEST_CODE_TAKE_PHOTO = 4;
    private static final int REQUEST_CODE_ALBUM = 2;
    private static final int REQUEST_CODE_CROUP_PHOTO = 3;

    private File file;
    private Uri uri;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.photopicker, container,false);
        cam = (Button) view.findViewById(R.id.Btn_camera);
        alb = (Button) view.findViewById(R.id.Btn_album);
        imageview =(ImageView) getActivity().findViewById(R.id.apply_img);



        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (PermissionUtil.hasCameraPermission(getActivity())) {
//                    uploadAvatarFromPhotoRequest();
//                }
                  dismiss();
            }
        });

        alb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(Intent.ACTION_PICK);
//                intent.setType("image/*");
//                startActivityForResult(intent, REQUEST_IMAGE_SELECT);
//                uploadAvatarFromAlbumRequest();

                dismiss();

            }
        });
//        init();
        return view;
    }

/*

    private void init() {
        file = new File(FileUtil.getCachePath(getActivity()), "user-avatar.jpg");
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            uri = Uri.fromFile(file);
        } else {
            //通过FileProvider创建一个content类型的Uri(android 7.0需要这样的方法跨应用访问)
//            uri = FileProvider.getUriForFile(MyApplication.getApp(), "com.yf.useravatar", file);
//            uri = FileProvider.getUriForFile(getApplication(), "com.yf.useravatar", file);

        }
    }

    private void uploadAvatarFromPhotoRequest() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(intent, REQUEST_CODE_TAKE_PHOTO);
    }

    */
/**
     * album
     *//*

    private void uploadAvatarFromAlbumRequest() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image*/
/*");
        startActivityForResult(photoPickerIntent, REQUEST_CODE_ALBUM);
    }


    private void uploadAvatarFromPhoto() {
        compressAndUploadAvatar(file.getPath());

    }

    private void compressAndUploadAvatar(String fileSrc) {
        final File cover = FileUtil.getSmallBitmap(getContext(), fileSrc);
//        String mimeType = "image*/
/*";
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
        imageview.setImageURI(uri);


//        DraweeController controller = Fresco.newDraweeControllerBuilder()
//                .setOldController(mSimpleDraweeView.getController())
//                .setUri(uri)
//                .build();
//        mSimpleDraweeView.setHierarchy(hierarchy);
//        mSimpleDraweeView.setController(controller);

    }


    */
/**
     * 裁剪拍照裁剪
     *
     * @param uri
     *//*

    public void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image*/
/*");
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
                        new DialogPermission(getContext(), "关闭摄像头权限影响扫描功能");

                    } else {
                        Toast.makeText(getContext(), "未获取摄像头权限", Toast.LENGTH_SHORT)
                                .show();
                    }
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
*/


    public interface PhotoListener{
        void getPhoto(int way);
    }

}
