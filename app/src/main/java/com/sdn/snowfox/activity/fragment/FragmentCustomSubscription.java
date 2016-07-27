package com.sdn.snowfox.activity.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.sdn.snowfox.R;
import com.sdn.snowfox.activity.activity.RegisterActivity;
import com.sdn.snowfox.activity.adapter.MyCustomSubscriptionListViewAdapter;
import com.sdn.snowfox.activity.utils.Constants;

/**
 * 订阅听里面的订阅页面的Fregment
 */
public class FragmentCustomSubscription extends BaseFragment {
    private LinearLayout linearLayout;
    private ListView listView;
    private MyCustomSubscriptionListViewAdapter adapter;
    @Override
    public View initView() {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_custom_subscription, null);
        linearLayout = (LinearLayout) view.findViewById(R.id.custom_subscription_linearlayout);
        listView = (ListView) view.findViewById(R.id.custom_subscription_listview);

        if (Constants.ALBUMLIST .size()>0) {
            linearLayout.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
            Toast.makeText(getContext(), Constants.ALBUMLIST .size()+"", Toast.LENGTH_SHORT).show();
            adapter = new MyCustomSubscriptionListViewAdapter(getContext(),Constants.ALBUMLIST);
            adapter.setList(Constants.ALBUMLIST);
            listView.setAdapter(adapter);
        } else {
            linearLayout.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
        }

        setOnClickListener(view);

        return view;
    }

    /**
     * 控件设置监听的方法
     * @param view
     */
    private void setOnClickListener(View view) {
        //看看推荐按钮的监听
        view.findViewById(R.id.custom_subscription_look_recommend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new FragmentCustom().mViewPager.setCurrentItem(0);

            }
        });
        //登陆已有账号按钮的监听事件
        view.findViewById(R.id.custom_subscription_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(getContext(),RegisterActivity.class);
                startActivity(registerIntent);

            }
        });
    }

    @Override
    public void setData() {

    }


}
