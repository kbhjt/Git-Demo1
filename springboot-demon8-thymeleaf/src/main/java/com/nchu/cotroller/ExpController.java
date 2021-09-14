package com.nchu.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class ExpController {

    @GetMapping("/inner")
    public String inner(Model model){
        model.addAttribute("date",new Date());
        model.addAttribute("str","nchu");
        model.addAttribute("info","中国");
        return "exp";
    }
}
