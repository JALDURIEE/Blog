package com.ping.blog.common;

/**
 * 错误码
 * 
 * @author  tiancong
 * 
 */
public enum ResponseEnum {
	
    SUCCESS("0", "Operation successfully."),
    FAILURE("1", "Operation failed."),
    INVALID_LOGIN_PWD("10", "Invalid login password"),
    INVALID_REG_NAME("13","invalid name");
	
    
     private  String code;

    private String message;

    // 构造方法  
    private ResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
