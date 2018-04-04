package zzl.com.eventbustest;

/**
 * Created by ZZL on 2018/4/4.
 * Email:gdongxie@gmail.com
 */

public class MessageEvent {
    public MessageEvent(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
