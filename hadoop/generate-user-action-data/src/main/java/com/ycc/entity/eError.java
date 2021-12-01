package com.ycc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 错误数据实体类
 记录过程中的错误信息，包括错误编号及错误信息
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class eError {
    private String error_code;
    private String msg;
}
