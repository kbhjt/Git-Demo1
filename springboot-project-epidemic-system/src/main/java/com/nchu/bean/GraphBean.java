package com.nchu.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("graph")
public class GraphBean implements Serializable {

    private static final long serialVersionUID = -4087377119883675350L;

    private long id;
    private String date;
    private int confirm;
    private int suspect;
}
