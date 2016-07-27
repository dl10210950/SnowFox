package com.sdn.snowfox.activity.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
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
import com.sdn.snowfox.activity.bean.RecommendAlbum;
import com.sdn.snowfox.activity.utils.Constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by duanlian on 2016/7/23.
 * 订阅听按钮里面的推荐页面里的listView的adapter
 */
public class MyCustomRecommendListViewAdapter extends BaseAdapter {
    private Context context;
    List<RecommendAlbum.DataBean.ListBean> mlist;
    private boolean isCuson = true;
    private String imgPath;//图片的网址

    public MyCustomRecommendListViewAdapter(FragmentActivity activity,List<RecommendAlbum.DataBean.ListBean> list ) {
        this.context = activity;
        this.mlist = list;
        if (Constants.ALBUMLIST!=null) {
            Constants.ALBUMLIST.clear();
        }

    }


    @Override
    public int getCount() {
        return mlist!=null?mlist.size():0;
    }

    @Override
    public Object getItem(int i) {
        return mlist.get(i);
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
            viewHolder.recCB = (ImageButton) view.findViewById(R.id.checkbox_collect);
            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        final RecommendAlbum.DataBean.ListBean listBean =mlist.get(i);
        imgPath = listBean.coverMiddle;
        Glide.with(context).load(mlist.get(i).coverMiddle).into(viewHolder.albumImg);
        viewHolder.albumName.setText(listBean.title);
        viewHolder.recReason.setText(listBean.recReason.toString());
        viewHolder.playTimes.setText(listBean.playsCounts / 10000 + "万");
        viewHolder.tracks.setText(listBean.tracks + "集");



        viewHolder.recCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (isCuson) {
                    view.setBackgroundResource(R.drawable.btn_collected_new);
                    isCuson = false;
                    Toast.makeText(context, "订阅成功！", Toast.LENGTH_SHORT).show();
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("img", listBean.coverMiddle);//专辑图片
                    map.put("title", listBean.title);//专辑名
                    map.put("nickname", listBean.nickname);//名字
                    map.put("track", listBean.tracks);//多少集
                    map.put("tracktitle", listBean.trackTitle);//专辑概要
                    Constants.ALBUMLIST.add(map);


                } else {
                    view.setBackgroundResource(R.drawable.btn_collect_new);

                    new AlertDialog.Builder(context).setTitle("温馨提示")
                            .setMessage("确定取消订阅该专辑？").
                            setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(context, "已取消订阅！", Toast.LENGTH_SHORT).show();
                                    isCuson = true;
                                }
                            }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            view.setBackgroundResource(R.drawable.btn_collected_new);
                            isCuson = false;
                        }
                    }).create().show();
                }

            }
        });


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

    public void setList(List<RecommendAlbum.DataBean.ListBean> mList) {
        this.mlist = mList;
        notifyDataSetChanged();
    }

}
