package cn.hellozhaojun.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity implements OnClickListener{
    //声明ViewPager
    private ViewPager mViewPager;
    //声明适配器
    private FragmentPagerAdapter mAdapter;
    //声明fragment集合
    private List<Fragment> mFragments;
    //声明 3个 TAB布局文件
    private LinearLayout mTabIndex;
    private LinearLayout mTabTools;
    private LinearLayout mTabSetting;
    //声明 3个 TAB的imageButton
    private ImageButton mIndexImg;
    private ImageButton mToolsImg;
    private ImageButton mSettingImg;
    //声明 3个Fragment
    private Fragment mFragIndex;
    private Fragment mFragTools;
    private Fragment mFragSetting;
    //声明 3个文本
    private TextView mIndexText;
    private TextView mToolsText;
    private TextView mSettingText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//初始化控件
        initEvents();//初始化点击事件
//        selectTab(0);
        initDatas();
    }

    private void initDatas() {
        mFragments = new ArrayList<>();
        mFragments.add(new IndexFragment());
        mFragments.add(new ToolsFragment());
        mFragments.add(new SettingFragment());

        //初始化适配器
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };
        mViewPager.setAdapter(mAdapter);
        //设置ViewPager的切换监听
        mViewPager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            //页面滚动事件
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //页面选中事件
            @Override
            public void onPageSelected(int position) {
                //设置position对应的集合中的Fragment
                mViewPager.setCurrentItem(position);
                resetImgs();
                selectTab(position);
            }

            @Override
            //页面滚动状态改变事件
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initEvents() {
        mTabIndex.setOnClickListener(this);
        mTabTools.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        mTabIndex = (LinearLayout) findViewById(R.id.id_tab_index);
        mTabTools = (LinearLayout) findViewById(R.id.id_tab_tools);
        mTabSetting = (LinearLayout) findViewById(R.id.id_tab_setting);

        mIndexImg = (ImageButton) findViewById(R.id.id_tab_index_img);
        mToolsImg = (ImageButton) findViewById(R.id.id_tab_tools_img);
        mSettingImg = (ImageButton) findViewById(R.id.id_tab_setting_img);
    }

    @Override
    public void onClick(View v) {
        resetImgs();
        switch (v.getId()){
            case R.id.id_tab_index:
                selectTab(0);
                break;
            case R.id.id_tab_tools:
                selectTab(1);
                break;
            case R.id.id_tab_setting:
                selectTab(2);
                break;
        }
    }

    private void selectTab(int i) {
//        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
/*        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        hideFragment(transaction);*/
        switch (i){
            case 0:
                mIndexImg.setImageResource(R.drawable.tab_weixin_pressed);
/*                if (mFragIndex == null){
                    mFragIndex = new IndexFragment();
                    transaction.add(R.id.id_content,mFragIndex);
                }else {
                    transaction.show(mFragIndex);
                }*/
                break;
            case 1:
                mToolsImg.setImageResource(R.drawable.tab_address_pressed);
/*                if (mFragTools == null){
                    mFragTools = new ToolsFragment();
                    transaction.add(R.id.id_content,mFragTools);
                }else {
                    transaction.show(mFragTools);
                }*/
                break;
            case 2:
                mSettingImg.setImageResource(R.drawable.tab_settings_pressed);
/*                if (mFragSetting == null){
                    mFragSetting = new SettingFragment();
                    transaction.add(R.id.id_content,mFragSetting);
                }else {
                    transaction.show(mFragSetting);
                }*/
                break;
        }
        mViewPager.setCurrentItem(i);
    }

/*    private void hideFragment(FragmentTransaction transaction) {
        if (mFragIndex !=null){
            transaction.hide(mFragIndex);
        }
        if (mFragTools !=null){
            transaction.hide(mFragTools);
        }
        if (mFragSetting !=null){
            transaction.hide(mFragSetting);
        }
    }*/

    private void resetImgs() {
        mIndexImg.setImageResource(R.drawable.tab_weixin_normal);
        mToolsImg.setImageResource(R.drawable.tab_address_normal);
        mSettingImg.setImageResource(R.drawable.tab_settings_normal);
    }
}
