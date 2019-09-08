package com.padc.batch9.assignment5.activity.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.padc.batch9.assignment5.R;
import com.padc.batch9.assignment5.activity.HouseDetailActivity;
import com.padc.batch9.assignment5.activity.adapter.HouseAdapter;
import com.padc.batch9.assignment5.activity.data.vo.HouseVo;
import com.padc.batch9.assignment5.activity.delegate.HouseDataDelegate;
import com.padc.batch9.assignment5.activity.delegate.HouseItemDelegate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OurChoiceFragment extends Fragment implements HouseItemDelegate, View.OnClickListener, TextWatcher {

    public OurChoiceFragment() {
    }

    private String tag = getClass().getSimpleName();

    LinearLayoutManager manager;
    GridLayoutManager gridLayoutManager;
    HouseDataDelegate delegate;
    List<HouseVo> list;
    HouseAdapter houseAdapter;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.imgv_horizontal_display)
    AppCompatImageView imgvHorizontalDisplay;
    @BindView(R.id.imgv_vertical_display)
    AppCompatImageView imgvVerticalDisplay;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_our_choice, container, false);
        ButterKnife.bind(this, view);

        manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,
                false);
        gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(manager);
        houseAdapter = new HouseAdapter(this);
        recyclerView.setAdapter(houseAdapter);
        houseAdapter.setViewData(list);
        imgvHorizontalDisplay.setOnClickListener(this);
        imgvVerticalDisplay.setOnClickListener(this);
        etSearch.addTextChangedListener(this);
        return view;
    }

    @Override
    public void onTapHouseItemEvent(int id) {
        Intent intent = HouseDetailActivity.newIntent(getActivity(), id);
        startActivity(intent);

    }

    @Override
    public void onFabGetDirectionClickEvent(int id) {
        HouseVo houseVo = list.get(id);
        String uri = "http://maps.google.com/maps?f=d&hl=en&saddr="+16.783070+","+96.174117+"&daddr="+houseVo.getLatitude()+","+houseVo.getLongitude();
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(Intent.createChooser(intent, "Select an application"));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            delegate = (HouseDataDelegate) context;
            list = delegate.sendHouseDataToFragments();
            Log.i(tag, "list==="+list.size());
        }
        catch (ClassCastException e) {
            e.printStackTrace();
        }

    }

    private void showVerticalView() {
        recyclerView.setLayoutManager(gridLayoutManager);
        houseAdapter.notifyDataSetChanged();
    }

    private void showHorizontalView() {
        recyclerView.setLayoutManager(manager);
        houseAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgv_horizontal_display:
                showHorizontalView();
                break;
            case R.id.imgv_vertical_display:
                showVerticalView();
                break;
        }
    }

    private void filter(String text) {
        //new array list that will hold the filtered data
        List<HouseVo> filterdNames = new ArrayList<>();

        //looping through existing elements
        for (HouseVo vo : list) {
            //if the existing elements contains the search input
            if (vo.getName().toLowerCase().contains(text.toLowerCase())) {
                //adding the element to filtered list
                filterdNames.add(vo);
            }
        }

        //calling a method of the adapter class and passing the filtered list
        houseAdapter.setViewData(filterdNames);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        filter(s.toString());
    }
}
