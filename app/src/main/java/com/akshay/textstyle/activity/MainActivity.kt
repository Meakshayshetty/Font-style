@file:Suppress("DEPRECATION")

package com.akshay.textstyle.activity

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.akshay.textstyle.R
import com.akshay.textstyle.fragments.*
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
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
        R.drawable.random_icon,)

    private var tabLayout: TabLayout? = null
    private var clearBtn:ImageButton? =null
    private var mainText:TextView? =null
    private var editText:EditText? =null
    private var doneBtn :ImageButton? =null
    private var copyText:String?= null

    private lateinit var adView :AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adView = findViewById(R.id.adView)

        MobileAds.initialize(this)

        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)


        tab()
        clearBtn = findViewById(R.id.imageButton_clear)
        mainText=findViewById(R.id.main_text)
        editText=findViewById(R.id.edit_text_main)
        doneBtn= findViewById(R.id.mainBtn)


        with(clearBtn){
            this?.setOnClickListener {
                editText?.setText("")
                mainText?.text = ""
            }
        }

        doneBtn?.setOnClickListener {
            with(mainText){
                copyText = this?.text.toString()
                saveToClipboard(copyText!!)
                //Toast.makeText(this@MainActivity,"$copy_text saved",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveToClipboard(desStr:String){
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

      /*  override fun getPageTitle(position: Int): CharSequence {
            return mFragmentTitleList[position]
        }*/
    }
}