package com.ycc.utils;

import com.ycc.entity.eRun;
import com.ycc.utilsDao.StartUtilsDao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Uni
 * @create 2021/11/14 16:25
 */
public class StartUtilsImpl implements StartUtilsDao {
    // 获得入口
    public String entry() {
        return ENTRY_TYPE[R.nextInt(ENTRY_TYPE_NUM)];
    }
    // 获取随机启动加载时间
    public String loading_time() {
        return R.nextInt(LOADING_MAX) + "";
    }
    // 获取广告页ID
    public String open_ad_id() {
        return R.nextInt(AD_ID_MAX) + "";
    }
    // 广告播放时间和用户跳过广告的耗时，单位：毫秒
    public String[] open_ad_ms() {
        int ad_ms = R.nextInt(AD_MS_MAX) + 1; // 防止为负
        int close_ms = R.nextInt(ad_ms);
        return new String[]{ad_ms + "", close_ms + ""};
    }

    public eRun getOne() {
        String[] ad = open_ad_ms();
        String nowTime = String.valueOf(System.currentTimeMillis());
        eRun run = new eRun(entry(), loading_time(), open_ad_id(), ad[0], ad[1], nowTime);
        return run;
    }

    public List<eRun> getMore(int num) {
        List<eRun> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(getOne());
        }
        return list;
    }
}
