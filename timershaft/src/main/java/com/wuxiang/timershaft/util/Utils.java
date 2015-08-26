package com.wuxiang.timershaft.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;

public class Utils {
    private static final String TAG = "Utils";
    private static final boolean isShowLog = true;

    public static void showLogE(String log) {
        if (isShowLog) {
            Log.e(TAG, log);
        }
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
