package com.padc.batch9.assignment5.activity;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.padc.batch9.assignment5.R;
import com.padc.batch9.assignment5.activity.adapter.MyViewPagerAdapter;
import com.padc.batch9.assignment5.activity.data.vo.HouseVo;
import com.padc.batch9.assignment5.activity.data.vo.model.HouseModel;
import com.padc.batch9.assignment5.activity.data.vo.model.HouseModelImpl;
import com.padc.batch9.assignment5.activity.delegate.HouseDataDelegate;
import com.padc.batch9.assignment5.activity.fragment.DiscoverFragment;
import com.padc.batch9.assignment5.activity.fragment.FavouriteFragment;
import com.padc.batch9.assignment5.activity.fragment.ForYouFragment;
import com.padc.batch9.assignment5.activity.fragment.MoreFragment;
import com.padc.batch9.assignment5.activity.fragment.NearMeFragment;
import com.padc.batch9.assignment5.activity.fragment.ProfileFragment;
import com.padc.batch9.assignment5.activity.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class HouseRentingActivity extends BaseActivity implements
        TabLayout.BaseOnTabSelectedListener, HouseDataDelegate {
    private String tag = getClass().getSimpleName();
    TabLayout tabLayout;
    ViewPager viewPager;
    MyViewPagerAdapter adapter;
    List<HouseVo> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_renting);
        initializeUiComponent();
        Utils.setStatusBarColor(this, R.color.statusBarColor);


        houseModel.getHouse(new HouseModel.GetHouseModelFromDataLayer() {
            @Override
            public void onSuccess(List<HouseVo> houses) {

                list = new ArrayList<>(houses);
                Log.i(tag, "house="+houses.size());
                sendHouseDataToFragments();
                setupViewPager(viewPager);
                tabLayout.setupWithViewPager(viewPager);
                setupTabIcons();
                selectFirstTab();
                tabLayout.addOnTabSelectedListener(HouseRentingActivity.this);
            }

            @Override
            public void onFailure(String errorMessage) {
                showIdefiniteSnakBar(errorMessage);
            }
        });

    }

    private void initializeUiComponent() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);
        viewPager.setSaveFromParentEnabled(false);
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ForYouFragment(), getResources().getString(R.string.title_for_you));
        adapter.addFragment(new NearMeFragment(), getResources().getString(R.string.title_near_me));
        adapter.addFragment(new FavouriteFragment(), getResources().getString(R.string.title_favourite));
        adapter.addFragment(new DiscoverFragment(), getResources().getString(R.string.title_discover));
        adapter.addFragment(new ProfileFragment(), getResources().getString(R.string.title_profile));
        adapter.addFragment(new MoreFragment(), getResources().getString(R.string.title_more));
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);
    }

    private void setupTabIcons() {
        View view1 = LayoutInflater.from(this).inflate(R.layout.tab_home, null);
        AppCompatImageView imgv1 =  view1.findViewById(R.id.imgv_tab);
        AppCompatTextView tv1 =  view1.findViewById(R.id.tv_tab);
        tv1.setText(getResources().getString(R.string.title_for_you));
        tv1.setTextColor(ContextCompat.getColor(this, R.color.textColorMain));
        imgv1.setImageResource(R.drawable.ic_for_you);

        View view2 = LayoutInflater.from(this).inflate(R.layout.tab_home, null);
        AppCompatImageView imgv2 =  view2.findViewById(R.id.imgv_tab);
        AppCompatTextView tv2 =  view2.findViewById(R.id.tv_tab);
        tv2.setText(getResources().getString(R.string.title_near_me));
        tv2.setTextColor(ContextCompat.getColor(this, R.color.textColorMain));
        imgv2.setImageResource(R.drawable.ic_near_me);

        View view3 = LayoutInflater.from(this).inflate(R.layout.tab_home, null);
        AppCompatImageView imgv3 =  view3.findViewById(R.id.imgv_tab);
        AppCompatTextView tv3 =  view3.findViewById(R.id.tv_tab);
        tv3.setText(getResources().getString(R.string.title_favourite));
        tv3.setTextColor(ContextCompat.getColor(this, R.color.textColorMain));
        imgv3.setImageResource(R.drawable.ic_favourite);

        View view4 = LayoutInflater.from(this).inflate(R.layout.tab_home, null);
        AppCompatImageView imgv4 =  view4.findViewById(R.id.imgv_tab);
        AppCompatTextView tv4 =  view4.findViewById(R.id.tv_tab);
        tv4.setText(getResources().getString(R.string.title_discover));
        tv4.setTextColor(ContextCompat.getColor(this, R.color.textColorMain));
        imgv4.setImageResource(R.drawable.ic_discover);

        View view5 = LayoutInflater.from(this).inflate(R.layout.tab_home, null);
        AppCompatImageView imgv5 =  view5.findViewById(R.id.imgv_tab);
        AppCompatTextView tv5 =  view5.findViewById(R.id.tv_tab);
        tv5.setText(getResources().getString(R.string.title_profile));
        tv5.setTextColor(ContextCompat.getColor(this, R.color.textColorMain));
        imgv5.setImageResource(R.drawable.ic_profile);

        View view6 = LayoutInflater.from(this).inflate(R.layout.tab_home, null);
        AppCompatImageView imgv6 =  view6.findViewById(R.id.imgv_tab);
        AppCompatTextView tv6 =  view6.findViewById(R.id.tv_tab);
        tv6.setText(getResources().getString(R.string.title_more));
        tv6.setTextColor(ContextCompat.getColor(this, R.color.textColorMain));
        imgv6.setImageResource(R.drawable.ic_more);

        tabLayout.getTabAt(0).setCustomView(view1);
        tabLayout.getTabAt(1).setCustomView(view2);
        tabLayout.getTabAt(2).setCustomView(view3);
        tabLayout.getTabAt(3).setCustomView(view4);
        tabLayout.getTabAt(4).setCustomView(view5);
        tabLayout.getTabAt(5).setCustomView(view6);
    }

    private void selectTab(TabLayout.Tab tab) {
        Log.i(tag, "selectTab="+tab.getPosition());
        View view = tab.getCustomView();
        AppCompatTextView tv  = view.findViewById(R.id.tv_tab);
        AppCompatImageView imgeView = view.findViewById(R.id.imgv_tab);
        String text = null;
        switch (tab.getPosition()) {
            case 0:
                text = getResources().getString(R.string.title_for_you);
                break;
            case 1:
                text = getResources().getString(R.string.title_near_me);
                break;
            case 2:
                text = getResources().getString(R.string.title_favourite);
                break;
            case 3:
                text = getResources().getString(R.string.title_discover);
                break;
            case 4:
                text = getResources().getString(R.string.title_profile);
                break;
            case 5:
                text = getResources().getString(R.string.title_more);
                break;
        }
        tv.setText(text);
        int tabIconColor = ContextCompat.getColor(this, R.color.colorPrimary);
        imgeView.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
        tv.setTextColor(tabIconColor);
    }

    private void unselectTab(TabLayout.Tab tab) {
        Log.i(tag, "selectTab="+tab.getPosition());
        View view = tab.getCustomView();
        AppCompatTextView tv  = view.findViewById(R.id.tv_tab);
        AppCompatImageView imgeView = view.findViewById(R.id.imgv_tab);
        String text = null;
        switch (tab.getPosition()) {
            case 0:
                text = getResources().getString(R.string.title_for_you);
                break;
            case 1:
                text = getResources().getString(R.string.title_near_me);
                break;
            case 2:
                text = getResources().getString(R.string.title_favourite);
                break;
            case 3:
                text = getResources().getString(R.string.title_discover);
                break;
            case 4:
                text = getResources().getString(R.string.title_profile);
                break;
            case 5:
                text = getResources().getString(R.string.title_more);
                break;
        }
        tv.setText(text);
        int tabIconColor = ContextCompat.getColor(this, R.color.textColorMain);
        imgeView.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
        tv.setTextColor(tabIconColor);
    }

    /**
     * This method is for selecting the first tab/page in case sometimes viewpager is not selecting the first page.
     */
    private void selectFirstTab() {
        viewPager.setCurrentItem(0);
        tabLayout.getTabAt(0).select();
        View view = tabLayout.getTabAt(0).getCustomView();
        AppCompatImageView imgvTab = view.findViewById(R.id.imgv_tab);
        AppCompatTextView tvTab =  view.findViewById(R.id.tv_tab);
        int tabIconColor = ContextCompat.getColor(this, R.color.colorPrimary);
        tvTab.setText(getResources().getString(R.string.title_for_you));
        tvTab.setTextColor(tabIconColor);
        imgvTab.setImageResource(R.drawable.ic_for_you);
        imgvTab.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);

    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        selectTab(tab);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        unselectTab(tab);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public List<HouseVo> sendHouseDataToFragments() {
        return list;
    }
}
