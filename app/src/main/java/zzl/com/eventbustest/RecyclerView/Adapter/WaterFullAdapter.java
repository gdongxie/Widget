package zzl.com.eventbustest.RecyclerView.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import zzl.com.eventbustest.R;
import zzl.com.eventbustest.RecyclerView.Bean.MeiNvBean;

/**
 * Created by ZZL on 2018/4/9.
 * Email:gdongxie@gmail.com
 * RecyclerView瀑布流适配器
 */

public class WaterFullAdapter extends RecyclerView.Adapter<WaterFullAdapter.ViewHolder> {
    private Context mContext;
    private List<MeiNvBean.NewslistBean> mList = new ArrayList<>();
    private List<Integer> mHeights;

    public WaterFullAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void getRandomHeight(List<MeiNvBean.NewslistBean> mList) {
        mHeights = new ArrayList<>();
        for (int i = 0; i < mList.size(); i++) {
            //随机的获取一个范围为200-600直接的高度
            mHeights.add((int) (300 + Math.random() * 400));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_waterfull, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.height = mHeights.get(position);
        holder.itemView.setLayoutParams(layoutParams);

        holder.textView.setText(mList.get(position).getTitle());
        Picasso.with(mContext).load(mList.get(position).getPicUrl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
            imageView = itemView.findViewById(R.id.imageview);
        }
    }

    public List<MeiNvBean.NewslistBean> getList() {
        return mList;
    }
}
