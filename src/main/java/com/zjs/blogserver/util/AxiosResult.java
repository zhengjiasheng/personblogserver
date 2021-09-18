package com.zjs.blogserver.util;

import lombok.Data;

import java.io.Serializable;

/*
* 返回结果统一封装
* 是否成功  code   (200表示成功，其他表示失败)
* 结果消息  msg     (例如：登录成功)
* 结果数据  data
* */

@Data
public class AxiosResult implements Serializable {
    private int code;
    private String msg;
    private Object data;

    /*
    * 返回成功
    * @param  code 状态码（200）
    * @param  msg  结果消息
    * @param  data 结果数据
    * */
    public static AxiosResult success(int code, String msg, Object data){
        AxiosResult result = new AxiosResult();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /*
    * 返回成功
    * @param  data 结果数据
    * */
    public static AxiosResult success(Object data){
        return AxiosResult.success(200,"操作成功",data);
    }

    /*
     * 返回成功
     * @param  msg 结果消息
     * */
    public static AxiosResult success(String msg){
        return AxiosResult.success(200,msg,null);
    }

    /*
     * 返回成功
     * @param  msg  结果消息
     * @param  data 结果数据
     * */
    public static AxiosResult success(String msg, Object data){
        return AxiosResult.success(200,msg,data);
    }

    /*
     * 返回失败
     * @param  code 状态码（400）
     * @param  msg  结果消息
     * @param  data 结果数据
     * */
    public static AxiosResult error(int code, String msg, Object data){
        AxiosResult result = new AxiosResult();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /*
     * 返回失败
     * @param  msg  结果消息
     * @param  data 结果数据
     * */
    public static AxiosResult error(String msg, Object data){
        return AxiosResult.error(400,msg,data);
    }

    /*
     * 返回失败
     * @param  msg  结果消息
     * */
    public static AxiosResult error(String msg){
        return AxiosResult.error(400,msg,null);
    }
}
