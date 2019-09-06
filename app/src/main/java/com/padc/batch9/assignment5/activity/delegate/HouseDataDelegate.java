package com.padc.batch9.assignment5.activity.delegate;

import com.padc.batch9.assignment5.activity.data.vo.HouseVo;

import java.util.List;

public interface HouseDataDelegate {

    List<HouseVo> sendHouseDataToFragments();
}
