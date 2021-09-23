package com.nchu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapBean {

    //注意在echarts展示时
    //      这个属性名一定要为name
    private String name;
    private int value;
}
