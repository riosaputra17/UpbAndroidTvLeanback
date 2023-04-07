package com.pelitabangsa.upbandroidtv.utils;

import android.content.Context;

public class Common {
    public static int getWidthInPercent(Context context, int percent) {
        int width = context.getResources().getDisplayMetrics().widthPixels;
        return (width * percent) / 100;
    }
}
