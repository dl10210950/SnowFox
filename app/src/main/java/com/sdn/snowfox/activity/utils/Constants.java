package com.sdn.snowfox.activity.utils;

import android.net.LinkAddress;

import com.sdn.snowfox.activity.bean.AlbumParticularsBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by duanlian on 2016/7/23.
 * 放置全局变量的类
 */
public class Constants {
    /**
     * 点击订阅听后进去推荐fragment的接口数据
     */
    public static String RECOMMEND = "http://mobile.ximalaya.com/feed/v1/recommend/classic/unlogin?device=android&pageId=1&pageSize=20";
    /**
     * 点击推荐里面的item按钮后跳转到详情页面的接口需要拼接albumId
     */
    public static String ALBUMPARTICULARS = "http://mobile.ximalaya.com/mobile/v1/album?albumId=";
    /**
     * 用于推荐专辑页面点击订阅按钮后把信息赋值给全局变量，在订阅的fragment里面就能用
     */
    public static List<Map<String, Object>> ALBUMLIST = new ArrayList<>();
    /**
     * 用来把专辑详情里的数据赋值给全局变量，在专辑详情的节目fragment里面需要用到
     */
    public static List<AlbumParticularsBean> PROGRAMLIST = new ArrayList<>();
}
