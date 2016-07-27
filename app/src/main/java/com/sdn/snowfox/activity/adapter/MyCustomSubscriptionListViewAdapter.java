package com.sdn.snowfox.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sdn.snowfox.R;

import java.util.List;
import java.util.Map;

/**
 * Created by duanlian on 2016/7/23.
 * 订阅听按钮里面的推荐页面里的listView的adapter
 */
public class MyCustomSubscriptionListViewAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String, Object>> list;
    private boolean isCuson = true;
    private String imgPath;//图片的网址


    public MyCustomSubscriptionListViewAdapter(Context context, List<Map<String, Object>> list) {
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
    public View getView(final int position, View view, ViewGroup viewGroup) {
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
            viewHolder.recCB = (ImageButton) view.findViewById(R.id.checkbox_collect);
            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        imgPath = (String) list.get(position).get("img");
        Glide.with(context).load(imgPath).into(viewHolder.albumImg);
        viewHolder.albumName.setText(list.get(position).get("title").toString());
        viewHolder.playTimes.setText(list.get(position).get("nickname").toString());
        viewHolder.recReason.setText(list.get(position).get("tracktitle").toString());
        viewHolder.tracks.setText(list.get(position).get("track")+"集");
        viewHolder.recCB.setVisibility(View.INVISIBLE);

        return view;
    }


    class ViewHolder {
        ImageView albumImg;
        TextView albumName;
        TextView recReason;
        TextView playTimes;
        TextView tracks;
        ImageButton recCB;

    }
    public  void setList(List<Map<String, Object>> list){
        this.list = list;
    }

}
