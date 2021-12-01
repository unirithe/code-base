package com.ycc.enums;

/**
 * @author Uni
 * @create 2021/11/14 22:38
 */
public enum BasePageId {
    home("首页"),
    category("分类页"),
    discovery("发现页"),
    top_n("热门排行"),
    favor("收藏页"),
    search("搜索页"),
    activity("活动");
    private String desc;

    private BasePageId(String desc) {
        this.desc = desc;
    }
}
