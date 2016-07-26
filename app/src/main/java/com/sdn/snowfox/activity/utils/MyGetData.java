//package com.sdn.snowfox.activity.utils;
//
//
//import android.util.Log;
//import android.widget.Toast;
//
//import com.google.gson.Gson;
//import com.lidroid.xutils.HttpUtils;
//import com.lidroid.xutils.exception.HttpException;
//import com.lidroid.xutils.http.ResponseInfo;
//import com.lidroid.xutils.http.callback.RequestCallBack;
//import com.lidroid.xutils.http.client.HttpRequest;
//import com.sdn.snowfox.activity.bean.RecommendAlbum;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by duanlian on 2016/7/23.
// * 专门用来网络请求数据
// */
//public class MyGetData {
//
//    private static String httpResult;
//    private static List<RecommendAlbum> list = new ArrayList<RecommendAlbum>();
//
//    public static List<RecommendAlbum> getData(String path) {
//        HttpUtils httpUtils = new HttpUtils();
//        httpUtils.send(HttpRequest.HttpMethod.GET,
//                path,
//                new RequestCallBack<String>() {
//                    // 请求成功
//                    public void onSuccess(ResponseInfo<String> arg0) {
//                        httpResult = arg0.result;//拿到请求回来的数据
//                        Gson gson = new Gson();
//                        RecommendAlbum recommendAlbum = gson.fromJson(httpResult, RecommendAlbum.class);
//                        list.add(recommendAlbum);
//
//                    }
//
//                    // 请求失败
//                    public void onFailure(HttpException arg0, String arg1) {
//                    }
//                });
//
//        return list;
//    }
//
//}
