package com.nchu.controller;

import com.google.gson.Gson;
import com.nchu.bean.GraphBean;
import com.nchu.handler.GraphHandler;
import com.nchu.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import java.util.ArrayList;

@RestController
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/redisSet")
    public String testSet(String key, String value){
        redisUtil.set(key, value);
        return "success";
    }

    @GetMapping("/redisGet")
    public String testGet(String key){
        Object obj = redisUtil.get(key);
        return new Gson().toJson(obj);
    }

    @GetMapping("/redisInit")
    public String redis(){
        List<GraphBean> graphList = GraphHandler.getGraphData();
        ArrayList<String> dateList = new ArrayList<>();
        ArrayList<Integer> confirmList = new ArrayList<>();
        ArrayList<Integer> suspectList = new ArrayList<>();
        for(int i=0; i < graphList.size(); i++){
            GraphBean graphBean = graphList.get(i);
            dateList.add(graphBean.getDate());
            confirmList.add(graphBean.getConfirm());
            suspectList.add(graphBean.getSuspect());
        }
        redisUtil.set("EACHARTS_DATELIST",new Gson().toJson(dateList));
        redisUtil.set("EACHARTS_CONFIRMLIST",new Gson().toJson(confirmList));
        redisUtil.set("EACHARTS_SUSPECTLIST",new Gson().toJson(suspectList));
        return "success";
    }
}
