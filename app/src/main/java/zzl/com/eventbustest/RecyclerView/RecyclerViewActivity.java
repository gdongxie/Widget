package zzl.com.eventbustest.RecyclerView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import zzl.com.eventbustest.R;

public class RecyclerViewActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mlayoutManager;
    private ArrayList<String> mList = new ArrayList<>();
    private MyAdapter myAdapter;
    private Button btn_add, btn_del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);


        initData();
        initView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerview);
        btn_add = findViewById(R.id.btn_add);
        btn_del = findViewById(R.id.btn_del);
        btn_add.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        //初始化布局管理器
        mlayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //设置方向布局
        recyclerView.setLayoutManager(mlayoutManager);
        //添加间隔线
        recyclerView.addItemDecoration(new MyItemDecoration(this, LinearLayoutManager.VERTICAL));
        // 设置Item添加和移除的动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        myAdapter = new MyAdapter(this, mList);
        recyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        //设置点击事件与长点击事件
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecyclerViewActivity.this, "Click" + position + "item", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(RecyclerViewActivity.this, "LongcClick" + position + "item", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initData() {
        for (int i = 0; i < 50; i++) {
            mList.add("RecyclerView----" + i);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                myAdapter.addNewItem();
                // 由于Adapter内部是直接在首个Item位置做增加操作，增加完毕后列表移动到首个Item位置
                mlayoutManager.scrollToPosition(0);
                break;
            case R.id.btn_del:
                myAdapter.deleteItem();
                // 由于Adapter内部是直接在首个Item位置做删除操作，删除完毕后列表移动到首个Item位置
                mlayoutManager.scrollToPosition(0);
                break;
            default:
                break;
        }
    }
}
