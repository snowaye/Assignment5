package com.padc.batch9.assignment5.activity.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.batch9.assignment5.R;
import com.padc.batch9.assignment5.activity.adapter.HouseAdapter;
import com.padc.batch9.assignment5.activity.adapter.MyViewPagerAdapter;

public class ForYouFragment extends Fragment {

    public ForYouFragment() {
    }

    TabLayout tabLayout;
    ViewPager viewPager;
    MyViewPagerAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_for_you, container, false);
        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewpager);
        viewPager.setSaveFromParentEnabled(false);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        //setupTabIcons();
        selectFirstTab();
        //tabLayout.addOnTabSelectedListener(this);
        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new MyViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new TopCollectionFragment(), getResources().getString(R.string.title_top_collection));
        adapter.addFragment(new ForNearMeFragment(), getResources().getString(R.string.title_near_you));
        adapter.addFragment(new LowToHighFragment(), getResources().getString(R.string.title_low_to_high));
        adapter.addFragment(new OurChoiceFragment(), getResources().getString(R.string.title_our_choice));
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);
    }

    private void setupTabIcons() {
        View viewTopCollection = LayoutInflater.from(getContext()).inflate(R.layout.tab_custom, null);
        viewTopCollection.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        AppCompatImageView imgvTopCollection =  viewTopCollection.findViewById(R.id.imgv_tab);
        AppCompatTextView tvTopCollection =  viewTopCollection.findViewById(R.id.tv_tab);
        tvTopCollection.setText(getResources().getString(R.string.title_top_collection));
        imgvTopCollection.setImageResource(R.drawable.ic_dot);
        imgvTopCollection.setVisibility(View.VISIBLE);

        View viewNearYou = LayoutInflater.from(getContext()).inflate(R.layout.tab_custom, null);
        viewNearYou.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        AppCompatImageView imgvNearYou =  viewNearYou.findViewById(R.id.imgv_tab);
        AppCompatTextView tvNearYou =  viewNearYou.findViewById(R.id.tv_tab);
        tvNearYou.setTextColor(ContextCompat.getColor(getContext(), R.color.textColorMainLight));
        tvNearYou.setText(getResources().getString(R.string.title_near_you));
        imgvNearYou.setVisibility(View.INVISIBLE);

        View viewLowToHight = LayoutInflater.from(getContext()).inflate(R.layout.tab_custom, null);
        viewLowToHight.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        AppCompatImageView imgvLowToHigh = viewLowToHight.findViewById(R.id.imgv_tab);
        AppCompatTextView tvLowToHigh =  viewLowToHight.findViewById(R.id.tv_tab);
        tvLowToHigh.setText(getResources().getString(R.string.title_low_to_high));
        tvLowToHigh.setTextColor(ContextCompat.getColor(getContext(), R.color.textColorMainLight));
        imgvLowToHigh.setVisibility(View.INVISIBLE);

        View viewOurChoice = LayoutInflater.from(getContext()).inflate(R.layout.tab_custom, null);
        viewOurChoice.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        AppCompatImageView imgvOurChoice = viewOurChoice.findViewById(R.id.imgv_tab);
        AppCompatTextView tvOurChoice =  viewOurChoice.findViewById(R.id.tv_tab);
        tvOurChoice.setText(getResources().getString(R.string.title_our_choice));
        tvOurChoice.setTextColor(ContextCompat.getColor(getContext(), R.color.textColorMainLight));
        imgvOurChoice.setVisibility(View.INVISIBLE);

        tabLayout.getTabAt(0).setCustomView(viewTopCollection);
        tabLayout.getTabAt(1).setCustomView(viewNearYou);
        tabLayout.getTabAt(2).setCustomView(viewLowToHight);
        tabLayout.getTabAt(3).setCustomView(viewOurChoice);
    }

    private void selectTab(TabLayout.Tab tab) {

        View view = tab.getCustomView();
        AppCompatTextView tv  = view.findViewById(R.id.tv_tab);
        AppCompatImageView imgeView = view.findViewById(R.id.imgv_tab);
        String text = null;
        switch (tab.getPosition()) {
            case 0:
                text = getResources().getString(R.string.title_top_collection);
                break;
            case 1:
                text = getResources().getString(R.string.title_near_you);
                break;
            case 2:
                text = getResources().getString(R.string.title_low_to_high);
                break;
            case 3:
                text = getResources().getString(R.string.title_our_choice);
                break;
        }
        tv.setText(text);
        tv.setTextColor(ContextCompat.getColor(getContext(), R.color.textColorMain));
        imgeView.setVisibility(View.VISIBLE);
    }

    private void unselectTab(TabLayout.Tab tab) {
        View view = tab.getCustomView();
        AppCompatTextView tv  = view.findViewById(R.id.tv_tab);
        AppCompatImageView imgeView = view.findViewById(R.id.imgv_tab);
        String text = null;
        switch (tab.getPosition()) {
            case 0:
                text = getResources().getString(R.string.title_top_collection);
                break;
            case 1:
                text = getResources().getString(R.string.title_near_you);
                break;
            case 2:
                text = getResources().getString(R.string.title_low_to_high);
                break;
            case 3:
                text = getResources().getString(R.string.title_our_choice);
                break;
        }
        tv.setText(text);
        tv.setTextColor(ContextCompat.getColor(getContext(), R.color.textColorMainLight));
        imgeView.setVisibility(View.GONE);

    }

    /**
     * This method is for selecting the first tab/page in case sometimes viewpager is not selecting the first page.
     */
    private void selectFirstTab() {
        viewPager.setCurrentItem(0);
        tabLayout.getTabAt(0).select();
       // View view = tabLayout.getTabAt(0).getCustomView();
      //  AppCompatImageView imgvTab = view.findViewById(R.id.imgv_tab);
       // AppCompatTextView tvTab =  view.findViewById(R.id.tv_tab);
        //tvTab.setText(getResources().getString(R.string.title_top_collection));
//        imgvTab.setImageResource(R.drawable.ic_dot);
   //     imgvTab.setVisibility(View.VISIBLE);
    }

//    @Override
//    public void onTabSelected(TabLayout.Tab tab) {
//        selectTab(tab);
//    }
//
//    @Override
//    public void onTabUnselected(TabLayout.Tab tab) {
//        unselectTab(tab);
//    }
//
//    @Override
//    public void onTabReselected(TabLayout.Tab tab) {
//
//    }
}
