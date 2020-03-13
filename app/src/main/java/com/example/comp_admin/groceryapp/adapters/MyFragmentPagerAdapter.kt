package com.example.comp_admin.groceryapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.comp_admin.groceryapp.fragments.ProductFragment
import com.example.comp_admin.groceryapp.models.SubCategory

class MyFragmentPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var myFragmentList = ArrayList<Fragment>()
    var myTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return myFragmentList.get(position)
    }

    override fun getCount(): Int {
        return myFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return myTitleList.get(position)
    }

    fun addFragment(subCategory: SubCategory) {
        myFragmentList.add(ProductFragment.newInstance(subCategory.subId))
        myTitleList.add(subCategory.subName)
    }
}