package com.sdn.snowfox.activity.utils;

/**
 * Created by duanlian on 2016/7/27.
 * 用来格式化数据的
 */
public class ForMartUtils {
    /**
     * 用来格式化时间
     * @param time 传入一个秒
     * @return
     */
    public static String formatTime(int time){
        if (time  / 60 < 10) {
            return "0" + time  / 60 + ":0" + time  % 60;
        } else {
            return time /  60 + ":" + time  % 60;
        }


    }

    /**
     * 格式化播放次数的方法
     * @param playCount
     * @return
     */
    public static String formatPlayCount(int playCount){
        if (playCount < 10000) {
            return playCount + "次";
        } else {
            return playCount / 10000 + "次";
        }
    }


}
