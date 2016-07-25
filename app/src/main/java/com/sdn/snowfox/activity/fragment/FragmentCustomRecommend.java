package com.sdn.snowfox.activity.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.sdn.snowfox.R;
import com.sdn.snowfox.activity.adapter.MyCustomRecommendListViewAdapter;
import com.sdn.snowfox.activity.bean.RecommendAlbum;
import com.sdn.snowfox.activity.utils.Constants;
import com.sdn.snowfox.activity.utils.MyGetData;

import java.util.ArrayList;
import java.util.List;

/**
 * 发现页面的Fregment
 */
public class FragmentCustomRecommend extends BaseFragment {

    private ListView mListView;
    private MyCustomRecommendListViewAdapter recommendListViewAdapter;
    List<RecommendAlbum> list;


    @Override

    public View initView() {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_custom_recommend, null);
        mListView = (ListView) view.findViewById(R.id.custom_recommend_listview);
        list = new ArrayList<>();
        String path = Constants.RECOMMEND;
        list = MyGetData.getData(path);
        recommendListViewAdapter = new MyCustomRecommendListViewAdapter(getActivity(),list);
        mListView.setAdapter(recommendListViewAdapter);
        mListView.requestLayout();
        recommendListViewAdapter.notifyDataSetChanged();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mListView.requestLayout();
        recommendListViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void setData() {

    }


}
