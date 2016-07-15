package com.example.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.imooc.view.viewPagerIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {
    private ViewPager mViewPager;
    private viewPagerIndicator mIndicator;
    private List<Fragment> mcontents = new ArrayList<Fragment>();
    private FragmentPagerAdapter mAdapter;
    private List<String> mlist = Arrays.asList("短信", "收藏", "推荐", "联系人", "通讯录", "通讯列表");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        init();

        initDate();

        mViewPager.setAdapter(mAdapter);

        mViewPager.setOnPageChangeListener(this);
    }

    private void init() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        mIndicator = (viewPagerIndicator) findViewById(R.id.id_indicator);
    }

    private void initDate() {
//        for (String title : mlist) {
//
//            vpSimpleFragment fragment = vpSimpleFragment.newInstance(title);
//            mcontents.add(fragment);
//        }
        Log.i("ln","执行initdata");
        fragment_1 fragment_1= com.example.myapplication.fragment_1.newInstance();
        fragment_2 fragment_2= com.example.myapplication.fragment_2.newInstance();
        fragment_3 fragment_3= com.example.myapplication.fragment_3.newInstance();
        fragment_4 fragment_4= com.example.myapplication.fragment_4.newInstance();

        mcontents.add(fragment_1);
        mcontents.add(fragment_2);
        mcontents.add(fragment_3);
        mcontents.add(fragment_4);

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mcontents.get(position);
            }

            @Override
            public int getCount() {
                return mcontents.size();
            }
        };
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        //三角形总偏移量为tabWidth*positionOffset+position*tabWidth,positionOffset是偏移比例为0到1,
        //pstition为当前是第几块fragment
        mIndicator.scroll(position, positionOffset);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
