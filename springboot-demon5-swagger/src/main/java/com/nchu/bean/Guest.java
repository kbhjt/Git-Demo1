package com.nchu.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel("嘉宾")
public class Guest {

    @ApiModelProperty("名字")
    private String name;
    @ApiModelProperty("角色")
    private String role;

}
