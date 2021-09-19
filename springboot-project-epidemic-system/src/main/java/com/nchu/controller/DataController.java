package com.nchu.controller;

import com.nchu.bean.DataBean;
import com.nchu.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
