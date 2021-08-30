package com.nchu.service;

import com.nchu.bean.Guest;
import com.nchu.mapper.GuestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService{

    @Autowired
    private GuestMapper guestMapper;
    @Override
    public List<Guest> list() {
        return guestMapper.list();
    }

    @Cacheable(value = "guests", key = "#id", condition = "#id>1" )
    @Override
    public Guest guestById(int id) {
        System.out.println("查询"+id);
        return guestMapper.guestById(id);
    }

}
