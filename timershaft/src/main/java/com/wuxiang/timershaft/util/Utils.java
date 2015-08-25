package com.wuxiang.timershaft.util;

import android.util.Log;

public class Utils {
    private static final String TAG = "Utils";
    private static final boolean isShowLog = true;

    public static void showLogE(String log) {
        if (isShowLog) {
            Log.e(TAG, log);
        }
    }
}
