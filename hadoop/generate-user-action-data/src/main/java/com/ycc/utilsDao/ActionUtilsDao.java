package com.ycc.utilsDao;

import com.ycc.entity.eAction;
import com.ycc.enums.ActionId;

import java.util.Random;

/**
 * @author Uni
 * @create 2021/11/14 22:24
 */
public interface ActionUtilsDao extends getDao<eAction>{

    Random R = new Random();
    int ACTION_ID_NUM = ActionId.values().length;

    String action_id();      // 动作的ID号
    String item_type(int i);      // 动作目标类型
    String item();            // 动作目标id
    String ts();             // 动作执行的时间

}
