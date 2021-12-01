package com.ycc.utilsDao;

import com.ycc.entity.eUser;

import java.util.Random;

/**
 * @author Uni
 * @create 2021/11/14 15:57
 */
public interface UserUtilsDao extends getDao<eUser>{
    public static final String[] PHONE_BRAND = new String[] {
            "Huawei Mate 40 Pro","Huawei P40 Pro", "Huawei Mate30 Pro", "Huawei nova8 SE",
            "Huawei nova 9 Pro", "Huawei P50 Pro","Huawei nova 5i Pro","Huawei Mate40",
            "iPhone 13ProMax", "iPhone13", "iPhone-12Mini", "iPhone 12",
            "iPhone 11Pro", "iPhone SE","iPhone X", "iPhone 8Plus",
            "iPhone 7plus","iPhone 7","iPhone 6s","iPhone 6"
    };
    int PHONE_BRAND_NUM = PHONE_BRAND.length;
    int VIP_MAX_TIME = 24;     // 规定所有会员的最大时间限制 ，单位: 月
    Random R = new Random();

    String md();         // 生成随机的手机型号
    String ar();         // 生成随机的地区编码
    String isNew();      // 生成是否当天首次使用
    String vip();        // 生成随机会员身份
}
