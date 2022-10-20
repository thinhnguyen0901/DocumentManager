package com.example.viewpager

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpager.models.Document
import com.example.viewpager.ui.DocumentListener
import com.example.viewpager.ui.man1.Man1Fragment
import com.example.viewpager.ui.man2.Man2Fragment

class MyViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {


    override fun getItemCount(): Int = 2


    override fun createFragment(position: Int): Fragment =
        if (position == 0) {
            Man1Fragment.newInstance()
        } else {
            Man2Fragment.newInstance()
        }



}




