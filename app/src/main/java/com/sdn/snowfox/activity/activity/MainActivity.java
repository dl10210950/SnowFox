package com.sdn.snowfox.activity.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import com.sdn.snowfox.R;
import com.sdn.snowfox.activity.fragment.BaseFragment;
import com.sdn.snowfox.activity.fragment.FragmentCustom;
import com.sdn.snowfox.activity.fragment.FragmentDownload;
import com.sdn.snowfox.activity.fragment.FragmentFind;
import com.sdn.snowfox.activity.fragment.FragmentMyspace;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup radioGroup;
    private ImageButton playBtn;//底部标题栏中间的播放暂停按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setOnListener();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        radioGroup = (RadioGroup) findViewById(R.id.main_radiogroup_title);
        playBtn = (ImageButton) findViewById(R.id.main_imagebutton_playing);
    }

    /**
     * 给控件设置监听
     */
    private void setOnListener() {
        radioGroup.setOnCheckedChangeListener(this);
    }

    /**
     * 实现RadioGroup的OnClick重写的方法
     */
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
            case R.id.main_radiobutton_find://点击发现按钮
                switchFragment(new FragmentFind());
                break;
            case R.id.main_radiobutton_custom://点击订阅听按钮
                switchFragment(new FragmentCustom());
                break;
            case R.id.main_radiobutton_download://点击下载听按钮
                switchFragment(new FragmentDownload());
                break;
            case R.id.main_radiobutton_myspace://点击我的按钮
                switchFragment(new FragmentMyspace());
                break;
        }
    }

    /**
     * 用来让fragment替换framlayout的方法
     * @param fragment 需要替换进去的fagment
     */
    private void switchFragment(BaseFragment fragment){
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_framelayout,fragment).commit();


    }
}
