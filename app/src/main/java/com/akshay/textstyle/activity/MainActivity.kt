package com.akshay.textstyle.activity

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.akshay.textstyle.R
import com.akshay.textstyle.fragments.DecorationFragment
import com.akshay.textstyle.fragments.EmoticonFragment
import com.akshay.textstyle.fragments.FontFragment
import com.akshay.textstyle.fragments.StarFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private val tabIcons = intArrayOf(
        R.drawable.font,
        R.drawable.star,
        R.drawable.wedding_arch,  //TODO: Change icon
        R.drawable.smile
    )
    private var tabLayout: TabLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tab()
    }

    fun tab() {
        val viewPager: ViewPager = findViewById(R.id.viewPager)
        setupViewPager(viewPager)
        tabLayout = findViewById(R.id.tabLayout)
        with(tabLayout) {
            setupViewPager(viewPager)
            //tabLayout = findViewById(R.id.tabLayout)
            this?.setupWithViewPager(viewPager)
        }
        setupTabIcons()
        with(tabLayout) {
            setupViewPager(viewPager)
           // tabLayout = findViewById(R.id.tabLayout)
            this?.setupWithViewPager(viewPager)
            setupTabIcons()

            this?.addOnTabSelectedListener(object :
                TabLayout.ViewPagerOnTabSelectedListener(viewPager) {

                override fun onTabUnselected(tab: TabLayout.Tab) {
                    super.onTabUnselected(tab)
                    //            val tabIconColor = ContextCompat.getColor(this@MainActivity, R.color.tabUnselectedIconColor)
                    //            assert tab.icon != null
                    //            tab.icon!!.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
                }
            })
        }
    }

    private fun setupTabIcons() {
        for (i in tabIcons.indices) {
            tabLayout!!.getTabAt(i)!!.setIcon(tabIcons[i])
        }
    }

    fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFrag(FontFragment())
        adapter.addFrag(StarFragment())
        adapter.addFrag(DecorationFragment())
        adapter.addFrag(EmoticonFragment())
        viewPager.adapter = adapter
    }

    class ViewPagerAdapter(supportFragmentManager: FragmentManager) :
        FragmentPagerAdapter(supportFragmentManager) {
        private val mFragmentList = mutableListOf<Fragment>()
       // private val mFragmentTitleList = mutableListOf<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFrag(fragment: Fragment, /*title: String*/) {
            mFragmentList.add(fragment)
           // mFragmentTitleList.add(title)
        }

      /*  override fun getPageTitle(position: Int): CharSequence {
            return mFragmentTitleList[position]
        }*/
    }
}