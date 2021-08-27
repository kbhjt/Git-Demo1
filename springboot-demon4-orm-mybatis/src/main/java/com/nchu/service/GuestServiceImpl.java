package com.nchu.service;

import com.nchu.bean.Guest;
import com.nchu.mapper.GuestMapper;
import com.nchu.mapper2.GuestMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService{

    @Autowired
    private GuestMapper guestMapper;
    @Autowired
    private GuestMapper2 guestMapper2;

    @Override
    public List<Guest> list() {
        return guestMapper2.list();
    }

}
