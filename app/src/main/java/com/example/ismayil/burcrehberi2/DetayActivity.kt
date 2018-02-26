package com.example.ismayil.burcrehberi2

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.graphics.Palette
import kotlinx.android.synthetic.main.activity_detay.*





class DetayActivity : AppCompatActivity() {

    var anim:AnimationDrawable? = null
    lateinit var trans:TransitionDrawable

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        val position = intent.extras["pos"] as Int
        val arrayInfoZodiac = intent.extras["array"] as ArrayList<Burc>

        tvBurcOzellikleri.text = arrayInfoZodiac[position].burcGenelOzellikleri
        header.setImageResource(arrayInfoZodiac[position].burcBuyukResim)

        setSupportActionBar(anim_toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        collapsing_toolbar.title = arrayInfoZodiac[position].burcAdi
        val bitmap = BitmapFactory.decodeResource(resources,arrayInfoZodiac[position].burcBuyukResim)
        Palette.from(bitmap).generate { palette ->
            val color = palette?.getVibrantColor(R.attr.colorAccent)
            collapsing_toolbar.setContentScrimColor(color!!)
            window.statusBarColor=color
            tvBurcOzellikleri.setTextColor(color)
        }




        //anim = linearLayout!!.background as AnimationDrawable?
        //anim?.setEnterFadeDuration(5000)
        //anim?.setExitFadeDuration(2000)

        trans = linearLayout.background as TransitionDrawable
        trans.startTransition(1500)


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onResume() {
        super.onResume()
        if (anim != null && !anim!!.isRunning)
            anim!!.start()
    }

    override fun onPause() {
        super.onPause()
        if (anim != null && anim!!.isRunning)
            anim!!.stop()
    }

}
