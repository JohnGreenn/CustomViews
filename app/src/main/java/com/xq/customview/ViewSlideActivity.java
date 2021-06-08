package com.xq.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.animation.AnimationUtils;

import com.xq.customview.view.CustomView;

public class ViewSlideActivity extends AppCompatActivity {

    private CustomView mCustomView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_slide);
        mCustomView = (CustomView) this.findViewById(R.id.customview);
        //使用属性动画使view滑动
        //ObjectAnimator.ofFloat(mCustomView,"translationX",0,500).setDuration(2000).start();

        //使用AnimatorSet 组合动画
//        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mCustomView,"translationX",0.0f,200.0f,0f);
//        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mCustomView,"scaleX",1.0f,2.0f);
//        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mCustomView,"rotationX",0.0f,90.0f,0.0f);
//        AnimatorSet set = new AnimatorSet();
//        set.setDuration(1000);
//        set.play(animator1).with(animator2).after(animator3);
//        set.start();

        //在xml中使用属性动画
        Animator animator = AnimatorInflater.loadAnimator(this,R.animator.scale);
        animator.setTarget(mCustomView);
        animator.start();

        //使用View动画使view滑动
        //mCustomView.setAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));

        //使用Scroll来进行平滑移动
        //mCustomView.smoothScrollTo(-400,-400);

        
    }
}
