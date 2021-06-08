package com.xq.customview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

/**
 * Desc：正方形
 * author：Christiano
 * gitee:
 * time：2021/05/27 16:06
 */
public class SquareImageView extends AppCompatImageView {

    public SquareImageView(Context context,AttributeSet attrs) {
        super(context,attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec,int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);

        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int size = Math.max(measuredWidth,measuredHeight);

        setMeasuredDimension(size,size); //保存测得的尺寸
    }
}
