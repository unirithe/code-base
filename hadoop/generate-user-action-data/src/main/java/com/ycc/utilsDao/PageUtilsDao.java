package com.ycc.utilsDao;

import com.ycc.entity.ePage;

import java.util.Random;

/**
 * @author Uni
 * @create 2021/11/15 8:50
 */
public interface PageUtilsDao extends getDao<ePage>{
    Random R = new Random();
    String during_time();     // 持续时间
    String item();           // 目标 id
    String item_type();         // 目标类型
    String last_page_id();      // 上页类型
    String page_id();           // 页面ID
    String sourceType();        // 来源类型
}
