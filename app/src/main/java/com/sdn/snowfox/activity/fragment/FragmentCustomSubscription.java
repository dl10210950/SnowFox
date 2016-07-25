package com.sdn.snowfox.activity.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;

import com.sdn.snowfox.R;
import com.sdn.snowfox.activity.activity.RegisterActivity;

/**
 * 发现页面的Fregment
 */
public class FragmentCustomSubscription extends BaseFragment {


    @Override
    public View initView() {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_custom_subscription, null);

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
        //登陆已有账号的监听事件
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
