package zzl.com.eventbustest.RecyclerView.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import zzl.com.eventbustest.R;
import zzl.com.eventbustest.RecyclerView.Adapter.MyAdapter;
import zzl.com.eventbustest.RecyclerView.Widget.MyItemDecoration;


public class FirstFragment extends Fragment implements View.OnClickListener {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mlayoutManager;
    private ArrayList<String> mList = new ArrayList<>();
    private MyAdapter myAdapter;
    private Button btn_add, btn_del;

    public FirstFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        initData();
        initView(view);
        return view;
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recyclerview);
        btn_add = view.findViewById(R.id.btn_add);
        btn_del = view.findViewById(R.id.btn_del);
        btn_add.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        //初始化布局管理器
        mlayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        //设置方向布局
        recyclerView.setLayoutManager(mlayoutManager);
        //添加间隔线
        recyclerView.addItemDecoration(new MyItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        // 设置Item添加和移除的动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        myAdapter = new MyAdapter(getActivity(), mList);
        recyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        //设置点击事件与长点击事件
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), "Click" + position + "item", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(getActivity(), "LongcClick" + position + "item", Toast.LENGTH_SHORT).show();

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
