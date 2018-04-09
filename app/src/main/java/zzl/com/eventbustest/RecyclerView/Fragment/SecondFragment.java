package zzl.com.eventbustest.RecyclerView.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.CallBack;
import com.zhouyou.http.callback.SimpleCallBack;

import zzl.com.eventbustest.Constant.API;
import zzl.com.eventbustest.R;

public class SecondFragment extends Fragment {
    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager layoutManager;

    public SecondFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        initView(view);
        getData();
        return view;
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.waterRecycler);
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

    }

    private void getData() {
        EasyHttp.get(API.PIC)
                .readTimeOut(3000)
                .writeTimeOut(3000)
                .connectTimeout(3000)
                .execute(new SimpleCallBack<Object>() {

                });

    }

}
