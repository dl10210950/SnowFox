package com.sdn.snowfox.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by duanlian on 2016/7/22.
 * baseFragment是提供给其他fragment继承的父类
 * 因为我们定义的这个基类就是为了被继承使用的 把Fragment中需要实现的3个方法放到基类中调用 子类继承基类以后，就不粗腰去重写这三个生命周期方法了
 * 但是子类需要有自己的视图，如果子类中没有onCreateView方法 就需要让基类来负责显示子类的视图
 * 这样基类就需要提供给一个设置视图的方法，让子类去实现 所有我们要在基类中定义一个initView()返回值为view类型
 * 子类实现该方法后，基类负责显示视图
 */
public abstract class BaseFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return initView();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        setData();
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * 初始化界面的方法
     *
     * @return
     */
    public abstract View initView();

    /**
     * 设置数据的方法
     */
    public abstract void setData();
}
