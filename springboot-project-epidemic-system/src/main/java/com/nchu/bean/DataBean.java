package com.nchu.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("epidemic")
public class DataBean implements Serializable {

    //可序列化ID
    private static final long serialVersionUID = 3016094558379364173L;

    private long id;
    private String area;
    private int nowConfirm;
    private int confirm;
    private int heal;
    private int dead;
}
