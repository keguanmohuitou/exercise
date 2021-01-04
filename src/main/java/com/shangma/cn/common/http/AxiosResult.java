package com.shangma.cn.common.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
// 转json的时候只转json不为null的
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AxiosResult<T> {
    private int status;
    private String message;
    private T data;
    //封装数据的公共方法
    public static <T> AxiosResult<T> setObjectData(AixosStatus aixosStatus, T data) {
        AxiosResult<T> axiosResult = new AxiosResult<>();
        axiosResult.setData(data);
        axiosResult.setStatus(aixosStatus.getStatus());
        axiosResult.setMessage(aixosStatus.getMessage());
        return axiosResult;
    }

    public AxiosResult() {
    }
    //成功返回
    public static<T> AxiosResult<T> success() {
        return setObjectData(AixosStatus.OK, null);
    }
    //成功返回 带数据
    public static <T> AxiosResult<T> success(T data) {
        return setObjectData(AixosStatus.OK, data);
    }
    //成功返回 自定义状态码
    public static <T> AxiosResult<T> success(AixosStatus aixosStatus) {
        return setObjectData(aixosStatus, null);
    }
    //成功返回 自定义状态码 带数据
    public static <T> AxiosResult<T> success(AixosStatus aixosStatus, T data) {
        return setObjectData(aixosStatus, data);
    }
    //返回失败
    public static<T> AxiosResult<T> error() {
        return setObjectData(AixosStatus.ERROR, null);
    }
    //返回失败 带数据
    public static <T> AxiosResult<T> error(T data) {
        return setObjectData(AixosStatus.ERROR, data);
    }
    //返回失败 自定义状态码
    public static <T> AxiosResult<T> error(AixosStatus aixosStatus) {
        return setObjectData(aixosStatus, null);
    }
    //返回失败 自定义状态码 带数据
    public static <T> AxiosResult<T> error(AixosStatus aixosStatus, T data) {
        return setObjectData(aixosStatus, data);
    }

}
