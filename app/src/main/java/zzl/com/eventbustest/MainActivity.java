package zzl.com.eventbustest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import zzl.com.eventbustest.EventBus.MessageEvent;
import zzl.com.eventbustest.EventBus.SecondActivity;
import zzl.com.eventbustest.RecyclerView.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private Button button, btn_recycler;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册成为订阅者
        EventBus.getDefault().register(this);
        textView = findViewById(R.id.tv);
        button = findViewById(R.id.btn);
        btn_recycler = findViewById(R.id.btn_recycler);
        //EventBus
        button.setOnClickListener(this);
        //RecyclerView
        btn_recycler.setOnClickListener(this);
    }

    //订阅方法，当接收到消息时，会调用该方法
    //权限必须是public 参数只有一个 为要传递的消息类型

    /**
     * @param messageEvent ThreadMode是枚举类型，有POSTING(默认)、MAIN、BACKGROUND、ASYNC
     *                     POSTING:表示订阅方法运行在发送事件的线程。
     *                     MAIN：表示订阅方法运行在UI线程，由于UI线程不能阻塞，因此当使用MAIN的时候，订阅方法不应该耗时过长。
     *                     BACKGROUND：表示订阅方法运行在后台线程，如果发送的事件线程不是UI线程，那么就使用该线程；如果发送事件的线程是UI线程，那么新建一个后台线程来调用订阅方法。
     *                     ASYNC：订阅方法与发送事件始终不在同一个线程，即订阅方法始终会使用新的线程来运行。
     *                     ThreadMode默认是使用POSTING的，如果需要更改设置，可以在添加注解的时候同时为threadMode赋值。
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent messageEvent) {
        Log.d("zzz", "receive message");
        textView.setText(messageEvent.getMessage());
        Toast.makeText(MainActivity.this, messageEvent.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Activity销毁时，解除注册，释放资源
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
                intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_recycler:
                intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }


    }
}
