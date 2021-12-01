package com.ycc.enums;

/**
 * @author Uni
 * @create 2021/11/14 22:39
 */
public enum DisplayType {
    promotion("商品推广"),
    recommend("算法推荐商品"),
    query("查询结果商品"),
    activity("促销活动");

    private String desc;

    DisplayType(final String desc) {
        this.desc = desc;
    }
}
