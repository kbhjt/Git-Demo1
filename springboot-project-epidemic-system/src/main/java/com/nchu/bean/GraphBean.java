package com.nchu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GraphBean {

    private String date;
    private int confirm;
    private int suspect;
}
