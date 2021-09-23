package com.nchu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nchu.bean.GraphBean;
import com.nchu.mapper.GraphMapper;
import com.nchu.service.GraphService;
import org.springframework.stereotype.Service;

@Service
public class GraphServiceImpl
        extends ServiceImpl<GraphMapper, GraphBean>
        implements GraphService {
}
