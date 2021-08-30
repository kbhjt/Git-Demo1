package com.nchu.service;

import com.nchu.bean.Guest;
import com.nchu.mapper.GuestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "guests")
public class GuestServiceImpl implements GuestService{

    @Autowired
    private GuestMapper guestMapper;
    @Override
    public List<Guest> list() {
        return guestMapper.list();
    }

    @Cacheable(/*cacheNames = "guests",*/ key = "#id", condition = "#id>1" )
    @Override
    public Guest guestById(int id) {
        System.out.println("查询"+id);
        return guestMapper.guestById(id);
    }

    /**
     * 设置key的值和cacheale保持一致
     * 方式一  拿到参数的id —— key = "#guest.id"
     * 方式二  拿到结果的id —— key = "#result.id"
     *
     * @param
     *
     * @return
     */
    @CachePut(/*cacheNames = "guests",*/ key = "#guest.id")
    @Override
    public Guest update(Guest guest) {
        System.out.println("更新"+guest.getId());
        guestMapper.update(guest);
        return guest;
    }

    @CacheEvict(/*cacheNames = "guests",*/ key = "#id")
    @Override
    public void delete(int id) {
        System.out.println("删除"+id);
        guestMapper.delete(id);
    }

    /**
     * @CacheEvict 属性
     * allEntries  删除所有实例
     * beforeInvocation  在方法调用之前  执行清除缓存逻辑
     */
    @CacheEvict(/*cacheNames = "guest",*/ allEntries = true, beforeInvocation = true)
    @Override
    public void deleteAll() {
        System.out.println("删除所有嘉宾");
        guestMapper.deleteAll();

        int result = 1 / 0;
    }

}
