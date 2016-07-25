package com.sdn.snowfox.activity.fragment;

import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.sdn.snowfox.R;
import com.sdn.snowfox.activity.adapter.MyCustomViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 订阅听页面的Fregment
 */
public class FragmentCustom extends BaseFragment {
    private RadioGroup radioGroup;
    private RadioButton rb_recomment;//推荐按钮
    private RadioButton rb_custom;//订阅按钮
    private RadioButton rb_history;//历史按钮
    public static ViewPager mViewPager;
    private List<BaseFragment> mList;//用来装fragment的集合
    private MyCustomViewPagerAdapter pagerAdapter;

    @Override
    public View initView() {
        //引入布局文件
        View view = View.inflate(getActivity(),R.layout.fragment_custom, null);
        //顶部的三个按钮
        radioGroup = (RadioGroup) view.findViewById(R.id.custom_frag_radiogroup);
        rb_recomment = (RadioButton) view.findViewById(R.id.custom_frag_radiobutton_recommend);
        rb_custom = (RadioButton) view.findViewById(R.id.custom_frag_radiobutton_custom);
        rb_history = (RadioButton) view.findViewById(R.id.custom_frag_radiobutton_history);
        mViewPager = (ViewPager) view.findViewById(R.id.custom_frag_viewpager);
        //实例化fragmemt
        FragmentCustomRecommend customRecommend = new FragmentCustomRecommend();
        FragmentCustomSubscription customSubscription = new FragmentCustomSubscription();
        FragmentCustomHistory customHistory = new FragmentCustomHistory();
        //实例化list集合
        mList = new ArrayList<BaseFragment>();
        mList.add(customRecommend);
        mList.add(customSubscription);
        mList.add(customHistory);
        pagerAdapter = new MyCustomViewPagerAdapter(getChildFragmentManager(),mList);
        mViewPager.setAdapter(pagerAdapter);
        //进入默认选中的页面和按钮
        mViewPager.setCurrentItem(1);
        rb_custom.setChecked(true);

        setOnListener();
        return view;
    }

    /**
     * 给控件设置监听的方法
     */
    private void setOnListener() {
        //radioGroup标题按钮的监听
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.custom_frag_radiobutton_recommend:
                        mViewPager.setCurrentItem(0);//点击推荐按钮切换到第0页
                        break;
                    case R.id.custom_frag_radiobutton_custom:
                        mViewPager.setCurrentItem(1);//点击订阅按钮切换到第1页
                        break;
                    case R.id.custom_frag_radiobutton_history:
                        mViewPager.setCurrentItem(2);//点击历史按钮切换到第2页
                        break;
                }
            }
        });
        //ViewPager的监听事件
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    rb_recomment.setChecked(true);//如果滑到第一页，让推荐按钮选中
                } else if (position == 1) {
                    rb_custom.setChecked(true);//如果滑倒第二页，让订阅按钮处于选中状态

                } else if(position==2){
                    rb_history.setChecked(true);//如果滑倒第二页，让历史按钮处于选中状态

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void setData() {

    }


}
