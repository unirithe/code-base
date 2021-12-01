package com.ycc.enums;

/**
 * @author Uni
 * @create 2021/11/15 9:00
 */
public enum PageItemType {
    sku_id("商品skuId"),
    keyword("搜索关键词"),
    sku_ids("多个商品skuId"),
    activity_id("活动id"),
    coupon_id("购物券id");

    private String desc;
    private PageItemType(String desc) {this.desc = desc;}

}
