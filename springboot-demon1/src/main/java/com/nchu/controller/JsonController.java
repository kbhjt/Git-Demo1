package com.nchu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController
 * @RestController是@Controller和@ResponseBody的组合
 * 返回的是json格式的字符串 而不是jsp等视图界面
 */
@RestController
public class JsonController {
    
    @RequestMapping("/json")
    public String json(){
        return "hello json";
    }
}
