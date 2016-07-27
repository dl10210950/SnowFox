package com.sdn.snowfox.activity.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sdn.snowfox.R;
import com.sdn.snowfox.activity.bean.AlbumParticularsBean;
import com.sdn.snowfox.activity.bean.RecommendAlbum;
import com.sdn.snowfox.activity.utils.Constants;
import com.sdn.snowfox.activity.utils.ForMartUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by duanlian on 2016/7/27.
 * 专辑详情你节目页面里的listView的adapter
 */
public class MyAlbumProgramListViewAdapter extends BaseAdapter {
    private Context context;
    private boolean isCuson = true;
    private String imgPath;//图片的网址
    List<AlbumParticularsBean.DataBean.TracksBean.ListBean> mlist ;


    public MyAlbumProgramListViewAdapter(Context context) {
        this.context = context;

    }
    public MyAlbumProgramListViewAdapter(Context context,List<AlbumParticularsBean.DataBean.TracksBean.ListBean> list) {
        this.mlist = list;
        this.context = context;

    }


    @Override
    public int getCount() {
        return mlist != null ? mlist.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return mlist != null ? mlist.get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return mlist != null ? i : 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.item_album_program_listview, null);
            viewHolder.prgramImg = (ImageView) view.findViewById(R.id.album_program_play);
            viewHolder.programName = (TextView) view.findViewById(R.id.txt_child_album_name);
            viewHolder.playTimes = (TextView) view.findViewById(R.id.album_program_playtimes);
            viewHolder.duration = (TextView) view.findViewById(R.id.album_program_duration);
            viewHolder.comment = (TextView) view.findViewById(R.id.album_program_comment);
            viewHolder.downIV = (ImageView) view.findViewById(R.id.albun_program_download);
            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        AlbumParticularsBean.DataBean.TracksBean.ListBean listBean = mlist.get(i);
        imgPath = listBean.getCoverMiddle();
        Glide.with(context).load(imgPath).into(viewHolder.prgramImg);
        viewHolder.programName.setText(listBean.getTitle());
        viewHolder.duration.setText(ForMartUtils.formatTime(listBean.getDuration()) + "");
        viewHolder.playTimes.setText(ForMartUtils.formatPlayCount(listBean.getPlaytimes()));
        viewHolder.comment.setText(listBean.getComments() + "");
        return view;
    }


    class ViewHolder {
        ImageView prgramImg;
        TextView programName;
        TextView duration;
        TextView playTimes;
        TextView comment;
        ImageView downIV;

    }

    public void setListData(List<AlbumParticularsBean.DataBean.TracksBean.ListBean> mlist) {
       this.mlist = mlist;
        notifyDataSetChanged();
    }

}
