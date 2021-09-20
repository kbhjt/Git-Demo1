package com.nchu.handler;

import com.google.gson.Gson;
import com.nchu.bean.DataBean;
import com.nchu.service.DataService;
import com.nchu.util.HttpURLConnectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class DataHandler {

    private static String strUrl = "https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5";

    private static SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private DataService dataService;

    /**
     * 数据采集
     * @return
     */
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
            Map dataMap = (Map) areaList.get(0);
            ArrayList childrenList = (ArrayList) dataMap.get("children");

            for(int i=0; i < childrenList.size(); i++){
                Map tmp = (Map) childrenList.get(i);
                String area = (String) tmp.get("name");

                Map totalMap = (Map) tmp.get("total");
                double nowConfirm = (double) totalMap.get("nowConfirm");
                double confirm = (double) totalMap.get("confirm");
                double heal = (double) totalMap.get("heal");
                double dead = (double) totalMap.get("dead");

                DataBean dataBean = new DataBean(0L,area,(int)nowConfirm,
                        (int)confirm,(int)heal,(int) dead);
                result.add(dataBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }

    /**
     * 数据初始化
     *  在服务器加载Servlet时运行
     *  只运行一次
     */
    @PostConstruct
    public void saveData(){
        List<DataBean> dataBeans = getData();
        //先清空数据库原有数据
        dataService.remove(null);
        //批量新增数据
        dataService.saveBatch(dataBeans);
    }

    /**
     * 定时更新数据
     */
    @Scheduled(cron = "0 0 0/1 * * ? ")
    public void updateData(){
        System.out.println("更新数据啦");
        System.out.println("当前时间：" + format.format(new Date()));
        List<DataBean> dataBeans = getData();
        //先清空数据库原有数据
        dataService.remove(null);
        //批量新增数据
        dataService.saveBatch(dataBeans);
    }

}
