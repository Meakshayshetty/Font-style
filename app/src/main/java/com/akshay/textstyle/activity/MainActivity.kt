@file:Suppress("DEPRECATION")

package com.akshay.textstyle.activity

import android.content.ClipData
import android.content.ClipboardManager
import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.akshay.textstyle.R
import com.akshay.textstyle.databinding.ActivityMainBinding
import com.akshay.textstyle.fragments.*
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private val tabIcons = intArrayOf(
        R.drawable.font_icon,
        R.drawable.decoration_icon,
        R.drawable.emote_icon,
        R.drawable.alphabet_icon,
        R.drawable.star_icon,
        R.drawable.maths_icons,
        R.drawable.number_icon,
        R.drawable.arrow_icon,
        R.drawable.random_icon,
    )
    private lateinit var tabLayout:TabLayout
    private lateinit var editText :EditText
    private lateinit var mainText:TextView

    private var mInterstitialAd: InterstitialAd? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this)

        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)


        InterstitialAd.load(this@MainActivity,
            getString(R.string.mainScreen_interstitial_ad_unitId),
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    adError.toString().let { Log.d(ContentValues.TAG, it) }
                    Log.d("not load", "error loading.")

                    mInterstitialAd = null
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
                            }

                            override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                                // Called when ad fails to show.
                                Log.e(ContentValues.TAG, "Ad failed to show fullscreen content.")
                                mInterstitialAd = null
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
                }
            })

        tabLayout = binding.tabLayout
        editText =binding.editTextMain
        mainText = binding.mainText
        tab()
        
        binding.imageButtonClear.setOnClickListener {
            editText.setText("")
            mainText.text = ""
        }

        binding.mainBtn.setOnClickListener {
            showInterstitialAdDelayed()
            val copyText = binding.mainText.text.toString()
            saveToClipboard(copyText)
        }
    }

    private fun showInterstitialAdDelayed() {
        val delayMillis = 1000L // Delay between each check in milliseconds
        val maxAttempts = 10 // Maximum number of attempts

        var currentAttempt = 0

        val runnable = object : Runnable {
            override fun run() {
                if (mInterstitialAd != null) {
                    mInterstitialAd?.show(this@MainActivity)
                } else {
                    currentAttempt++
                    if (currentAttempt <= maxAttempts) {
                        Handler().postDelayed(this, delayMillis)
                    } else {
                        Log.e("error", "ad null")
                    }
                }
            }
        }

        Handler().postDelayed(runnable, delayMillis)
    }

    private fun saveToClipboard(desStr: String) {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("simple text", desStr)
        clipboard.setPrimaryClip(clip)

        Toast.makeText(this,
            "$desStr Copied to clipboard!",
            Toast.LENGTH_SHORT).show()
    }

    private fun tab() {
        val viewPager: ViewPager = findViewById(R.id.viewPager)
        setupViewPager(viewPager)
        with(tabLayout) {
            setupViewPager(viewPager)
            this.setupWithViewPager(viewPager)
        }
        setupTabIcons()
        with(tabLayout) {
            setupViewPager(viewPager)
            // tabLayout = findViewById(R.id.tabLayout)
            this.setupWithViewPager(viewPager)
            setupTabIcons()

            this.addOnTabSelectedListener(object :
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
            tabLayout.getTabAt(i)!!.setIcon(tabIcons[i])
        }
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFrag(FontFragment())
        adapter.addFrag(DecorationFragment())
        adapter.addFrag(EmoticonFragment())
        adapter.addFrag(AlphabetFragment())
        adapter.addFrag(StarFragment())
        adapter.addFrag(MathSymbolFragment())
        adapter.addFrag(NumeralFragment())
        adapter.addFrag(ArrowFragment())
        adapter.addFrag(RandomIconFragment())
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

        fun addFrag(fragment: Fragment) {
            mFragmentList.add(fragment)
        }
    }
}