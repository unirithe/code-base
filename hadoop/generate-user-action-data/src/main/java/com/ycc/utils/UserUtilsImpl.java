package com.ycc.utils;

import com.ycc.entity.eUser;
import com.ycc.utilsDao.UserUtilsDao;
import lombok.val;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Uni
 * @create 2021/11/14 14:49
 */
public class UserUtilsImpl implements UserUtilsDao {

    // 生成随机的手机型号
    public String md(){
        return PHONE_BRAND[R.nextInt(PHONE_BRAND_NUM)];
    }
    // 生成随机的地区编码
    public String ar(){
        return R.nextInt(34) + "";
    }
    // 生成是否当天首次使用
    public String isNew(){
        return  R.nextBoolean() ? "Y" : "N";
    }
    // 生成随机会员身份
    public String vip(){
        return R.nextInt(VIP_MAX_TIME) + "";
    }

    public eUser getOne() {
        return new eUser(ar(), md(), isNew(), vip());
    }

    public List<eUser> getMore(int num) {
        List<eUser> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(getOne());
        }
        return list;
    }
}
