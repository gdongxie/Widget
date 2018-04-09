package zzl.com.eventbustest.RecyclerView.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.CallBack;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

import zzl.com.eventbustest.Constant.API;
import zzl.com.eventbustest.R;
import zzl.com.eventbustest.RecyclerView.Adapter.WaterFullAdapter;
import zzl.com.eventbustest.RecyclerView.Bean.MeiNvBean;

public class SecondFragment extends Fragment {
    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager layoutManager;
    private List<MeiNvBean.NewslistBean> beanList = new ArrayList<>();
    private WaterFullAdapter waterFullAdapter;

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
        waterFullAdapter = new WaterFullAdapter(getActivity());
        recyclerView.setAdapter(waterFullAdapter);

    }

    private void getData() {
        EasyHttp.get(API.PIC)
                .baseUrl(API.BASE_URL)
                .readTimeOut(3000)
                .writeTimeOut(3000)
                .connectTimeout(3000)
                .execute(new SimpleCallBack<String>() {

                    @Override
                    public void onError(ApiException e) {
                        Toast.makeText(getActivity(), "请求失败", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onSuccess(String response) {
                        Log.d("zzz", response.toString());
                        if (response != null) {
                            Gson gson = new Gson();
                            MeiNvBean meiNvBean = gson.fromJson(response, MeiNvBean.class);
                            if (meiNvBean.getCode() == 200) {
                                beanList.addAll(meiNvBean.getNewslist());
                                waterFullAdapter.getList().addAll(beanList);
                                waterFullAdapter.getRandomHeight(beanList);
                                waterFullAdapter.notifyDataSetChanged();
                            } else {
                                Toast.makeText(getActivity(), meiNvBean.getMsg(), Toast.LENGTH_LONG).show();
                            }
                        }

                    }
                });

    }

}
