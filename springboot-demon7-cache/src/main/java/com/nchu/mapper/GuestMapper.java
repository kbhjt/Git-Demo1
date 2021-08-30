package com.nchu.mapper;

import com.nchu.bean.Guest;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository@Mapper
public interface GuestMapper {

    @Select("select id,name,role from guest")
    List<Guest> list();

    @Select("select id,name,role from guest where id = #{id}")
    Guest guestById(int id);

    @Update("update guest set name=#{name},role=#{role} where id=#{id}")
    int update(Guest guest);

    @Delete("delete from guest where id=#{id}")
    int delete(int id);

    @Delete("delete from guest")
    int deleteAll();
}
