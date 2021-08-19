package com.nchu.service;

import java.util.List;
import com.nchu.bean.Guest;

public interface GuestService {

    List<Guest> list();

    void add(Guest guest);

    Guest getGuest(String name);

    void update(Guest guest);

    void delete(String name);
}
