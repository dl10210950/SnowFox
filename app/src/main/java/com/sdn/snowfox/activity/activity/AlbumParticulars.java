package com.sdn.snowfox.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.sdn.snowfox.R;
import com.sdn.snowfox.activity.adapter.MyCustomRecommendListViewAdapter;
import com.sdn.snowfox.activity.bean.AlbumParticularsBean;
import com.sdn.snowfox.activity.bean.RecommendAlbum;
import com.sdn.snowfox.activity.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * 专辑详情页面
 */
public class AlbumParticulars extends Activity {
    private ImageButton back;//返回按钮
    private ImageButton shared;//分享按钮
    private ImageButton more;//。。。按钮
    private TextView custom;//订阅
    private TextView togetherDown;//批量下载
    private ImageView imgAlbum;//专辑封面
    private TextView tvTitle;//专辑名字
    private  TextView tvName;//专辑主播
    private TextView tvPlayCount;//播放次数
    private  TextView tvClassify;//专辑分类
    private AlbumParticularsBean albumParticularsBean;
    private String path;
    private String albumId;
    private String uid;
    private String title;//要显示的标题
    private String nickname;//
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_particulars);
        albumId = getIntent().getStringExtra("albumId");
        path = Constants.ALBUMPARTICULARS + albumId;
        getData(path);
        initView();
        setOnListener();

    }

    /**
     * 初始化控件的方法
     */
    private void initView() {
        back = (ImageButton) findViewById(R.id.album_particulars_back);
//        //专辑图片
        imgAlbum = (ImageView) findViewById(R.id.album_particulars_image);

//        //标题
        tvTitle = (TextView) findViewById(R.id.album_particulars_title);
//        //主播名字
        tvName = (TextView) findViewById(R.id.album_particulars_name);
//        //播放次数
        tvPlayCount = (TextView) findViewById(R.id.album_particulars_playcounts);
//        //分类
        tvClassify = (TextView) findViewById(R.id.album_particulars_classify);
//
        shared = (ImageButton) findViewById(R.id.album_particulars_shared);
        mViewPager = (ViewPager) findViewById(R.id.album_particulars_viewpager);

    }

    /**
     * 给控件设置监听的方法
     */
    private void setOnListener() {
        //返回按钮的监听事件
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        shared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showShare();
            }
        });
    }

    private void getData(String path) {
        Log.e("TAG", path);
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET,
                path,
                new RequestCallBack<String>() {
                    // 请求成功
                    public void onSuccess(ResponseInfo<String> arg0) {
                        String httpResult = arg0.result;//拿到请求回来的数据
                        Gson gson = new Gson();
                        albumParticularsBean = gson.fromJson(httpResult, AlbumParticularsBean.class);
                        Glide.with(AlbumParticulars.this).load(albumParticularsBean.getData().getAlbum().getCoverMiddle()).into(imgAlbum);
                        title = albumParticularsBean.getData().getAlbum().getTitle();
                        tvTitle.setText(title);
                        nickname = albumParticularsBean.getData().getAlbum().getNickname();
                        tvName.setText("主播：" + nickname);
                        tvPlayCount.setText("播放：" + albumParticularsBean.getData().getAlbum().getPlayTimes() / 10000 + "万次");
                        tvClassify.setText("分类：" + albumParticularsBean.getData().getAlbum().getCategoryName().toString());
                        uid = albumParticularsBean.getData().getAlbum().getUid() + "";

                    }

                    // 请求失败
                    public void onFailure(HttpException arg0, String arg1) {
                        Toast.makeText(AlbumParticulars.this, "网络请求失败", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    /**
     * 分享
     */
    private void showShare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(title);
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://m.ximalaya.com/" + uid + "/album/" + albumId);
        // text是分享文本，所有平台都需要这个字段
        oks.setText(nickname);
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://m.ximalaya.com/" + uid + "/album/" + albumId);
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://m.ximalaya.com/" + uid + "/album/" + albumId);

// 启动分享GUI
        oks.show(this);
    }

}
