package com.sdn.snowfox.activity.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import com.sdn.snowfox.activity.adapter.MyAlbumFragmentPagerAdapter;
import com.sdn.snowfox.activity.bean.AlbumParticularsBean;
import com.sdn.snowfox.activity.fragment.BaseFragment;
import com.sdn.snowfox.activity.fragment.FragmentAlbumProgram;
import com.sdn.snowfox.activity.fragment.FragmentAlbumPurticulars;
import com.sdn.snowfox.activity.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * 专辑详情页面
 */
public class AlbumParticulars extends FragmentActivity {
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
    private String path;//接口地址
    private String albumId;//专辑id，通过专辑id拼接网址
    private String uid;//也是拼接网址的数据
    private String title;//要显示的标题
    private String nickname;//
    private ViewPager mViewPager;
    private MyAlbumFragmentPagerAdapter pagerAdapter;
    private List<BaseFragment> list;//装fragment的集合
    private RadioGroup mRadioGroup;
    private RadioButton parRadioBtn;//详情按钮
    private RadioButton proRadioBtn;//节目按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_particulars);
        albumId = getIntent().getStringExtra("albumId");
        path = Constants.ALBUMPARTICULARS + albumId;
        getData(path);//请求数据
        initView();//初始化控件
        setOnListener();//给控件设置监听

    }

    /**
     * 初始化控件的方法
     */
    private void initView() {
        back = (ImageButton) findViewById(R.id.album_particulars_back);
        //专辑图片
        imgAlbum = (ImageView) findViewById(R.id.album_particulars_image);

        //标题
        tvTitle = (TextView) findViewById(R.id.album_particulars_title);
       //主播名字
        tvName = (TextView) findViewById(R.id.album_particulars_name);
        //播放次数
        tvPlayCount = (TextView) findViewById(R.id.album_particulars_playcounts);
        //分类
        tvClassify = (TextView) findViewById(R.id.album_particulars_classify);
        //分享按钮
        shared = (ImageButton) findViewById(R.id.album_particulars_shared);
        mViewPager = (ViewPager) findViewById(R.id.album_particulars_viewpager);
        list = new ArrayList<>();
        //详情和节目的fragment
        FragmentAlbumPurticulars albumPurticulars = new FragmentAlbumPurticulars();
        FragmentAlbumProgram albumProgram = new FragmentAlbumProgram();
        list.add(albumPurticulars);
        list.add(albumProgram);
        pagerAdapter = new MyAlbumFragmentPagerAdapter(getSupportFragmentManager(),list);
        mViewPager.setAdapter(pagerAdapter);

        mRadioGroup = (RadioGroup) findViewById(R.id.album_particulars_radiogroup);
        parRadioBtn = (RadioButton) findViewById(R.id.album_particulars_radiobutton_par);
        proRadioBtn = (RadioButton) findViewById(R.id.album_particulars_radiobutton_program);
        //默认页面
        mViewPager.setCurrentItem(1);
        proRadioBtn.setChecked(true);
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
        //分享按钮的监听事件
        shared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showShare();
            }
        });
        //详情和节目的监听
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int isChecked) {
                switch (isChecked) {
                    case R.id.album_particulars_radiobutton_par://详情
                        mViewPager.setCurrentItem(0);//让ViewPager显示第0页也就是详情的fragment
                        break;
                    case R.id.album_particulars_radiobutton_program://节目
                        mViewPager.setCurrentItem(1);
                        break;
                }
            }
        });
        //viewPager的监听事件
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    parRadioBtn.setChecked(true);//让详情按钮处于选中状态
                } else {
                    proRadioBtn.setChecked(true);//让节目按钮处于选中状态

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

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
                        //拿到解析完的数据
                        albumParticularsBean = gson.fromJson(httpResult, AlbumParticularsBean.class);
                        //添加到全局变量
                        Constants.PROGRAMLIST.add(albumParticularsBean);
                        Glide.with(AlbumParticulars.this).load(albumParticularsBean.getData().getAlbum().getCoverMiddle()).into(imgAlbum);
                        title = albumParticularsBean.getData().getAlbum().getTitle();
                        tvTitle.setText(title);
                        nickname = albumParticularsBean.getData().getAlbum().getNickname();
                        tvName.setText("主播：" + nickname);
                        tvPlayCount.setText("播放：" + albumParticularsBean.getData().getAlbum().getPlayTimes() / 10000 + "万次");
                        tvClassify.setText("分类：" + albumParticularsBean.getData().getAlbum().getCategoryName().toString());
                        //用来拼接网址
                        uid = albumParticularsBean.getData().getAlbum().getUid() + "";
                        proRadioBtn.setText("节目（"+albumParticularsBean.getData().getAlbum().getTracks()+"）");

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
