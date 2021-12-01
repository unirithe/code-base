package com.ycc.log;

import com.ycc.entity.eError;
import com.ycc.entity.eRun;
import com.ycc.entity.eUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
启动页面埋点日志
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StartLog {
    private eUser common;     // 公共信息
    private eRun start;       // 启动信息
    private eError err;      // 错误信息
    private String ts;       // 跳入时间戳
}
