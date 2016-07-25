package com.sdn.snowfox.activity.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sdn.snowfox.R;

import java.util.zip.Inflater;

/**
 * 发现页面的Fregment
 */
public class FragmentFind extends BaseFragment {

    @Override
    public View initView() {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_find, null);
        return view;
    }

    @Override
    public void setData() {

    }


}
