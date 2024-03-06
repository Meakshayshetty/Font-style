package com.akshay.textstyle.activity

import android.content.ContentValues
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.akshay.textstyle.R
import com.akshay.textstyle.databinding.ActivityQuotesBinding
import com.akshay.textstyle.fragments.quote.BreakingBad
import com.akshay.textstyle.fragments.quote.GameOfThrones
import com.akshay.textstyle.fragments.quote.ZenQuoteList
import com.akshay.textstyle.utils.Network
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.material.tabs.TabLayout

class Quotes : AppCompatActivity() {

    private var binding: ActivityQuotesBinding? = null
    private var viewPager:ViewPager?= null
    private var tabLayout: TabLayout? = null

    private val adIntervalMillis = (1 * 60 * 1000).toLong()// 10 minutes in milliseconds

    private var mInterstitialAd: InterstitialAd? = null

    private val handler = Handler()

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

        handler.postDelayed(adRunnable, adIntervalMillis)

    }

    private val adRunnable = Runnable {
        loadAndShowInterstitialAd()
    }

    private fun loadAndShowInterstitialAd() {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            this@Quotes,
            getString(R.string.quote_interstitial_uniid),
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    adError.toString().let { Log.d(ContentValues.TAG, it) }
                    Log.d("not load", "error loading.")
                    mInterstitialAd = null
                    // Schedule the next ad to be shown after the interval
                    handler.postDelayed(adRunnable, (5 * 60 * 1000).toLong())
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.d("load", "ad loaded.")
                    mInterstitialAd = interstitialAd

                    mInterstitialAd?.fullScreenContentCallback =
                        object : FullScreenContentCallback() {
                            override fun onAdClicked() {
                                // Called when a click is recorded for an ad.
                                Log.d(ContentValues.TAG, "Ad was clicked.")
                            }

                            override fun onAdDismissedFullScreenContent() {
                                // Called when ad is dismissed.
                                Log.d(ContentValues.TAG, "Ad dismissed fullscreen content.")
                                mInterstitialAd = null
                                // Schedule the next ad to be shown after the interval
                                handler.postDelayed(adRunnable, (6 * 60 * 1000).toLong())
                            }

                            override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                                // Called when ad fails to show.
                                Log.e(ContentValues.TAG, "Ad failed to show fullscreen content.")
                                mInterstitialAd = null
                                // Schedule the next ad to be shown after the interval
                                handler.postDelayed(adRunnable, adIntervalMillis)
                            }

                            override fun onAdImpression() {
                                // Called when an impression is recorded for an ad.
                                Log.d(ContentValues.TAG, "Ad recorded an impression.")
                            }

                            override fun onAdShowedFullScreenContent() {
                                // Called when ad is shown.
                                Log.d(ContentValues.TAG, "Ad showed fullscreen content.")
                            }
                        }

                    // Show the interstitial ad when it's loaded
                    mInterstitialAd?.show(this@Quotes)
                }
            })
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

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(adRunnable)

    }
}