package com.ycc.log;

import com.ycc.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
普通页面埋点日志
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageLog {
    private eUser common;       // 公共信息
    private eAction action;     // 动作 - 事件
    private List<eDisplay> display;   // 曝光
    private ePage page;         // 页面信息
    private eError error;       // 错误
    private String ts;          // 跳入时间戳
}
