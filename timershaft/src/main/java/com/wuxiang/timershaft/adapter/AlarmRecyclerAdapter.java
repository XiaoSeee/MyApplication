package com.wuxiang.timershaft.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wuxiang.timershaft.R;
import com.wuxiang.timershaft.util.Utils;

/**
 * Created by Lizixuan on 2015/8/23.
 * 第一页布局
 */
public class AlarmRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int mCount = 15;
    private static String TEXT = "Click  the item to ";
    private Context mContext;

    private static final int ITEM_TYPE_TIME = 0;
    private static final int ITEM_TYPE_ALARM = 1;

    public AlarmRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        if (viewType == ITEM_TYPE_TIME) {
            return new TimeViewHolder(LayoutInflater.from(mContext).inflate(R.layout.time_item_card, viewGroup, false), this);
        } else {
            return new AlarmViewHolder(LayoutInflater.from(mContext).inflate(R.layout.alarm_item_card, viewGroup, false), this);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final int viewType = getItemViewType(position);
        if (viewType == ITEM_TYPE_TIME) {

        } else {
            ((AlarmViewHolder) holder).mTextView.setText(TEXT);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ITEM_TYPE_TIME;
        } else {
            return ITEM_TYPE_ALARM;
        }
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return mCount;
    }

    public void addTitle() {
        Utils.showToast(mContext, "添加一个Item");
        mCount++;
        notifyItemInserted(1);
    }

    public void remove(int position) {
        Utils.showToast(mContext, "删除一个Item");
        mCount--;
        notifyItemRemoved(position);
    }

    public void move(int from, int to) {
        notifyItemMoved(from, to);
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class AlarmViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public AlarmRecyclerAdapter mAdapter;

        public AlarmViewHolder(View view, AlarmRecyclerAdapter adapter) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.text_view);
            mAdapter = adapter;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() == 2) {
                        mAdapter.remove(2);
//                        mAdapter.move(2, 0);
                    } else {
                        mAdapter.addTitle();
                    }
                }
            });
        }
    }

    public static class TimeViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public AlarmRecyclerAdapter mAdapter;

        public TimeViewHolder(View view, AlarmRecyclerAdapter adapter) {
            super(view);
        }
    }
}
