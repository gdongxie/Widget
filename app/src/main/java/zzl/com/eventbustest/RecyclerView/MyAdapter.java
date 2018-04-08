package zzl.com.eventbustest.RecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import zzl.com.eventbustest.R;

/**
 * Created by ZZL on 2018/4/8.
 * Email:gdongxie@gmail.com
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<String> mList;
    private Context context;

    /**
     * 事件回调监听
     */
    private MyAdapter.OnItemClickListener onItemClickListener;

    public MyAdapter(Context context, ArrayList<String> mList) {
        this.mList = mList;
        this.context = context;
    }

    public void updateData(ArrayList<String> data) {
        this.mList = data;
        notifyDataSetChanged();
    }

    public void addNewItem() {
        if (mList == null) {
            mList = new ArrayList<>();
        }
        mList.add(0, "new Item");
        notifyItemInserted(0);
    }

    public void deleteItem() {
        if (mList == null || mList.isEmpty()) {
            return;
        }
        mList.remove(0);
        notifyItemRemoved(0);
    }

    /**
     * 设置回调监听
     *
     * @param listener
     */
    public void setOnItemClickListener(MyAdapter.OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.textView.setText(mList.get(position));
        //点击事件
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder.textView, pos);
                }
            }
        });
        //长点击事件
        holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onItemClickListener != null) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemLongClick(holder.textView, pos);
                }
                //表示此事件已经消费，不会触发单击事件
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;


        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }
}
