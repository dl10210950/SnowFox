package com.sdn.snowfox.activity.fragment;

import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.sdn.snowfox.R;
import com.sdn.snowfox.activity.activity.AlbumParticulars;
import com.sdn.snowfox.activity.adapter.MyAlbumProgramListViewAdapter;
import com.sdn.snowfox.activity.bean.AlbumParticularsBean;

import java.util.List;

/**
 * Created by duanlian on 2016/7/26.
 * 专辑详情里的节目fragment
 */
public class FragmentAlbumProgram extends BaseFragment implements AlbumParticulars.DataChanged{
    private ListView mListView;
    private MyAlbumProgramListViewAdapter listViewAdapter;
    @Override
    public View initView() {
        View view = View.inflate(getContext(), R.layout.fragment_album_program, null);
        mListView = (ListView) view.findViewById(R.id.album_program_listview);
        listViewAdapter = new MyAlbumProgramListViewAdapter(getActivity());
        mListView.setAdapter(listViewAdapter);
        listViewAdapter.notifyDataSetChanged();

        ((AlbumParticulars)getActivity()).setDataChanged(this);

        return view;
    }

    @Override
    public void setData() {
        listViewAdapter.notifyDataSetChanged();
    }



    @Override
    public void setOnDataChanged(List<AlbumParticularsBean.DataBean.TracksBean.ListBean> mlist) {
        listViewAdapter = new MyAlbumProgramListViewAdapter(getActivity(),mlist);
        mListView.setAdapter(listViewAdapter);
    }
}
