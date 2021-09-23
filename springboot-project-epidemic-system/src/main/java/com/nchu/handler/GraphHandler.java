package com.nchu.handler;

import com.google.gson.Gson;
import com.nchu.bean.GraphBean;
import com.nchu.service.GraphService;
import com.nchu.util.HttpURLConnectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.List;

@Component
public class GraphHandler {

    private static String strUrl = "https://api.inews.qq.com/newsqa/v1/query/inner/publish/modules/list?modules=chinaDayAddList";

    private static SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private GraphService graphService;

    public static List<GraphBean> getGraphData(){

        List<GraphBean> graphList = new ArrayList<>();

        String str = HttpURLConnectionUtil.doGet(strUrl);
        Gson gson = new Gson();
        Map map = (Map) gson.fromJson(str, Map.class);
        Map dataMap = (Map) map.get("data");

        ArrayList dayAddList = (ArrayList) dataMap.get("chinaDayAddList");
        for(int i=0; i < dayAddList.size(); i++){

            Map tmp = (Map) dayAddList.get(i);
            String date = (String) tmp.get("date");
            double confirm = (double) tmp.get("confirm");
            double suspect = (double) tmp.get("suspect");
            GraphBean graphBean = new GraphBean(0L,date, (int) confirm, (int) suspect);
            graphList.add(graphBean);
        }
        return graphList;
    }

    @PostConstruct
    public void saveGraph(){
        List<GraphBean> graphList = getGraphData();
        //先清空数据库原有数据
        graphService.remove(null);
        //批量新增数据
        graphService.saveBatch(graphList);
    }

    @Scheduled(cron = "0 0 0/1 * * ? ")
    public void updateGraph(){
        System.out.println("更新数据啦");
        System.out.println("当前时间：" + format.format(new Date()));

        List<GraphBean> graphList = getGraphData();
        //先清空数据库原有数据
        graphService.remove(null);
        //批量新增数据
        graphService.saveBatch(graphList);
    }
}
