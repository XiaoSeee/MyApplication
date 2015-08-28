package com.wuxiang.timershaft.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wuxiang.timershaft.R;

/**
 * Created by Lizixuan on 2015/8/23.
 * 第一页布局
 */
public class AlarmRecyclerAdapter extends RecyclerView.Adapter<AlarmRecyclerAdapter.ViewHolder> {

    private int mCount = 15;
    private static String TEXT = "Click  the item to ";

    public AlarmRecyclerAdapter() {
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.alarm_item_card, viewGroup, false);
        ViewHolder vh = new ViewHolder(view, this);
        return vh;
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        if (position == 2) {
            viewHolder.mTextView.setText(TEXT + "remove " + position);
        } else {
            viewHolder.mTextView.setText(TEXT + "add " + position);
        }

    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return mCount;
    }

    public void addTitle() {
        mCount++;
        notifyItemInserted(1);
    }

    public void remove(int position) {
        mCount--;
        notifyItemRemoved(position);
    }

    public void move(int from, int to) {
        notifyItemMoved(from, to);
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public AlarmRecyclerAdapter mAdapter;

        public ViewHolder(View view, AlarmRecyclerAdapter adapter) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.text_view);
            mAdapter = adapter;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() == 2) {
//                        mAdapter.remove(2);
                        mAdapter.move(2, 0);
                    } else {
                        mAdapter.addTitle();
                    }
                }
            });
        }
    }
}
