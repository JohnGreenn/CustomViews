package com.xq.customview;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Desc：
 * author：Christiano
 * gitee:
 * time：2021/05/13 16:53
 */
public class Utils {
    public static float dpToPixel(float dp) {
        return  TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                Resources.getSystem().getDisplayMetrics());
    }
}
