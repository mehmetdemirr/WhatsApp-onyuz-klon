package com.mehmet.whatsapp_klon

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.TableLayout
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    private val FragmentListesi=ArrayList<Fragment>()
    private val FragmentBaslikListesi=ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title="WhatsApp"
        toolbar.setBackgroundColor(Color.rgb(7,94,84))
        setSupportActionBar(toolbar)

        FragmentListesi.add(sohbetFragment())
        FragmentListesi.add(durumFragment())
        FragmentListesi.add(aramaFragment())

        FragmentBaslikListesi.add("SOHBETLER")
        FragmentBaslikListesi.add("DURUM")
        FragmentBaslikListesi.add("ARAMALAR")

        val adapter=MyViewPageAdapter(this)
        vievpager2.adapter=adapter

        TabLayoutMediator(tabLayout,vievpager2){ tab: TabLayout.Tab, i: Int ->
            tab.setText(FragmentBaslikListesi[i])
        }.attach()

        //tabLayout.getTabAt(0)!!.setIcon(R.drawable.resim_kamera)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }

    inner class MyViewPageAdapter(fragmentactivity:FragmentActivity):FragmentStateAdapter(fragmentactivity){
        override fun getItemCount(): Int {
            return FragmentListesi.count()
        }

        override fun createFragment(position: Int): Fragment {
            return FragmentListesi[position]
        }

    }

}