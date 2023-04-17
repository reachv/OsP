package com.example.osproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.osproject.Fragment.FriendsFragment
import com.example.osproject.Fragment.HomeFragment
import com.example.osproject.Fragment.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Declaration
        var fragmentManager = supportFragmentManager
        var bottomnav : BottomNavigationView = findViewById(R.id.Botnav)
        var fragment = Fragment()
        val homeFragment = HomeFragment()
        val settingsFragment = SettingsFragment()
        val friendsFragment = FriendsFragment()

        //Switch case to move Fragments
        bottomnav.setOnItemSelectedListener {
            if(it.itemId == R.id.home){
                fragment = homeFragment
            }else if(it.itemId == R.id.friends){
                fragment = friendsFragment
            }else if(it.itemId == R.id.settings){
                fragment = settingsFragment
            }
            fragmentManager.beginTransaction().replace(R.id.Container, fragment).commit()
            return@setOnItemSelectedListener true
        }

        //Default Fragment Case
        bottomnav.selectedItemId = R.id.home

    }

}