package com.ycc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 页面实体类
 记录一个页面的用户访问情况，包括访问事件、停留时间、页面路径等信息。
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ePage {
    private String page_id;         // 页面ID
    private String last_page_id;    // 上个页面的ID
    private String item;            // 目标ID
    private String item_type;       // 目标类型
    private String soucrceType;     // 页面来源类型
    private String during_time;     // 停留时间
}
