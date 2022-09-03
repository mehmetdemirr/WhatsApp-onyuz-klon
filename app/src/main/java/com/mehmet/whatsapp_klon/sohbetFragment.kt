package com.mehmet.whatsapp_klon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_sohbet.*
import kotlinx.android.synthetic.main.fragment_sohbet.view.*

class sohbetFragment : Fragment() {
    public lateinit var kisiler: ArrayList<Kisiler>
    public lateinit var adapterr: SohbetAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val tasarim=inflater.inflate(R.layout.fragment_sohbet, container, false)

        kisiler= ArrayList<Kisiler>()
        val k1=Kisiler("Mehmet Demir","mehmet","Merhaba","23.04.2022",1)
        val k2=Kisiler("Ahmet","","Merhaba","23.04.2022",1)
        val k3=Kisiler("Yasin","","Merhaba","23.04.2022",2)
        val k4=Kisiler("Abdullah","","Merhaba","23.04.2022",2)
        val k5=Kisiler("Taha","","Merhaba","23.04.2022",2)
        val k6=Kisiler("Mustafa","","Merhaba","23.04.2022",1)
        val k7=Kisiler("Abdüssamed","","Merhaba","23.04.2022",1)
        val k8=Kisiler("Yusuf","","Merhaba","23.04.2022",1)
        val k9=Kisiler("Şahin","","Merhaba","23.04.2022",2)
        val k0=Kisiler("Müslüm","","Merhaba","23.04.2022",2)
        kisiler.add(k1)
        kisiler.add(k2)
        kisiler.add(k3)
        kisiler.add(k4)
        kisiler.add(k5)
        kisiler.add(k6)
        kisiler.add(k7)
        kisiler.add(k8)
        kisiler.add(k9)
        kisiler.add(k0)

        tasarim.rv.setHasFixedSize(true)
        tasarim.rv.layoutManager=LinearLayoutManager(requireContext())

        adapterr= SohbetAdapter(requireContext(),kisiler)
        tasarim.rv.adapter=adapterr


        return tasarim
    }

}