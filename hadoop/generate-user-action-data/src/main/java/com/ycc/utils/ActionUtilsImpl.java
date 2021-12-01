package com.ycc.utils;

import com.ycc.entity.eAction;
import com.ycc.enums.ActionId;
import com.ycc.enums.ItemType;
import com.ycc.utilsDao.ActionUtilsDao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Uni
 * @create 2021/11/14 22:24
 */
public class ActionUtilsImpl implements ActionUtilsDao {

    public String action_id() {
        int i = R.nextInt(ACTION_ID_NUM);
        return ActionId.class.getEnumConstants()[i].name();
    }
    public String item_type(int i) {return ItemType.class.getEnumConstants()[i].name();}
    public String item() {
        return R.nextInt(2) + "";
    }
    public String ts() {return System.currentTimeMillis() + "";}

    public eAction getOne() {
        int ItemId = Integer.parseInt(item());
        return new eAction(action_id(), item_type(ItemId), ItemId + "", ts());
    }

    public List<eAction> getMore(int num) {
        List<eAction> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(getOne());
        }
        return list;
    }
}
