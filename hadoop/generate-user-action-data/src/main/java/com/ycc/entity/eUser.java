package com.ycc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共信息
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class eUser {
    private String ar;  // 地址编码
    private String md;  // 手机型号
    private String is_new;  // 是否当天首次使用
    private String vip; // 会员等级 1级表示1个月 0表示非会员
}
