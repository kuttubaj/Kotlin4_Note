package com.example.kotlin4_not.presentation.ui.fragments.onboard

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.noteapp.ui.fragments.onboard.OnBoardPageFirst


class OnBoardAdapter(private val fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnBoardPageFirst()
            1 -> OnBoardPageSecond()
            else -> OnBoardPageThird()
        }
    }
}