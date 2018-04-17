package cn.porkchop.utils;

public class ResponseResult {
    private String message;
    private int status;
    private Object data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResponseResult success(String message) {
        ResponseResult result = new ResponseResult();
        result.message = message;
        result.status = 200;
        return result;
    }

    public static ResponseResult success() {
        return success("操作成功");
    }

    public static ResponseResult fail(String message) {
        ResponseResult result = new ResponseResult();
        result.message = message;
        result.status = 500;
        return result;
    }

    public static ResponseResult build(String message, int status) {
        ResponseResult result = new ResponseResult();
        result.message = message;
        result.status = status;
        return result;
    }
}
