package com.nchu.mapper;

import java.util.ArrayList;
import java.util.List;
import com.nchu.bean.Guest;
import org.springframework.stereotype.Repository;

@Repository
public class GuestDao {

    static List<Guest> guestList = new ArrayList<>();
    static {
        guestList.add(new Guest("黄晓明","店长"));
        guestList.add(new Guest("杨紫","小妹"));
        guestList.add(new Guest("秦海璐","财务"));
        guestList.add(new Guest("王俊凯","经理"));
        guestList.add(new Guest("林书炜","总厨"));
    }

    public List<Guest> list(){
        return guestList;
    }

    public void add(Guest guest){
        guestList.add(guest);
    }

    public Guest get(String name){
        for (Guest guest:guestList){
            if(guest.getName().equals(name)){
                return guest;
            }
        }
        return new Guest("","");
    }

    public void update(Guest guest){
        Guest oldGuest = get(guest.getName());
        oldGuest.setRole(guest.getRole());
    }

    public void delete(String name){
        Guest guest = get(name);
        guestList.remove(guest);
    }
}
