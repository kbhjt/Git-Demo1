package com.nchu.handler;

import com.google.gson.Gson;
import com.nchu.bean.DataBean;
import com.nchu.util.HttpURLConnectionUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsoupHandler {

    private static String urlStr = "https://ncov.dxy.cn/ncovh5/view/pneumonia";

    public static List<DataBean> getData(){
//        String data = HttpURLConnectionUtil.doGet(urlStr);

        List<DataBean> dataBeanList = new ArrayList<>();
        try {
            // 利用jsoup解析html数据
            Document doc = Jsoup.connect(urlStr).get();
            Element scripts = doc.getElementById("getAreaStat");
            String data = scripts.data();
            String subData = data.substring(data.indexOf("["),data.lastIndexOf("]")+1);
            // 利用gson解析json数据
            Gson gson = new Gson();
            ArrayList list = gson.fromJson(subData,ArrayList.class);
            System.out.println();
            for (int i = 0; i < list.size(); i++) {
                Map map = (Map) list.get(i);
                String area = (String) map.get("provinceShortName");
                double nowConfirm = (double) map.get("currentConfirmedCount");
                double confirm = (double) map.get("confirmedCount");
                double heal = (double) map.get("curedCount");
                double dead = (double) map.get("deadCount");
                DataBean dataBean = new DataBean(0L,area,(int) nowConfirm
                        ,(int) confirm, (int) heal, (int) dead);
                dataBeanList.add(dataBean);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataBeanList;
    }

    public static void main(String[] args) {
        getData();
    }
}
