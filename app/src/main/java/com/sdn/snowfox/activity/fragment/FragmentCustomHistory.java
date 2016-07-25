package com.sdn.snowfox.activity.fragment;

import android.view.LayoutInflater;
import android.view.View;

import com.sdn.snowfox.R;

/**
 * 发现页面的Fregment
 */
public class FragmentCustomHistory extends BaseFragment {

    @Override
    public View initView() {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_custom_history, null);
        return view;
    }

    @Override
    public void setData() {

    }


}
