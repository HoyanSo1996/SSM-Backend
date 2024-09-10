package com.omega.ssm.entity;

import lombok.Data;

/**
 * Class ResultInfo
 *
 * @author KennySo
 * @date 2024/9/8
 */
@Data
public class ResultInfo {

    private Integer code;   // 状态码
    private String msg;     // 操作信息
    private Object data;    // 返回数据

    public ResultInfo() {
    }

    public ResultInfo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultInfo(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}