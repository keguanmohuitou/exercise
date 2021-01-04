package com.shangma.cn.common.http;

public enum AixosStatus {
    OK(20000, "执行成功"),
    ERROR(50000, "执行失败"),
    ;

    private int status;
    private String message;


    AixosStatus() {
    }

    AixosStatus(int status, String message) {
        this.status = status;
        this.message = message;
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

    @Override
    public String toString() {
        return "AixosStatus{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
