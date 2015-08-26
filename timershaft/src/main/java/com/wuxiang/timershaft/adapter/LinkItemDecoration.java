package com.wuxiang.timershaft.adapter;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.wuxiang.timershaft.R;
import com.wuxiang.timershaft.util.Utils;

public class LinkItemDecoration extends RecyclerView.ItemDecoration {

    private Context mContext;
    private Drawable mDivider;
    private boolean mShowFirstDivider = true;
    private boolean mShowLastDivider = false;


    public LinkItemDecoration(Context context, AttributeSet attrs) {
        final TypedArray a = context
                .obtainStyledAttributes(attrs, new int[]{android.R.attr.listDivider});
        this.mDivider = a.getDrawable(0);
        a.recycle();
        this.mContext = context;
    }

    public LinkItemDecoration(Context context, AttributeSet attrs, boolean showFirstDivider,
                              boolean showLastDivider) {
        this(context, attrs);
        mShowFirstDivider = showFirstDivider;
        mShowLastDivider = showLastDivider;
    }

    public LinkItemDecoration(Drawable divider, Context context) {
        this.mContext = context;
        this.mDivider = divider;
    }

    public LinkItemDecoration(Drawable divider, Context context, boolean showFirstDivider,
                              boolean showLastDivider) {
        this(divider, context);
        mShowFirstDivider = showFirstDivider;
        mShowLastDivider = showLastDivider;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        /*如果是画横线，这里可以把增加两个Item之间的距离，空出横线的空间
        if (mDivider == null) {
            return;
        }
        if (parent.getChildAdapterPosition(view) < 1) {
            return;
        }

        if (getOrientation(parent) == LinearLayoutManager.VERTICAL) {
            outRect.top = mDivider.getIntrinsicHeight();
        } else {
            outRect.left = mDivider.getIntrinsicWidth();
        }
        */
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (mDivider == null) {
            super.onDrawOver(c, parent, state);
            return;
        }

        // 初始化画布的大小
        int left = 0, right = 0, top = 0, bottom = 0, size;
        int orientation = getOrientation(parent);
        int childCount = parent.getChildCount();


        if (orientation == LinearLayoutManager.VERTICAL) {
            size = mDivider.getIntrinsicHeight();
            left = parent.getPaddingLeft() + (int) mContext.getResources().getDimension(R.dimen.link_line_padding_left);
            right = left + mDivider.getIntrinsicWidth();
        } else { //horizontal
            size = mDivider.getIntrinsicWidth();
            top = parent.getPaddingTop() + parent.getHeight() / 2;
            bottom = top + mDivider.getIntrinsicHeight();
        }

        for (int i = mShowFirstDivider ? 0 : 1; i < childCount - 3; i++) {
            View child = parent.getChildAt(i);

            int the = parent.getChildAdapterPosition(child);
            Utils.showLogE("绘制第几个item的线：" + the);
            if (the == 0) continue;

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            if (orientation == LinearLayoutManager.VERTICAL) {
                top = child.getTop() - params.topMargin - 50;
                bottom = top + size * 5;
            } else { //horizontal
                left = child.getLeft() - params.leftMargin;
                right = left + size;
            }
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }

        // show last divider
        if (mShowLastDivider && childCount > 0) {
            View child = parent.getChildAt(childCount - 1);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            if (orientation == LinearLayoutManager.VERTICAL) {
                top = child.getBottom() + params.bottomMargin;
                bottom = top + size;
            } else { // horizontal
                left = child.getRight() + params.rightMargin;
                right = left + size;
            }
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    private int getOrientation(RecyclerView parent) {
        if (parent.getLayoutManager() instanceof LinearLayoutManager) {
            LinearLayoutManager layoutManager = (LinearLayoutManager) parent.getLayoutManager();
            return layoutManager.getOrientation();
        } else {
            throw new IllegalStateException(
                    "LinkItemDecoration can only be used with a LinearLayoutManager.");
        }
    }
}
