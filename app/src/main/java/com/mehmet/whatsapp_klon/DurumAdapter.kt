package com.mehmet.whatsapp_klon

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DurumAdapter (val mContex:Context,val list:List<Kisiler>)
    :RecyclerView.Adapter<DurumAdapter.nesneTutucu>(){

    inner class nesneTutucu(view: View):RecyclerView.ViewHolder(view){
        val resim:ImageView
        val kullanıcı_ad:TextView
        val tarih:TextView

        init {
            resim=view.findViewById(R.id.dresim)
            kullanıcı_ad=view.findViewById(R.id.dkullanici_ad)
            tarih=view.findViewById(R.id.dtarih)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): nesneTutucu {
        val tasarim=LayoutInflater.from(mContex).inflate(R.layout.durumcvtasarimi,parent,false)
        return nesneTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: nesneTutucu, position: Int) {
        val kisi=list[position]
        holder.kullanıcı_ad.text=kisi.kullanici_ad
        holder.tarih.text=kisi.tarih
        if(kisi.resim!=""){
            holder.resim.setImageResource(
                mContex.resources.getIdentifier(kisi.resim,"drawable",mContex.packageName))
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


}