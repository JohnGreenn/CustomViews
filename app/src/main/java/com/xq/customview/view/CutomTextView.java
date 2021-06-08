package com.xq.customview.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.xq.customview.R;

/**
 * Desc：
 * author：Christiano
 * gitee:
 * time：2021/05/13 14:56
 */
public class CutomTextView extends View {

    private int mTextSize;
    private int mTextColor;
    private String mText;
    private Paint mPaint;

    public CutomTextView(Context context) {
        super(context);
    }

    public CutomTextView(Context context,@Nullable AttributeSet attrs) {
        super(context,attrs);
    }

    public CutomTextView(Context context,@Nullable AttributeSet attrs,int defStyleAttr) {
        super(context,attrs,defStyleAttr);

        // 获取自定义属性
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CutomTextView);
        mText = array.getString(R.styleable.CutomTextView_peakmainText);
        // 15 15px 15sp
        mTextColor = array.getColor(R.styleable.CutomTextView_peakmainTextColor, mTextColor);
        mTextSize = array.getDimensionPixelSize(R.styleable.CutomTextView_peakmainTextSize, sp2x(15));
        // 回收
        array.recycle();
        mPaint = new Paint();
        //设置抗锯齿
        mPaint.setAntiAlias(true);
        //设置字体和颜色
        mPaint.setTextSize(mTextSize);
        mPaint.setColor(mTextColor);
    }
    /**
     * sp
     */
    public int sp2x(int sp){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                sp,getResources().getDisplayMetrics());
    }

    /**
     * 自定义view的测量方法
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //布局的宽高都是有这个方法指定
        //指定控件的宽高,需要测量
        //获取宽高的模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        /**
         * MeasureSpec.AT_MOST : 在布局中指定了wrap_content
         * MeasureSpec.EXACTLY : 在不居中指定了确切的值  100dp   match_parent  fill_parent
         * MeasureSpec.UNSPECIFIED : 尽可能的大,很少能用到，ListView , ScrollView 在测量子布局的时候会用UNSPECIFIED
         */
        //获取宽高的大小

        //1.确定的值，这时候不需要计算的
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        //2.不确定的值，wrap_content 需要计算

        if (widthMode == MeasureSpec.AT_MOST) {
            @SuppressLint("DrawAllocation") Rect bounds = new Rect();
            //计算的宽度 与字体的长度有关 用画笔测量
            mPaint.getTextBounds(mText, 0, mText.length(), bounds);
            width = bounds.width()+getPaddingLeft()+getPaddingRight();

        }
        if (heightMode == MeasureSpec.AT_MOST) {
            @SuppressLint("DrawAllocation") Rect bounds = new Rect();
            //计算的宽度 与字体的长度有关 用画笔测量
            mPaint.getTextBounds(mText, 0, mText.length(), bounds);
            height = bounds.height()+getPaddingTop()+getPaddingBottom();

        }
        //设置宽高
        setMeasuredDimension(width, height);
    }

    /**
     * 用于绘制
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画文字
        //x是开始的位置
        //y是基线
        Paint.FontMetricsInt fontMetrics = mPaint.getFontMetricsInt();
        //底部到基线的位置
        int dy = (fontMetrics.bottom - fontMetrics.top)/2 - fontMetrics.bottom;
        //中心线
        int baseLine = getHeight()/2 + dy;
        canvas.drawText(mText, getPaddingLeft(), baseLine, mPaint);
    }

    /**
     * 处理用户客户交互的
     */
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 手指按下
                Log.e("TAG", "手指按下");
                break;
            case MotionEvent.ACTION_MOVE:
                // 手指移动
                Log.e("TAG", "手指移动");
                break;
            case MotionEvent.ACTION_UP:
                // 手指抬起
                Log.e("TAG", "手指抬起");
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

}
