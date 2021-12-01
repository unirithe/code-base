package com.ycc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ycc.log.PageLog;
import com.ycc.log.StartLog;
import com.ycc.utils.*;
import com.ycc.utilsDao.*;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Uni
 * @create 2021/11/14 14:30
 */
public class DataCenter {
    public static ArrayList<PageLog> list_page = new ArrayList<>();
    public static ArrayList<StartLog> list_start = new ArrayList<>();
    public final static JSONObject JSON_LOG = new JSONObject();
    public final static String USER = "userLog";
    public final  static String START = "startLog";
    static UserUtilsDao user = ProxyUtils.getProxy(new UserUtilsImpl());
    static ActionUtilsDao action = ProxyUtils.getProxy(new ActionUtilsImpl());
    static DisplayUtilsDao display = ProxyUtils.getProxy(new DisplayUtilsImpl());
    static PageUtilsDao page = ProxyUtils.getProxy(new PageUtilsImpl());
    static ErrorUtilsDao error = ProxyUtils.getProxy(new ErrorUtilsImpl());


    public static int OPTION_RATE = 5000;   // 产生速度的延迟
    public static int OPTION_PRINT_WAY = 1; // 输出方式
    public static int OPTION_ISSAVE = 1;    // 是否保存数据
    public static int OPTION_NUMBER = 0;    // 数据量
    public static int OPTION_FILE_MAX_SIZE = 1024;    // 数据文件大小
    public static String OPTION_LOCATION;   // 结果文件保存位置
    static SAXReader saxReader = new SAXReader();
    static Document document = null;

    public static Random R = new Random();
    // 功能: 向数据中心 插入 一条日志信息
    public static <E>void add(E obj){
        // 判断待插入的对象是哪一个日志
        if (obj instanceof PageLog)
            list_page.add((PageLog) obj);
        else if (obj instanceof StartLog)
            list_start.add((StartLog) obj);
    }

    public static String formatJSON(JSONArray obj){
        return JSON.toJSONString(obj, SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);
    }
    // 获取枚举的任意值
    public static <T extends Enum<T>> String getRandomEnumsName(Class <T> e){
        T[] enumConstants = e.getEnumConstants();
        return enumConstants[R.nextInt(enumConstants.length)].name();
    }
    // 读取 XML 配置文件
    public static void readConfig(){
        try {
            InputStream is = new FileInputStream("config.xml");
            document = saxReader.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        OPTION_PRINT_WAY = Integer.parseInt(((Element) document.selectSingleNode("//option[@id='print_way']")).getText());
        OPTION_ISSAVE = Integer.parseInt(((Element) document.selectSingleNode("//option[@id='save']")).getText());
        OPTION_NUMBER = Integer.parseInt(((Element) document.selectSingleNode("//option[@id='number']")).getText());
        OPTION_RATE = Integer.parseInt(((Element) document.selectSingleNode("//option[@id='rate']")).getText());
        OPTION_FILE_MAX_SIZE = Integer.parseInt(((Element) document.selectSingleNode("//option[@id='max_file_size']")).getText());
        OPTION_LOCATION = document.selectSingleNode("//option[@id='location']").getText();
    }
    public static void saveLog(){
        if(OPTION_ISSAVE == 0) return ;
        try {
            if (readLogSize() >= OPTION_FILE_MAX_SIZE) cleanLog();
            Writer w = new FileWriter(new File(DataCenter.OPTION_LOCATION));
            w.write(JSON_LOG.toString());
            w.flush();
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void cleanLog(){
        try {
            Writer w = new FileWriter(new File(DataCenter.OPTION_LOCATION));
            w.write("");
            w.flush();
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static long readLogSize(){
        try {
            File file = new File(DataCenter.OPTION_LOCATION);
            return file.length() / 1024;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
