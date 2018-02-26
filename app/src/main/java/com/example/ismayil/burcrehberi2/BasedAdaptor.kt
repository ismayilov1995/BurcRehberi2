package com.example.ismayil.burcrehberi2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.each_list_view.view.*

/**
 * Created by ismayil on 2/25/2018.
 */
class BasedAdaptor(givenContext:Context, allDetailsOfZodiac:ArrayList<Burc>): BaseAdapter() {
    private var allZodiac:ArrayList<Burc> = allDetailsOfZodiac
    private var context:Context = givenContext

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? {
        var eachListView = p1
        val viewHolder:ViewHolder

        if (eachListView == null){
            val inflater = LayoutInflater.from(context)
            eachListView = inflater.inflate(R.layout.each_list_view,p2,false)

            viewHolder= ViewHolder(eachListView)
            eachListView.tag=viewHolder
        }else{
            viewHolder=eachListView.tag as ViewHolder
        }
        viewHolder.zodiacImg.setImageResource(allZodiac[p0].burcSembol)
        viewHolder.zodiacName.text = allZodiac[p0].burcAdi
        viewHolder.zodiacInfo.text = allZodiac[p0].burcTarih
        viewHolder.zodiacGroup.text = allZodiac[p0].burcCins
        return eachListView
    }
    override fun getItem(p0: Int): Any {
        return allZodiac[p0]
    }
    override fun getItemId(p0: Int): Long {
       return 0
    }
    override fun getCount(): Int {
        return allZodiac.size
    }
}
class ViewHolder(eachListView:View){
    var zodiacImg:ImageView = eachListView.imgBurcSembol
    var zodiacName:TextView = eachListView.tvBurcAdi
    var zodiacInfo:TextView = eachListView.tvBurcTarihi
    var zodiacGroup:TextView = eachListView.tvBurcCinsi

}