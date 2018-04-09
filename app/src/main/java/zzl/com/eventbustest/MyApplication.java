package zzl.com.eventbustest;

import android.app.Application;

import com.zhouyou.http.EasyHttp;

/**
 * Created by ZZL on 2018/4/9.
 * Email:gdongxie@gmail.com
 */

public class MyApplication  extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        EasyHttp.init(this);
    }
}
