package com.mehmet.whatsapp_klon

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class AramaAdapter(val mContex:Context,val list:List<Kisiler>)
    :RecyclerView.Adapter<AramaAdapter.nesneTutucu>(){

    inner class nesneTutucu(view:View):RecyclerView.ViewHolder(view){
        val aresim:ImageView
        val akullanici_ad:TextView
        val atarih:TextView
        val sonArama:ImageView

        init {
            akullanici_ad=view.findViewById(R.id.akullanici_ad)
            atarih=view.findViewById(R.id.atarih)
            sonArama=view.findViewById(R.id.sonArama)
            aresim=view.findViewById(R.id.aresim)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): nesneTutucu {
        val tasarim=LayoutInflater.from(mContex).inflate(R.layout.aramacvtasarimi,parent,false)
        return nesneTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: nesneTutucu, position: Int) {
        val kisi=list[position]
        if(kisi.resim!=""){
            holder.aresim.setImageResource(
                mContex.resources.getIdentifier(kisi.resim,"drawable",mContex.packageName))
        }
        if(kisi.son_arama==1){
            holder.sonArama.setImageResource(
                mContex.resources.getIdentifier("resim_sesliara","drawable",mContex.packageName))
        }
        else if(kisi.son_arama==2){
            holder.sonArama.setImageResource(
                mContex.resources.getIdentifier("resim_goruntuluara","drawable",mContex.packageName))
        }
        holder.atarih.text=kisi.tarih
        holder.akullanici_ad.text=kisi.kullanici_ad
    }

    override fun getItemCount(): Int {
        return list.size
    }


}