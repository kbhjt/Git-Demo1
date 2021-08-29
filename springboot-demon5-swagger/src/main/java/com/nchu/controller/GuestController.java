package com.nchu.controller;

import com.nchu.bean.Guest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;


/**
 * @RequestMapping("/guest")
 * 代表这个类的所有请求的url地址都是以/geust开头的
 */
@RestController
@RequestMapping("/guest")
@Api(tags = "嘉宾相关的接口", description = "嘉宾增删改查接口")
public class GuestController {

    @GetMapping
    @ApiOperation("嘉宾查询列表")
    public String list(Model model){
        return "list";
    }

    @GetMapping("/toAdd")
    @ApiIgnore
    public String toAdd(){
        return "add";
    }

    @PostMapping
    @ApiOperation("添加嘉宾")
    public String add(Guest guest){
        return "add guest";
    }

    @GetMapping("/toUpdate/{name}")
    @ApiIgnore
    public String toUpdate(Model model, @PathVariable("name") String name){
        return "update";
    }

    @PutMapping
    @ApiOperation("更新嘉宾")
    public String update(Guest guest){
        return "update guest";
    }

    @DeleteMapping("/{name}")
    @ApiOperation("删除嘉宾")
    @ApiImplicitParam(name = "name", value = "姓名")
    public String delete(@PathVariable("name") String name){
        return "delete guest";
    }
}
