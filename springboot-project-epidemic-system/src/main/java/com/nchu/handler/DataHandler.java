package com.nchu.handler;

import com.google.gson.Gson;
import com.nchu.bean.DataBean;
import com.nchu.util.HttpURLConnectionUtil;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataHandler {

    private static String strUrl = "https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5";

    public static void main(String[] args) {
        getData();
    }

    public static List<DataBean> getData(){
        ArrayList<DataBean> result = new ArrayList<>();
        try {
//            FileReader reader = new FileReader("tmp.txt");
//            char[] cBuf = new char[1024];
//            int cRead = 0;
//            StringBuilder builder = new StringBuilder();
//            while ((cRead = reader.read(cBuf)) > 0){
//                builder.append(new String(cBuf,0,cRead));
//            }
//            reader.close();
//            System.out.println(builder.toString());


            String dataStr = HttpURLConnectionUtil.doGet(strUrl);
            //再通过gson解析数据
            Gson gson = new Gson();
            Map strMap = gson.fromJson(dataStr, Map.class);
            //获取data数据
            String subStr = (String) strMap.get("data");
            //data数据map
            Map map = gson.fromJson(subStr,Map.class);
            ArrayList areaList = (ArrayList) map.get("areaTree");
//            System.out.println(areaList);
            Map dataMap = (Map) areaList.get(0);
            ArrayList childrenList = (ArrayList) dataMap.get("children");
            System.out.println(childrenList);
            for(int i=0; i < childrenList.size(); i++){
                Map tmp = (Map) childrenList.get(i);
                String area = (String) tmp.get("name");

                Map totalMap = (Map) tmp.get("total");
                double nowConfirm = (double) totalMap.get("nowConfirm");
                double confirm = (double) totalMap.get("confirm");
                double dead = (double) totalMap.get("dead");
                double heal = (double) totalMap.get("heal");

                DataBean dataBean = new DataBean(area,(int)nowConfirm,
                        (int)confirm,(int)dead,(int) heal);
                result.add(dataBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }
}
