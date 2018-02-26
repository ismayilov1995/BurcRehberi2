package com.example.ismayil.burcrehberi2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var butunBurcBilgileri:ArrayList<Burc>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataResources()
        val intent = Intent(this,DetayActivity::class.java)
        val myBaseAdapter = BasedAdaptor(this,butunBurcBilgileri)
        listView.adapter=myBaseAdapter
        listView.setOnItemClickListener { adapterView, view, i, l ->
            intent.putExtra("pos",i)
            intent.putExtra("array",butunBurcBilgileri)
            startActivity(intent)
        }





    }

    private fun dataResources() {
        butunBurcBilgileri=ArrayList(13)
        val burclar = resources.getStringArray(R.array.burclar)
        val burcTarihleri = resources.getStringArray(R.array.burcTarih)
        val burcResimleri = arrayOf(R.drawable.koc1, R.drawable.boga2, R.drawable.ikizler3, R.drawable.yengec4, R.drawable.aslan5, R.drawable.basak6,
                R.drawable.terazi7, R.drawable.akrep8, R.drawable.yay9, R.drawable.oglak10, R.drawable.kova11, R.drawable.balik12)
        val burcBuyukResimleri = arrayOf(R.drawable.koc_buyuk1, R.drawable.boga_buyuk2, R.drawable.ikizler_buyuk3,
                R.drawable.yengec_buyuk4, R.drawable.aslan_buyuk5, R.drawable.basak_buyuk6,
                R.drawable.terazi_buyuk7, R.drawable.akrep_buyuk8, R.drawable.yay_buyuk9, R.drawable.oglak_buyuk10, R.drawable.kova_buyuk11, R.drawable.balik_buyuk12)
        val burcGenelOzellikler=resources.getStringArray(R.array.burcGenelOzellikler)
        val burcCins = resources.getStringArray(R.array.burcGroup)

        (0..11)
                .map { Burc(burclar[it],burcTarihleri[it],burcResimleri[it],burcBuyukResimleri[it],burcGenelOzellikler[it],burcCins[it]) }
                .forEach { butunBurcBilgileri.add(it) }

    }
}
