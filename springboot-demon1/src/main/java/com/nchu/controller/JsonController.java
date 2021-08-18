package com.nchu.controller;

import com.nchu.bean.Vegetables;
import com.nchu.config.VegetablesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController
 * @RestController是@Controller和@ResponseBody的组合
 * 返回的是json格式的字符串 而不是jsp等视图界面
 */
@RestController
public class JsonController {

    @Value("${info.username}")
    private String username;
    @Value("${info.password}")
    private String password;

    @RequestMapping("/json")
    public String json(){
        return "hello json";
    }

    @Autowired
    private VegetablesConfig vegetablesConfig;

    @RequestMapping("/vegetables")
    public Vegetables vegetables(){
        Vegetables vegetables = new Vegetables();
        vegetables.setPotato(vegetablesConfig.getPotato());
        vegetables.setEggplant(vegetablesConfig.getEggplant());
        vegetables.setGreenpeper(vegetablesConfig.getGreenpeper());
        return vegetables;
    }

    @RequestMapping("/encryptor")
    private String encryptor(){
        StringBuffer buffer = new StringBuffer(username);
        buffer.append(password);
        return buffer.toString();
    }

}
