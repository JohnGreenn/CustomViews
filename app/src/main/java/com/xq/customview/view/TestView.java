package com.xq.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Desc：
 * author：Christiano
 * gitee:
 * time：2021/05/13 16:23
 */
public class TestView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public TestView(Context context,@Nullable AttributeSet attrs) {
        super(context,attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(100,100,200,200,paint);
        canvas.drawCircle(getWidth()/2,getHeight()/2,200, paint);

        canvas.drawColor(Color.parseColor("#88880000"));
    }
}
