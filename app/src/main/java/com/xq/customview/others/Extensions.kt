package com.xq.customview.others

import android.content.res.Resources
import android.util.TypedValue

/**
 * Desc：
 * author：Christiano
 * gitee:
 * time：2021/06/16 15:42
 */
val Float.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )

val Int.dp
    get() = this.toFloat().dp