package com.akshay.textstyle.fragments

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshay.textstyle.R
import com.akshay.textstyle.adapter.AlphabetAdapter
import com.akshay.textstyle.adapter.ArrowAdapter

class AlphabetFragment : Fragment() {

    private val icons: ArrayList<String> = arrayListOf(
        "Ꭿ", "∀", "₳", "Ǻ", "ǻ", "α", "ά", "Ǡ", "Ắ", "ắ", "Ằ", "ằ", "ẳ", "Ẵ", "ẵ", "Ä", "ª", "ä", "Å",
        "À", "Á", "Â", "å", "ã", "â", "à", "á", "Ã", "ᗩ", "@", "Ⱥ", "Ǟ", "ℬ", "Ᏸ", "β", "฿", "ß", "Ђ",
        "ᗷ", "ᗽ", "ᗾ", "ᗿ", "Ɓ", "ƀ", "ხ", "␢", "Ᏸ", "ᗸ", "ᗹ", "ᛔ", "☾", "ℭ", "ℂ", "Ç", "¢", "ç", "Č",
        "ċ", "Ċ", "ĉ", "ς", "Ĉ", "ć", "Ć", "č", "Ḉ", "ḉ", "⊂", "Ꮸ", "₡", "¢", "Ⴚ", "ᗫ", "Ɗ", "Ď", "ď", "Đ",
        "đ", "ð", "∂", "₫", "ȡ", "ᚦ", "ᚧ", "ℰ", "ℯ", "ໂ", "६", "£", "Ē", "℮", "ē", "Ė", "ė", "Ę", "ě",
        "Ě", "ę", "Έ", "ê", "ξ", "Ê", "È", "€", "É", "∑", "Ế", "Ề", "Ể", "Ễ", "é", "è", "ع", "Є", "є", "έ",
        "ε", "Ҿ", "ҿ", "ℱ", "₣", "ƒ", "∮", "Ḟ", "ḟ", "ჶ", "ᶂ", "φ", "ᚨ", "ᚩ", "ᚪ", "ᚫ", "Ꮹ", "Ꮆ", "ℊ",
        "Ǥ", "ǥ", "Ĝ", "ĝ", "Ğ", "ğ", "Ġ", "ġ", "Ģ", "ģ", "פ", "ᶃ", "₲", "ℍ", "ℋ", "ℎ", "ℌ", "ℏ", "ዙ",
        "Ꮵ", "Ĥ", "Ħ", "ħ", "Ή", "廾", "Ћ", "ђ", "Ḩ", "Һ", "ḩ", "♄", "ਮ", "ℐ", "ί", "ι", "Ï", "Ί", "Î",
        "ì", "Ì", "í", "Í", "î", "ϊ", "ΐ", "Ĩ", "ĩ", "Ī", "ī", "Ĭ", "ĭ", "İ", "į","ჟ", "Ĵ", "ĵ", "ᶖ", "ɉ", "ℑ",
        "₭", "Ꮶ", "Ќ", "k", "ќ", "ķ", "Ķ", "Ҝ", "ҝ", "ᶄ", "Ҡ", "ҡ", "ℒ", "ℓ", "Ŀ", "ŀ", "Ĺ", "ĺ", "Ļ", "ļ", "λ",
        "₤", "Ł", "ł", "ľ", "Ľ", "Ḽ", "ḽ", "ȴ", "Ꮭ","ℳ", "ʍ", "ᶆ", "Ḿ", "ḿ", "ᗰ", "ᙢ", "爪", "₥", "ጠ", "ᛖ","ℕ",
        "η", "ñ", "ח", "Ñ", "ή", "ŋ", "Ŋ", "Ń", "ń", "Ņ", "ņ", "Ň", "ň", "ŉ", "ȵ", "ℵ", "₦", "ห", "ກ", "⋒", "Ӈ",
        "ӈ", "ℴ", "ტ", "٥", "Ό", "ó", "ό", "σ", "ǿ", "Ǿ", "Θ", "ò", "Ó", "Ò", "Ô", "ô","Ö", "ö", "Õ", "õ", "ờ", "ớ", "ọ",
        "Ọ", "ợ", "Ợ", "ø", "Ø", "Ό", "Ở", "Ờ", "Ớ", "Ổ", "ổ", "Ợ", "Ō", "ō", "Ő", "ő","ℙ", "℘", "ρ", "Ꭾ", "Ꮅ", "尸", "Ҏ",
        "ҏ", "ᶈ", "₱", "☧", "ᖘ", "ק", "₽", "թ", "Ƿ", "Ҏ", "ҏ",
        "ℚ", "q", "Q", "ᶐ", "Ǭ", "ǭ", "ჹ", "૧","ℝ", "ℜ", "ℛ", "℟", "ჩ", "ᖇ", "ř", "Ř", "ŗ", "Ŗ", "ŕ", "Ŕ", "ᶉ", "Ꮢ", "尺", "ᚱ",
        "Ꮥ", "Ṧ", "ṧ", "ȿ", "§", "Ś", "ś", "š", "Š", "ş", "Ş", "ŝ", "Ŝ", "₰", "∫", "$", "ֆ", "Տ", "క",
        "₸", "†", "T", "t", "τ", "Ţ", "ţ", "Ť", "ť", "ŧ", "Ŧ", "干", "Ṫ", "ṫ", "ナ", "Ꮏ", "Ꮖ", "テ", "₮", "⍡","∪", "ᙀ",
        "Ũ", "Ủ", "Ừ", "Ử", "Ữ", "Ự", "ύ", "ϋ", "Ù", "ú", "Ú", "ΰ", "ù", "Û", "û", "Ü", "ử", "ữ",
        "ự", "ü", "ừ", "Ũ", "ũ", "Ū", "ū", "Ŭ", "ŭ", "ų", "Ų", "ű", "Ű", "ů", "Ů", "น", "Ա","✓", "∨", "√", "Ꮙ",
        "Ṽ", "ṽ", "ᶌ", "℣","₩", "ẃ", "Ẃ", "ẁ", "Ẁ", "ẅ", "ώ", "ω", "ŵ", "Ŵ", "Ꮤ", "Ꮃ", "ฬ", "ᗯ", "ᙡ", "Ẅ",
        "ѡ", "ಎ", "ಭ", "Ꮚ", "Ꮗ", "ผ", "ฝ", "พ", "ฟ","χ", "×", "✗", "✘", "᙭", "ჯ", "Ẍ", "ẍ", "ᶍ", "א"
        ,"ɣ", "Ꭹ", "Ꮍ", "Ẏ", "ẏ", "ϒ", "ɤ", "￥", "ע", "௶", "Ⴘ", "ℤ", "乙", "Ẑ", "ẑ", "ɀ", "Ꮓ")

    private val context: Activity? = null
    private var mainText: TextView?= null
    private var edittext_main : EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_alphabet, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycle_view_alphabet)
        val layoutManager = GridLayoutManager(context, 4)
        recyclerView.layoutManager = layoutManager


        val adapter = AlphabetAdapter(icons) { selectedIcon ->
            // Handle the selected icon
            mainText = activity?.findViewById(R.id.main_text)
            edittext_main = activity?.findViewById(R.id.edit_text_main)
            mainText?.append(selectedIcon)
            edittext_main?.append(selectedIcon)
        }
        recyclerView.adapter = adapter
        return view
    }
}