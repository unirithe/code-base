package com.ycc.enums;

/**
 * @author Uni
 * @create 2021/11/14 22:33
 */
public enum ItemType {
    sku_id("商品"),
    coupon_id("购物券");

    private String desc;
    private ItemType(String desc){
        this.desc = desc;
    }
}
