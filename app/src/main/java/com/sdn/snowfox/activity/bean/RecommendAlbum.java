package com.sdn.snowfox.activity.bean;

import java.util.List;

/**
 * Created by duanlian on 2016/7/23.
 * 推荐专辑的javabean
 */
public class RecommendAlbum {


    /**
     * hasMore : true
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * albumId : 2839012
         * basedRelativeAlbumId : 4627127
         * coverLarge : http://fdfs.xmcdn.com/group15/M0B/58/32/wKgDZVXB2hvibPTgAAQyivAJrrs457_mobile_large.jpg
         * coverMiddle : http://fdfs.xmcdn.com/group15/M0B/58/32/wKgDZVXB2hvibPTgAAQyivAJrrs457_mobile_large.jpg
         * info : 打造自身气质，拥有不褪色的个人魅力！（每周五更新）
         * lastUptrackAt : 1468935600000
         * lastUptrackId : 18692159
         * lastUptrackTitle : 【气质提升】19 你想变漂亮？首先要学会得体（求打赏，给点动力吧！）
         * nickname : 上官雨落
         * playsCounts : 162402
         * recReason : 根据《5分钟心理学》推荐
         * recSrc : cf1
         * recTrack : chr-6
         * serialState : 0
         * tags : 气质,男神,女神,成长,修养
         * title : 气质提升
         * trackId : 18692159
         * trackTitle : 【气质提升】19 你想变漂亮？首先要学会得体（求打赏，给点动力吧！）
         * tracks : 21
         * uid : 20533168
         */

        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private String coverMiddle;
            private int playsCounts;
            private String recReason;
            private String title;
            private int trackId;
            private int tracks;

            public String getCoverMiddle() {
                return coverMiddle;
            }

            public void setCoverMiddle(String coverMiddle) {
                this.coverMiddle = coverMiddle;
            }

            public int getPlaysCounts() {
                return playsCounts;
            }

            public void setPlaysCounts(int playsCounts) {
                this.playsCounts = playsCounts;
            }

            public String getRecReason() {
                return recReason;
            }

            public void setRecReason(String recReason) {
                this.recReason = recReason;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getTrackId() {
                return trackId;
            }

            public void setTrackId(int trackId) {
                this.trackId = trackId;
            }

            public int getTracks() {
                return tracks;
            }

            public void setTracks(int tracks) {
                this.tracks = tracks;
            }
        }
    }
}
