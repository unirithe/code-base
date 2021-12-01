package com.ycc.enums;

/**
 * @author Uni
 * @create 2021/11/15 8:57
 */
public enum SourceType {
    promotion("商品推广"),
    recommend("算法推荐商品"),
    query("查询结果商品"),
    activity("促销活动");

    private String desc;
    SourceType(String desc) {this.desc = desc;}

}
