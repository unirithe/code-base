package com.ycc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 事件数据实体类
 记录应用内一个具体操作行为，包括操作类型、操作对象、操作对象描述等信息
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class eAction {
    private String action_id;   // 动作ID
    private String item_type;   // 动作目标类型
    private String item;        // 动作目标ID
    private String ts;          // 动作时间
}
