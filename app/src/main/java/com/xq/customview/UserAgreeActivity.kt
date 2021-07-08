package com.xq.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_user_agree.*

class UserAgreeActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_agree)

        val animation  = AnimationUtils.loadAnimation(this,R.anim.checkbox_shake)
        tv.startAnimation(animation)
        cb.startAnimation(animation)

    }
}