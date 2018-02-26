package com.example.ismayil.burcrehberi2

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    var animBack:AnimationDrawable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)



        val anim = AnimationUtils.loadAnimation(this,R.anim.rotate)
        imageView.animation=anim

        animBack = constraint.background as AnimationDrawable
        animBack!!.run {
            setEnterFadeDuration(8000)
            setExitFadeDuration(2800)
        }

        Handler().postDelayed({
        startActivity(Intent(this,MainActivity::class.java))
        finish()
        },4000.toLong())

    }

    override fun onResume() {
        if (animBack != null && !animBack!!.isRunning)
            animBack!!.start()
        super.onResume()
    }

    override fun onPause() {
        if (animBack != null && animBack!!.isRunning)
            animBack!!.stop()
        super.onPause()
    }

}
