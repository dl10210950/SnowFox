package com.sdn.snowfox.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.sdn.snowfox.R;
import com.sdn.snowfox.activity.activity.AlbumParticulars;
import com.sdn.snowfox.activity.adapter.MyCustomRecommendListViewAdapter;
import com.sdn.snowfox.activity.bean.RecommendAlbum;
import com.sdn.snowfox.activity.utils.Constants;

import java.util.List;

/**
 * 订阅听里面的推荐页面的Fregment
 */
public class FragmentCustomRecommend extends BaseFragment {

    private ListView mListView;
    private MyCustomRecommendListViewAdapter adapter;
    List<RecommendAlbum.DataBean.ListBean> list;


    @Override

    public View initView() {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_custom_recommend, null);
        mListView = (ListView) view.findViewById(R.id.custom_recommend_listview);
        String path = Constants.RECOMMEND;
        getData(path);
        adapter = new MyCustomRecommendListViewAdapter(getActivity(), list);
        mListView.setAdapter(adapter);
        setOnListener();
        return view;
    }

    /**
     * 给控件设置监听事件的方法
     */
    private void setOnListener() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getContext(), AlbumParticulars.class);
                intent.putExtra("albumId", list.get(position).albumId + "");//把专辑id传过去
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void setData() {


    }


    public List<RecommendAlbum.DataBean.ListBean> getData(String path) {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET,
                path,
                new RequestCallBack<String>() {
                    // 请求成功
                    public void onSuccess(ResponseInfo<String> arg0) {
                        String httpResult = arg0.result;//拿到请求回来的数据
//                        Toast.makeText(getContext(), httpResult + "", Toast.LENGTH_SHORT).show();
                         Gson gson = new Gson();
                        RecommendAlbum recommendAlbum = gson.fromJson(httpResult, RecommendAlbum.class);
                        list = recommendAlbum.data.list;

                        Log.i("TAG", recommendAlbum.data.list.size() + "");
//                            Toast.makeText(getContext(), list.size()+"", Toast.LENGTH_SHORT).show();
                        adapter = new MyCustomRecommendListViewAdapter(getActivity(), list);
                        mListView.setAdapter(adapter);

                    }

                    // 请求失败
                    public void onFailure(HttpException arg0, String arg1) {
                    }
                });

        return list;
    }

}


