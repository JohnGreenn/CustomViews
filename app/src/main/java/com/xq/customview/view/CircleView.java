package com.xq.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PostProcessor;
import android.net.wifi.hotspot2.omadm.PpsMoParser;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.xq.customview.Utils;

/**
 * Desc：矩形跟着圆的变化而变化
 * author：Christiano
 * gitee:
 * time：2021/05/28 10:52
 */
public class CircleView extends View {
    private static final int RADIUS = (int) Utils.dpToPixel(100);
    private static final int PADDING = (int) Utils.dpToPixel(50);

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public CircleView(Context context,@Nullable AttributeSet attrs) {
        super(context,attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec,int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        int width = (PADDING + RADIUS) * 2;
        int height = (PADDING + RADIUS) * 2;

        //尺寸修正
        width = resolveSizeAndState(width,widthMeasureSpec,0);
        height = resolveSizeAndState(height,widthMeasureSpec,0);

        setMeasuredDimension(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.RED); //背景
        canvas.drawCircle(PADDING + RADIUS, PADDING + RADIUS, RADIUS, paint);
    }
}
