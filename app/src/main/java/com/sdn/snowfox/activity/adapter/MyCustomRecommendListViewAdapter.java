package com.sdn.snowfox.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sdn.snowfox.R;
import com.sdn.snowfox.activity.bean.RecommendAlbum;

import java.util.List;

/**
 * Created by duanlian on 2016/7/23.
 * 订阅听按钮里面的推荐页面里的listView的adapter
 */
public class MyCustomRecommendListViewAdapter extends BaseAdapter {
    Context context;
    List<RecommendAlbum> list;

    public MyCustomRecommendListViewAdapter(Context context, List<RecommendAlbum> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list != null ? list.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.item_custom_lv_album, null);
            viewHolder.albumImg = (ImageView) view.findViewById(R.id.img_child_sound_head);
            viewHolder.albumName = (TextView) view.findViewById(R.id.txt_child_album_name);
            viewHolder.recReason = (TextView) view.findViewById(R.id.txt_child_album_recreason);
            viewHolder.playTimes = (TextView) view.findViewById(R.id.txt_playtimes);
            viewHolder.tracks = (TextView) view.findViewById(R.id.txt_tracks);
            viewHolder.recButton = (ImageView) view.findViewById(R.id.btn_collect);
            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        String imgPath = list.get(i).getData().getList().get(i).getCoverMiddle();
        Glide.with(context).load(imgPath).into(viewHolder.albumImg);
        viewHolder.albumName.setText(list.get(i).getData().getList().get(i).getTitle());
        viewHolder.recReason.setText(list.get(i).getData().getList().get(i).getRecReason().toString());
        viewHolder.playTimes.setText(list.get(i).getData().getList().get(i).getPlaysCounts() / 10000 + "万");
        viewHolder.tracks.setText(list.get(i).getData().getList().get(i).getTracks() + "集");
        viewHolder.recButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }


    static class ViewHolder {
        ImageView albumImg;
        TextView albumName;
        TextView recReason;
        TextView playTimes;
        TextView tracks;
        ImageView recButton;

    }
}
