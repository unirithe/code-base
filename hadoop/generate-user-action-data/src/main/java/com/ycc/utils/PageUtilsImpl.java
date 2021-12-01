package com.ycc.utils;

import com.ycc.DataCenter;
import com.ycc.entity.ePage;
import com.ycc.enums.PageId;
import com.ycc.enums.PageItemType;
import com.ycc.enums.SourceType;
import com.ycc.utilsDao.PageUtilsDao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Uni
 * @create 2021/11/15 8:52
 */
public class PageUtilsImpl implements PageUtilsDao {
    String ITEM_ID = null;
    String LAST_PAGE_ID = null;
    String PAGE_ID = null;
    public String during_time() {
        return null;
    }

    public String item() {
        return R.nextInt(PageId.values().length) + "";
    }

    public String item_type() {
        if (ITEM_ID == null);
            ITEM_ID = item();
        return PageId.class.getEnumConstants()[Integer.parseInt(ITEM_ID)].name();
    }

    public String last_page_id() {
        return DataCenter.getRandomEnumsName(PageItemType.class);
    }

    public String page_id() {
        PAGE_ID = DataCenter.getRandomEnumsName(PageId.class);
        if (LAST_PAGE_ID == null)
            LAST_PAGE_ID = last_page_id();
        while (LAST_PAGE_ID.equals(PAGE_ID))
            PAGE_ID = DataCenter.getRandomEnumsName(PageId.class);
        return PAGE_ID;
    }
    public String sourceType() {
        return DataCenter.getRandomEnumsName(SourceType.class);
    }

    public ePage getOne() {
        return new ePage(page_id(), last_page_id(), item(), item_type(), sourceType(), during_time());
    }

    public List<ePage> getMore(int num) {
        List<ePage> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(getOne());
        }
        return list;
    }
}
