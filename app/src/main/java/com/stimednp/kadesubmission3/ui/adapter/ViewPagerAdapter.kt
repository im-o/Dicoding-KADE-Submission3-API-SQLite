package com.stimednp.kadesubmission3.ui.adapter

import android.content.Context
import android.util.Log.e
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.stimednp.kadesubmission3.R
import com.stimednp.kadesubmission3.ui.xml.fragment.LastMatchFragment
import com.stimednp.kadesubmission3.ui.xml.fragment.NextMatchFragment

/**
 * Created by rivaldy on 11/13/2019.
 */

class ViewPagerAdapter(val context: Context, val listStr: List<Int>, val listFrag: List<Fragment>, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return listFrag[position]
    }

    override fun getCount(): Int {
        return listFrag.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.getString(listStr[position])
    }

}