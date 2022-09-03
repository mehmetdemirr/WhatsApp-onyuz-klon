package com.mehmet.whatsapp_klon

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class SohbetAdapter(private val mContext:Context,private val kisiler:List<Kisiler>)
    :RecyclerView.Adapter<SohbetAdapter.cvnesneTutucu>(){

    inner class cvnesneTutucu(view: View):RecyclerView.ViewHolder(view){
        val cardview:CardView
        val kullanici_resim:ImageView
        val son_mesaj_tarihi:TextView
        val son_mesaj:TextView
        val kullanici_ad:TextView

        init {
            cardview=view.findViewById(R.id.cardView)
            kullanici_ad=view.findViewById(R.id.dkullanici_ad)
            son_mesaj_tarihi=view.findViewById(R.id.son_mesaj_tarihi)
            son_mesaj=view.findViewById(R.id.son_mesaj)
            kullanici_resim=view.findViewById(R.id.kullanici_resim)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cvnesneTutucu {
        val tasarim=LayoutInflater.from(mContext).inflate(R.layout.cardviewtasarimi,parent,false)
        return cvnesneTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: cvnesneTutucu, position: Int) {
        val kisi=kisiler[position]
        holder.kullanici_ad.text=kisi.kullanici_ad
        holder.son_mesaj.text=kisi.son_mesaj
        holder.son_mesaj_tarihi.text=kisi.tarih
       if(kisi.resim!=""){
           holder.kullanici_resim.setImageResource(
               mContext.resources.getIdentifier(kisi.resim,"drawable",mContext.packageName))
       }
    }

    override fun getItemCount(): Int {
       return kisiler.size
    }

}