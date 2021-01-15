package com.bhumika.softuser_week6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import FRagment.UploadFragment
import FRagment.ViewFragment
import FRagment.WebFragment
import model.add

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation : BottomNavigationView = findViewById(R.id.dropdown)
        val home = ViewFragment()
        val upload = UploadFragment()
        val about = WebFragment()
        add()
        DisplaythisasCurrentFragment(home)

        navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home-> DisplaythisasCurrentFragment(home)
                R.id.upload -> DisplaythisasCurrentFragment(upload)
                R.id.about -> DisplaythisasCurrentFragment(about)
            }
            true
        }
    }

    private fun DisplaythisasCurrentFragment(FRagment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.viewpager, FRagment)
            addToBackStack(null)
            commit()
        }
}