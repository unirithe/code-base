package com.ycc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
曝光数据实体类
 记录页面所曝光的内容，包括曝光对象、曝光类型等名称

 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class eDisplay {
    private String displayType; // 曝光类型
    private String item_type;   // 曝光对象类型
    private String item;        // 曝光对象id
    private int order;          // 曝光顺序
    private String pos_id;      // 曝光位置
}
