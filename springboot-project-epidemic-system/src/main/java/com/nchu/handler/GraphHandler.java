package com.nchu.handler;

import com.google.gson.Gson;
import com.nchu.bean.GraphBean;
import com.nchu.util.HttpURLConnectionUtil;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class GraphHandler {

    private static String strUrl = "https://api.inews.qq.com/newsqa/v1/query/inner/publish/modules/list?modules=chinaDayAddList";

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
            GraphBean graphBean = new GraphBean(date, (int) confirm, (int) suspect);
            graphList.add(graphBean);
        }
        return graphList;
    }

}
