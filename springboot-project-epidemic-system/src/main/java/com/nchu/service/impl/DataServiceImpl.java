package com.nchu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nchu.bean.DataBean;
import com.nchu.handler.DataHandler;
import com.nchu.mapper.DataMapper;
import com.nchu.service.DataService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DataServiceImpl
        extends ServiceImpl<DataMapper,DataBean>
        implements DataService {
//    @Override
//    public List<DataBean> list() {
//        return DataHandler.getData();
//    }
}
