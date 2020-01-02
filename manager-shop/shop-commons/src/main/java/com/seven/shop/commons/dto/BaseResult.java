package com.seven.shop.commons.dto;

import com.seven.shop.commons.persistence.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * 返回结果集的封装
 *
 * @Author JR
 * @Date 2019/11/13 17:37
 **/
@Data
public class BaseResult implements Serializable {

    public static final int SUCCESS_STATE = 200;
    public static final int FAIL_STATE = 500;

    private int status;

    private String message;

    private Object data;

    public static BaseResult success() {
        BaseResult baseResult = createBaseResult(SUCCESS_STATE, "SUCCESS",null);
        return baseResult;

    }

    public static BaseResult success(String message) {
        BaseResult baseResult = createBaseResult(SUCCESS_STATE, message,null);
        return baseResult;
    }

    public static BaseResult success(String message, Object obj) {
        BaseResult baseResult = createBaseResult(SUCCESS_STATE, message, obj);
        return baseResult;
    }

    public static BaseResult fail() {
        BaseResult baseResult = createBaseResult(FAIL_STATE, "FAIL",null);
        return baseResult;

    }

    public static BaseResult fail(String message) {
        BaseResult baseResult = createBaseResult(FAIL_STATE, message,null);
        return baseResult;

    }


    public static BaseResult createBaseResult(int status, String message, Object obj) {
        BaseResult baseResult = new BaseResult();
        baseResult.status = status;
        baseResult.message = message;
        baseResult.data = obj;
        return baseResult;
    }

}
