package com.xq.customview.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc：
 * author：Christiano
 * gitee:
 * time：2021/05/28 15:04
 */
public class TagLayout extends ViewGroup {

    List<Rect> childrenBounds = new ArrayList<>();

    public TagLayout(Context context,AttributeSet attrs) {
        super(context,attrs);
    }

    //获取每个view的尺寸
    @Override
    protected void onMeasure(int widthMeasureSpec,int heightMeasureSpec) {
        int widthUsed = 0; //使用过的宽度
        int heightUsed = 0;//使用过的高度
        int lineHeight = 0; //每行的最高高度
        int lineWidthUsed = 0;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        //int specWidth = MeasureSpec.getSize(widthMeasureSpec);//我的宽度
        for(int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            measureChildWithMargins(child,widthMeasureSpec,0,heightMeasureSpec,heightUsed);
            //判断是否超出宽度
            if(widthMode != MeasureSpec.UNSPECIFIED && lineWidthUsed + child.getMeasuredWidth() > widthSize){
                lineWidthUsed = 0;
                heightUsed += lineHeight;//往下挪一行
                //重新测量
                measureChildWithMargins(child,widthMeasureSpec,0,heightMeasureSpec,heightUsed);
            }
            Rect childBounds;
            if (childrenBounds.size() <= i) {
                childBounds = new Rect();
                childrenBounds.add(childBounds);
            } else {
                childBounds = childrenBounds.get(i);
            }
            childBounds.set(lineWidthUsed, heightUsed, lineWidthUsed + child.getMeasuredWidth(),
                    heightUsed + child.getMeasuredHeight());

            lineWidthUsed += child.getMeasuredWidth();
            widthUsed = Math.max(lineWidthUsed, widthUsed);
            lineHeight = Math.max(lineHeight, child.getMeasuredHeight());
        }

        int measuredWidth = widthUsed;
        heightUsed += lineHeight;
        int measuredHeight = heightUsed;
        setMeasuredDimension(measuredWidth, measuredHeight);

    }

    @Override
    protected void onLayout(boolean changed,int l,int t,int r,int b) {

        //遍历子view
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            Rect childBounds = childrenBounds.get(i);
            child.layout(childBounds.left, childBounds.top, childBounds.right, childBounds.bottom);
        }
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }
}
