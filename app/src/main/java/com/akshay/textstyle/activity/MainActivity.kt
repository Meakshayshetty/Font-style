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
import com.akshay.textstyle.adapter.AlphabetAdapter
import com.akshay.textstyle.fragments.*
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private val tabIcons = intArrayOf(
        R.drawable.font,
        R.drawable.abc,
        R.drawable.star,
        R.drawable.maths,
        R.drawable.numbers,
        R.drawable.arrow,
        R.drawable.random_icons,
        R.drawable.wedding_arch,  //TODO: Change icon
        R.drawable.smile
    )
    private var tabLayout: TabLayout? = null
    private var clear_btn:ImageButton? =null
    private var main_text:TextView? =null
    private var edit_text:EditText? =null
    private var done_btn :ImageButton? =null
    private var copy_text:String?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tab()

        clear_btn = findViewById(R.id.imageButton_clear)
        main_text=findViewById(R.id.main_text)
        edit_text=findViewById(R.id.edit_text_main)
        done_btn= findViewById(R.id.mainBtn)


        with(clear_btn){
            this?.setOnClickListener {
                edit_text?.setText("")
                main_text?.text = ""
            }
        }

        done_btn?.setOnClickListener {
            with(main_text){
                copy_text = this?.text.toString()
                saveToClipboard(copy_text!!)
                Toast.makeText(this@MainActivity,"$copy_text saved",Toast.LENGTH_SHORT).show()
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
        adapter.addFrag(AlphabetFragment())
        adapter.addFrag(StarFragment())
        adapter.addFrag(MathSymbolFragment())
        adapter.addFrag(NumeralFragment())
        adapter.addFrag(ArrowFragment())
        adapter.addFrag(RandomIconFragment())
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

        fun addFrag(fragment: Fragment) {
            mFragmentList.add(fragment)
        }

      /*  override fun getPageTitle(position: Int): CharSequence {
            return mFragmentTitleList[position]
        }*/
    }
}