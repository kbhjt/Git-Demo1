package com.nchu.controller;

import com.google.gson.Gson;
import com.nchu.bean.DataBean;
import com.nchu.bean.GraphBean;
import com.nchu.bean.MapBean;
import com.nchu.handler.GraphHandler;
import com.nchu.service.DataService;
import com.nchu.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DataController {

    @Autowired
    private DataService dataService;

    @Autowired
    private GraphService graphService;

    @GetMapping("/")
    public String getData(Model model){
        List<DataBean> dataList = dataService.list();
        model.addAttribute("list",dataList);
        return "list";
    }

    @GetMapping("/graph")
    public String graph(Model model){
        List<GraphBean> graphList = graphService.list();

        ArrayList<String> dateList = new ArrayList<>();
        ArrayList<Integer> confirmList = new ArrayList<>();
        ArrayList<Integer> suspectList = new ArrayList<>();

        for(int i=0; i < graphList.size(); i++){
            GraphBean graphBean = graphList.get(i);
            dateList.add(graphBean.getDate());
            confirmList.add(graphBean.getConfirm());
            suspectList.add(graphBean.getSuspect());
        }
        model.addAttribute("dateList",dateList);
        model.addAttribute("confirmList",confirmList);
        model.addAttribute("suspectList",suspectList);

        return "graph";
    }

    @GetMapping("/map")
    public String map(Model model){
        List<DataBean> dataBeanList = dataService.list();

        List<MapBean> result1 = new ArrayList<>();
        List<MapBean> result2 = new ArrayList<>();

        for (DataBean dataBean : dataBeanList) {
            MapBean map1 = new MapBean(dataBean.getArea(),dataBean.getNowConfirm());
            MapBean map2 = new MapBean(dataBean.getArea(),dataBean.getConfirm());
            result1.add(map1);
            result2.add(map2);
        }
        model.addAttribute("mapData1",new Gson().toJson(result1));
        model.addAttribute("mapData2",new Gson().toJson(result2));

        return "map";
    }
}
