package com.example.color

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

enum class Page(val title: String, val fragmentClass : Class<out Fragment>) {
    DOG("Dogs", Fragment_Dogs::class.java),
    CAT("Cats", Fragment_Cats::class.java),
    BIRD("Birds", Fragment_Birds::class.java);
}

@Suppress("DEPRECATION")
class ViewPagerAdapter(fm: FragmentManager, behavior: Int) :
    FragmentStatePagerAdapter(fm, behavior) {

    private val pages: List<Page> = arrayListOf<Page>().apply {
        addAll(Page.values())
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getItem(position: Int): Fragment {
        return pages[position].fragmentClass.newInstance()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return pages[position].title
    }
}