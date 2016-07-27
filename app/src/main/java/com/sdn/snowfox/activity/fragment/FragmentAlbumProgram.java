package com.sdn.snowfox.activity.fragment;

import android.view.View;
import android.widget.ListView;

import com.sdn.snowfox.R;

/**
 * Created by duanlian on 2016/7/26.
 * 专辑详情里的节目fragment
 */
public class FragmentAlbumProgram extends BaseFragment {
    ListView mListView;
    @Override
    public View initView() {
        View view = View.inflate(getContext(), R.layout.fragment_album_program, null);
        mListView = (ListView) view.findViewById(R.id.album_program_listview);

        return view;
    }

    @Override
    public void setData() {

    }
}
