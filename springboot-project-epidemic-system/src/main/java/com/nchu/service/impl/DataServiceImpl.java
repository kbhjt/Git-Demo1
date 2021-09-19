package com.nchu.service.impl;

import com.nchu.bean.DataBean;
import com.nchu.handler.DataHandler;
import com.nchu.service.DataService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {
    @Override
    public List<DataBean> list() {
        return DataHandler.getData();
    }
}
