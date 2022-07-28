package com.example.firstproject.utils;


public class ApiUtils {
    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(true, data, null);
    }

    public  static <T> ApiResult<T> error(T data,String msg){

        return new ApiResult<>(false, data, msg);
    }


}