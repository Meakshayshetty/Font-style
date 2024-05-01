package com.akshay.textstyle.fragments.main_activity

import android.annotation.SuppressLint
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
import com.akshay.textstyle.adapter.DecorationAdapter
import com.akshay.textstyle.model.Font


@Suppress("UNREACHABLE_CODE")
class DecorationFragment : Fragment() {

    private var context: Activity? = null
    private var fontsRV: RecyclerView? = null
    private val decorationFonts: ArrayList<Font> = ArrayList()
    private var editText: EditText? = null

    @SuppressLint("UseRequireInsteadOfGet", "NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_decoration, container, false)

        if (decorationFonts.isEmpty()) {
            repeat(99) {
                decorationFonts.add(Font())
            }
        } else {
            decorationFonts.clear()
            repeat(99) {
                decorationFonts.add(Font())
            }
        }
        fontsRV = view.findViewById(R.id.recycle_view_DF)

        val adapter = DecorationAdapter(decorationFonts, context)
        with(fontsRV){
            this?.layoutManager = LinearLayoutManager(context)
            this?.adapter = adapter
        }

        editText = activity?.findViewById(R.id.edit_text_main)
        with(editText){
            this?.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable) {}
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    //var editTextStr =text.toString()
                    updateDecorationFonts(s.toString())
                    adapter.notifyDataSetChanged()
                }
            })
            updateDecorationFonts(editText?.text.toString())
            adapter.notifyDataSetChanged()
        }
        return view
    }

    private fun updateDecorationFonts(text:String) {
        var editTextStr = text
        if (editTextStr.isEmpty()) {
            editTextStr= "hey!"
        }
        for (item in decorationFonts.indices) {
            decorationFonts[item].setPreviewText(editTextStr)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(requireContext())
        this.context = context as Activity?
    }
}