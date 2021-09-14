package com.nchu.cotroller;

import com.nchu.bean.Person;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @RequestMapping("/welcome")
    public String welcome(Model model){
        Person person = new Person("kobe",24);
        model.addAttribute("person",person);
        model.addAttribute("msg","yes");
        model.addAttribute("num",1);

        Person person1 = new Person("zhangsan",18);
        Person person2 = new Person("lisi",99);

        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person1);
        personList.add(person2);
        model.addAttribute("personList",personList);
        return "welcome";
    }
}
