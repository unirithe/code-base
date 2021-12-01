package com.ycc.utilsDao;

import com.ycc.entity.eRun;

import java.util.Random;

/**
 * @author Uni
 * @create 2021/11/14 16:16
 */
public interface StartUtilsDao extends getDao<eRun>{
    public static Random R = new Random();
    public static String[] ENTRY_TYPE = new String[] {"icon", "notice", "install"};
    public static int ENTRY_TYPE_NUM = ENTRY_TYPE.length;
    public static int AD_ID_MAX = 10;  // 广告页ID的最大值
    public static int LOADING_MAX = 5000; // 启动加载时间的最大值，单位毫秒
    public static int AD_MS_MAX = 5000;     // 广告播放时间的最大值，单位毫秒

    public String entry();  // 获得入口
    public String loading_time();   // 获取随机启动加载时间
    public String open_ad_id();     // 获取广告页ID
    public String[] open_ad_ms();     // 广告播放时间和用户跳过广告的耗时，单位：毫秒

}
