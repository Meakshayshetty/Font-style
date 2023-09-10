package com.akshay.textstyle.fragments.main_activity

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshay.textstyle.R
import com.akshay.textstyle.adapter.FontAdapter
import com.akshay.textstyle.model.Font

class FontFragment : Fragment() {
    private var context: Activity? = null
    private var fontsRV: RecyclerView? = null
    private val fontsItems: ArrayList<Font> = ArrayList<Font>()
    private var editText: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_font, container, false)

        if (fontsItems.isEmpty()) {
            repeat(89) {
                fontsItems.add(Font())
            }
        } else {
            fontsItems.clear()
            repeat(89) {
                fontsItems.add(Font())
            }
        }

        fontsRV = view.findViewById(R.id.recycle_view_FF)
        val adapter = FontAdapter(fontsItems, requireContext() as Activity)
        with(fontsRV) {
            this?.layoutManager = LinearLayoutManager(context)
            this?.setAdapter(adapter)
        }
        editText = activity?.findViewById(R.id.edit_text_main)
        with(editText) {
            this?.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable) {}
                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    //var editTextStr = text.toString()

                    updateDecorationFonts(s.toString())
                    adapter.notifyDataSetChanged()
                }
            })
            updateDecorationFonts(editText?.text.toString())
            adapter.notifyDataSetChanged()
        }
        return view
    }

    private fun updateDecorationFonts(text: String) {
        var editTextStr = text
        if (editTextStr.isEmpty()) {
            editTextStr = "hello"
        }
        for (item in fontsItems.indices) {
            fontsItems[item].setPreviewText(editTextStr)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(requireContext())
        this.context = context as Activity?
    }
}