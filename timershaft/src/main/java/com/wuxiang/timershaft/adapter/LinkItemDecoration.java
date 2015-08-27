package com.wuxiang.timershaft.adapter;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.wuxiang.timershaft.R;

public class LinkItemDecoration extends RecyclerView.ItemDecoration {

    private Context mContext;
    private Drawable mDivider;


    public LinkItemDecoration(Context context, AttributeSet attrs) {
        final TypedArray a = context
                .obtainStyledAttributes(attrs, new int[]{android.R.attr.listDivider});
        this.mDivider = a.getDrawable(0);
        a.recycle();
        this.mContext = context;
    }


    public LinkItemDecoration(Drawable divider, Context context) {
        this.mContext = context;
        this.mDivider = divider;
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
        int left = 0, right = 0, top = 0, bottom = 0;
        int orientation = getOrientation(parent);
        int childCount = parent.getChildCount();
        int count = parent.getAdapter().getItemCount();

        if (orientation == LinearLayoutManager.VERTICAL) {
            left = parent.getPaddingLeft() + (int) mContext.getResources().getDimension(R.dimen.link_line_padding);
            right = left + mDivider.getIntrinsicWidth();
        } else { //horizontal
            top = parent.getPaddingTop() + (int) mContext.getResources().getDimension(R.dimen.link_line_padding);
            bottom = top + mDivider.getIntrinsicHeight();
        }

        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            int theItem = parent.getChildAdapterPosition(child);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            //两个Item之间的垂直间距
            final int vMargin = params.topMargin + params.bottomMargin;
            //两个Item之间的水平间距
            final int hMargin = params.leftMargin + params.leftMargin;

            if (i == 0 && theItem != 0) {
                if (orientation == LinearLayoutManager.VERTICAL) {
                    top = child.getTop() + Math.round(ViewCompat.getTranslationY(child))
                            - vMargin - (int) mContext.getResources().getDimension(R.dimen.link_line_insert);
                    bottom = child.getTop() + Math.round(ViewCompat.getTranslationY(child))
                            + (int) mContext.getResources().getDimension(R.dimen.link_line_insert);
                } else { //horizontal
                    left = child.getLeft() + Math.round(ViewCompat.getTranslationX(child))
                            - hMargin - (int) mContext.getResources().getDimension(R.dimen.link_line_insert);
                    right = child.getLeft() + Math.round(ViewCompat.getTranslationX(child))
                            + (int) mContext.getResources().getDimension(R.dimen.link_line_insert);
                }
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }

            if (theItem != count - 1) {//最后一个Item不画线
                if (orientation == LinearLayoutManager.VERTICAL) {
                    top = child.getBottom() + Math.round(ViewCompat.getTranslationY(child))
                            - (int) mContext.getResources().getDimension(R.dimen.link_line_insert);
                    bottom = child.getBottom() + Math.round(ViewCompat.getTranslationY(child))
                            + vMargin + (int) mContext.getResources().getDimension(R.dimen.link_line_insert);
                } else { //horizontal
                    left = child.getRight() + Math.round(ViewCompat.getTranslationX(child))
                            - (int) mContext.getResources().getDimension(R.dimen.link_line_insert);
                    right = child.getRight() + Math.round(ViewCompat.getTranslationX(child))
                            + hMargin + (int) mContext.getResources().getDimension(R.dimen.link_line_insert);
                }
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
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
