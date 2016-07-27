package com.sdn.snowfox.activity.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sdn.snowfox.activity.fragment.BaseFragment;

import java.util.List;

/**
 * Created by duanlian on 2016/7/22.
 * 订阅fragment里面的viewPager的adapter
 */
public class MyAlbumFragmentPagerAdapter extends FragmentPagerAdapter {
    List<BaseFragment> list;

    public MyAlbumFragmentPagerAdapter(FragmentManager fragmentManager, List<BaseFragment> mList) {
        super(fragmentManager);
        this.list = mList;
    }


    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
