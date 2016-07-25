package com.sdn.snowfox.activity.fragment;

import android.view.LayoutInflater;
import android.view.View;

import com.sdn.snowfox.R;

/**
 * 下载页面的Fregment
 */
public class FragmentDownload extends BaseFragment {

    @Override
    public View initView() {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_download, null);
        return view;
    }

    @Override
    public void setData() {

    }


}
