package com.stimednp.kadesubmission3.ui.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.stimednp.kadesubmission3.R
import com.stimednp.kadesubmission3.ui.xml.fragment.LastMatchFragment
import com.stimednp.kadesubmission3.ui.xml.fragment.NextMatchFragment

/**
 * Created by rivaldy on 11/13/2019.
 */

class ViewPagerAdapter(fm: FragmentManager, context: Context) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val strTab0 = context.getString(R.string.str_last_match)
    private val strTab1 = context.getString(R.string.str_next_match)
    private val pages = listOf(LastMatchFragment(), NextMatchFragment())

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> strTab0
            else -> strTab1
        }
    }
}