package com.nchu.service;

import com.nchu.bean.Guest;

import java.util.List;

public interface GuestService {

    List<Guest> list();

    Guest guestById(int id);

    /**
     * 使用缓存时 通常会把方法的返回值放入缓存中储存
     * 此时的返回值是特殊的 不再是原来的void or int
     * @param guest
     * @return
     */
    Guest update(Guest guest);

    void delete(int id);

    void deleteAll();

}
