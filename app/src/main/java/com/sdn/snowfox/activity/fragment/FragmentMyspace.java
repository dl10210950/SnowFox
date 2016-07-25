package com.sdn.snowfox.activity.fragment;

import android.view.LayoutInflater;
import android.view.View;

import com.sdn.snowfox.R;

/**
 * 我的空间页面的Fregment
 */
public class FragmentMyspace extends BaseFragment {

    @Override
    public View initView() {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_myspace, null);
        return view;
    }

    @Override
    public void setData() {

    }


}
