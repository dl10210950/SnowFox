package com.sdn.snowfox.activity.bean;

import java.util.List;

/**
 * Created by duanlian on 2016/7/23.
 * 推荐专辑的javabean
 */
public class RecommendAlbum {
    /**
     * albumId : 3529551
     * basedRelativeAlbumId : 0
     * coverLarge : http://fdfs.xmcdn.com/group7/M03/E1/F3/wKgDWlaQmefh3SfHAAAgQOTux5k555_mobile_large.jpg
     * coverMiddle : http://fdfs.xmcdn.com/group7/M03/E1/F3/wKgDWlaQmefh3SfHAAAgQOTux5k555_mobile_large.jpg
     * info : 冷面笑将王自健，爆笑讲述80后生活
     * lastUptrackAt : 1469174369000
     * lastUptrackId : 18833048
     * lastUptrackTitle : 别赶 请你慢下来
     * nickname : 王自健脱口秀
     * playsCounts : 12630265
     * recReason : 根据你的兴趣推荐
     * recSrc : HotRec
     * recTrack : classic:101
     * serialState : 0
     * tags : 今晚80后,脱口秀,综艺秀
     * title : 今晚80后脱口秀 2016
     * trackId : 18833048
     * trackTitle : 别赶 请你慢下来
     * tracks : 36
     * uid : 1000179
     */
    public DataBean data;
    public  class DataBean {
        public boolean hasMore;
        public List<ListBean> list;
        public  class ListBean {
            public int albumId;
            public String coverMiddle;
            public String nickname;
            public int playsCounts;
            public String recReason;
            public int serialState;
            public String title;
            public int trackId;
            public String trackTitle;
            public int tracks;

        }
    }
}
