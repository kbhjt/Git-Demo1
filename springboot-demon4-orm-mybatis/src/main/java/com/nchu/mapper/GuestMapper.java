package com.nchu.mapper;

import com.nchu.bean.Guest;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestMapper {

    @Select("select id,name,role from guest")
    List<Guest> list();
}
