package com.ycc.utilsDao;

import com.ycc.entity.eDisplay;

import java.util.List;
import java.util.Random;

/**
 * @author Uni
 * @create 2021/11/15 0:19
 */
public interface DisplayUtilsDao extends getDao<List<eDisplay>>{
    Random R = new Random();
    String[] ITEM_TYPE = new String[] {"sku_id", "activity_id"};
    int DISPLAY_MAX = 5;        // 每次曝光的最大值

    String displayType();       // 曝光类型
    String item(); // 曝光对象ID
    String item_type();   //曝光对象类型
    int order();     // 出现顺序
    String pos_id();    // 曝光位置
}
