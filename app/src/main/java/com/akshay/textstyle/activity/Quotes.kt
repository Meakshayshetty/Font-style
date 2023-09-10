package com.akshay.textstyle.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.akshay.textstyle.databinding.ActivityQuotesBinding
import com.akshay.textstyle.fragments.quote.BreakingBad
import com.akshay.textstyle.fragments.quote.GameOfThrones
import com.akshay.textstyle.fragments.quote.ZenQuoteList
import com.akshay.textstyle.utils.Network
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.material.tabs.TabLayout

class Quotes : AppCompatActivity() {


    private var binding: ActivityQuotesBinding? = null
    private var viewPager:ViewPager?= null
    private var tabLayout: TabLayout? = null

    private val tabNames = arrayListOf("Quote List","Breaking Bad","Game Of Thrones")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuotesBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        viewPager = binding?.viewpagerQuote
        tabLayout =  binding?.tabLayoutQuotes

        MobileAds.initialize(this)
        val request = AdRequest.Builder().build()
        binding!!.adViewQuotes.loadAd(request)
        tab()

        checkAndShowSnackbar()

    }
    private fun tab() {
        setupViewPager(viewPager!!)
        with(tabLayout) {
            setupViewPager(viewPager!!)
            this?.setupWithViewPager(viewPager)
        }
        setupTabIcons()
        with(tabLayout) {
            setupViewPager(viewPager!!)
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
        for (i in tabNames.indices) {
            tabLayout?.getTabAt(i)!!.text = tabNames[i]
        }
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFrag(ZenQuoteList())
        adapter.addFrag(BreakingBad())
        adapter.addFrag(GameOfThrones())
        viewPager.adapter = adapter
    }

    class ViewPagerAdapter(fm: androidx.fragment.app.FragmentManager) : FragmentPagerAdapter(fm) {
        private val mFragmentList = mutableListOf<Fragment>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFrag(fragment: Fragment) {
            mFragmentList.add(fragment)
        }
    }
    private fun checkAndShowSnackbar() {
        if (!Network.isNetworkAvailable(this)) {
            Network.showNoInternetSnackbar(
                binding!!.quoteRoot, // Replace with your root layout ID
                this
            )
        }
    }
}