package com.ycc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 启动数据实体类
 记录应用的启动信息
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class eRun {
    private String entry;           // 启动入口
    private String loading_time;    // 启动加载时间
    private String open_ad_id;      // 开屏广告ID
    private String open_ad_ms;      // 广告播放时间
    private String open_ad_skip_ms;  // 用户跳过广告时间
    private String ts;               // 启动时间
}
