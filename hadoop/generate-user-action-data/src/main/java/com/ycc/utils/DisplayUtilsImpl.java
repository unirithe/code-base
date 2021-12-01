package com.ycc.utils;

import com.ycc.DataCenter;
import com.ycc.entity.eDisplay;
import com.ycc.enums.BasePageId;
import com.ycc.enums.DisplayType;
import com.ycc.utilsDao.DisplayUtilsDao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Uni
 * @create 2021/11/15 8:20
 */
public class DisplayUtilsImpl implements DisplayUtilsDao {
    String ITEM_ID = null;
    int sum = 0;
    public String displayType() { return DataCenter.getRandomEnumsName(DisplayType.class); }

    public String item() {
        return R.nextInt(2) + "";
    }

    public String item_type() {
        if (ITEM_ID == null);
            ITEM_ID = item();
        return ITEM_TYPE[Integer.parseInt(ITEM_ID)];
    }

    public int order() {
        return ++sum;
    }

    public String pos_id() { return DataCenter.getRandomEnumsName(BasePageId.class); }

    public List<eDisplay> getOne() {
        List<eDisplay> list = new ArrayList<>();
        sum = 0;
        for (int i = 0; i < DISPLAY_MAX; i++) {
            ITEM_ID = null;
            list.add( new eDisplay(displayType(), item_type(), item(), order(), pos_id()));
        }
        return list;
    }

    public List<List<eDisplay>> getMore(int num) {
        List<List<eDisplay>> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(getOne());
        }
        return list;
    }
}
