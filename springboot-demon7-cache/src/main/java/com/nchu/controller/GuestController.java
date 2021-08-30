package com.nchu.controller;

import com.nchu.bean.Guest;
import com.nchu.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping
    public List<Guest> list(Model model){
        List<Guest> guestList = guestService.list();
        model.addAttribute("guestList",guestList);
        return guestList;
    }

    @GetMapping("/{id}")
    public Guest guestById(@PathVariable(name = "id") int id){
        return guestService.guestById(id);
    }

    @GetMapping("/update")
    public Guest update(Integer id, String name, String role){
        Guest newGuest = new Guest(id,name,role);
        guestService.update(newGuest);
        return newGuest;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        if(id != 0){
            guestService.delete(id);
        }else{
            guestService.deleteAll();
        }
        return "Success";
    }
}
