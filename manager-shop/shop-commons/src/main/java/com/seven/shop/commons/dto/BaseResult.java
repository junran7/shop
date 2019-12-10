package com.seven.shop.commons.dto;

import java.io.Serializable;

/**
 * 返回结果集的封装
 *
 * @Author JR
 * @Date 2019/11/13 17:37
 **/
public class BaseResult implements Serializable {

    public static final int SUCCESS_STATE =200;
    public static final int FAIL_STATE =500;

    private int status;

    private String message;

    public static BaseResult success(){
        BaseResult baseResult = createBaseResult(SUCCESS_STATE, "SUCCESS");
        return baseResult;

    }

    public static BaseResult fail(){
        BaseResult baseResult = createBaseResult(FAIL_STATE, "FAIL");
        return baseResult;

    }

    public static BaseResult fail(String message){
        BaseResult baseResult = createBaseResult(FAIL_STATE, message);
        return baseResult;

    }

    public static BaseResult success(String message){
        BaseResult baseResult = createBaseResult(SUCCESS_STATE, message);
        return baseResult;
    }

    public static BaseResult createBaseResult(int status,String message){
        BaseResult baseResult=new BaseResult();
        baseResult.status=status;
        baseResult.message=message;
        return baseResult;
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
