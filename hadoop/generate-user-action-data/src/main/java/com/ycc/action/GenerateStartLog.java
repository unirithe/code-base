package com.ycc.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ycc.DataCenter;
import com.ycc.entity.eError;
import com.ycc.entity.eRun;
import com.ycc.entity.eUser;
import com.ycc.log.StartLog;
import com.ycc.utils.ErrorUtilsImpl;
import com.ycc.utils.ProxyUtils;
import com.ycc.utils.StartUtilsImpl;
import com.ycc.utils.UserUtilsImpl;
import com.ycc.utilsDao.ErrorUtilsDao;
import com.ycc.utilsDao.StartUtilsDao;
import com.ycc.utilsDao.UserUtilsDao;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Uni
 * @create 2021/11/14 19:59
 */
public class GenerateStartLog {
    static UserUtilsDao user = ProxyUtils.getProxy(new UserUtilsImpl());
    static StartUtilsDao start = ProxyUtils.getProxy(new StartUtilsImpl());
    static ErrorUtilsDao error = ProxyUtils.getProxy(new ErrorUtilsImpl());

    public static void start() {
        // 生成数据
        generate();
        // 输出
        print();
    }
    // 产生数据并存到 DataCenter
    public static void generate(){

        List<eUser> list1 = user.getMore(DataCenter.OPTION_NUMBER);
        List<eRun> list2 = start.getMore(DataCenter.OPTION_NUMBER);
        List<eError> list3 = error.getMore(DataCenter.OPTION_NUMBER);
        List list = new ArrayList();
        for (int i = 0; i < list1.size(); i++) {
            StartLog startLog = new StartLog(list1.get(i), list2.get(i), list3.get(i), System.currentTimeMillis() + "");
            list.add(startLog);
        }
        DataCenter.JSON_LOG.put(DataCenter.START, new JSONArray(list));
    }
    // 保存结果
    public static void save(String info){
        try {
            Writer w = new FileWriter(new File(DataCenter.OPTION_LOCATION), true);
            w.write(info);
            w.flush();
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void print(){
        String res = DataCenter.JSON_LOG.getJSONArray(DataCenter.START).toString();
        switch (DataCenter.OPTION_PRINT_WAY) {
            case 2: // 格式化输出
                res = DataCenter.formatJSON(DataCenter.JSON_LOG.getJSONArray(DataCenter.START));
                System.out.println(res);
                break;
            case 1: // 直接输出
                System.out.println(res);
                break;
            default: break;// 不输出
        }
    }
}
