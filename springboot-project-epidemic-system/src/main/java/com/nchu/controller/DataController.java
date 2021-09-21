package com.nchu.controller;

import com.nchu.bean.DataBean;
import com.nchu.bean.GraphBean;
import com.nchu.handler.GraphHandler;
import com.nchu.service.DataService;
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

    @GetMapping("/")
    public String getData(Model model){
        List<DataBean> dataList = dataService.list();
        model.addAttribute("list",dataList);
        return "list";
    }

    @GetMapping("/graph")
    public String graph(Model model){
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
        model.addAttribute("dateList",dateList);
        model.addAttribute("confirmList",confirmList);
        model.addAttribute("suspectList",suspectList);

        return "graph";
    }
}
