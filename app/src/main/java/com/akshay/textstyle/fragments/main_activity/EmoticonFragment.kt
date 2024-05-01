package com.akshay.textstyle.fragments.main_activity

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.akshay.textstyle.R
import com.akshay.textstyle.adapter.CustomAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

@Suppress("UNREACHABLE_CODE")
class EmoticonFragment : Fragment() {

    private var context: Activity? = null
    private val emoticonFonts = ArrayList<String>()
    private var editText:EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_emoticon, container, false)

        val listView = view.findViewById<ListView>(R.id.list_view_EF)
        if (emoticonFonts.isEmpty()) {
            emoticonFonts.add("★LOVE EMOTICONS★")
            emoticonFonts.add("★~(◠‿◕✿)")
            emoticonFonts.add("乂❤‿❤乂")
            emoticonFonts.add("༼♥ل͜♥༽")
            emoticonFonts.add("ლζ*♡ε♡*ζლ")
            emoticonFonts.add("⊂（❤⌂❤）⊃")
            emoticonFonts.add("٩(*❛⊰❛)ʓਡ～❤")
            emoticonFonts.add("♥╣[-_-]╠♥")
            emoticonFonts.add("( ･_･)♡")
            emoticonFonts.add("(●'◡'●)ﾉ♥")
            emoticonFonts.add("(* ˘⌣˘)◞[_]❤[_]ヽ(•‿• )")
            emoticonFonts.add("( ＾◡＾)っ✂❤")
            emoticonFonts.add("(Ɔ ˘⌣˘)♥(˘⌣˘ C) ")
            emoticonFonts.add("(乂ღ˘⌣˘)ノ❤ヽ(ˆ⌣ˆ)ヾ")
            emoticonFonts.add("(ღ˘⌣˘)♥ ℒ♡ⓥℯ ㄚ♡ⓤ")
            emoticonFonts.add("▂▃▄▅▆▇█▓▒░LoveYou░▒▓█▇▆▅▄▃▂")
            emoticonFonts.add("(。♡‿♡。)")
            emoticonFonts.add("♡o。.(✿ฺ。✿ฺ)")
            emoticonFonts.add("♡＾▽＾♡")
            emoticonFonts.add("(ღ˘⌣˘ღ)")
            emoticonFonts.add("웃❤유")
            emoticonFonts.add("{❤‿❤}")
            emoticonFonts.add("[̲̅ə̲̅٨̲̅٥̲̅٦̲̅]")
            emoticonFonts.add("┣┓웃┏♨❤♨┑유┏┥")
            emoticonFonts.add("(Ɔ ˘⌣˘)˘⌣˘ C) ")
            emoticonFonts.add("✨Lᵒᵛᵉᵧₒᵤ")
            emoticonFonts.add("★HAPPY EMOTICONS★")
            emoticonFonts.add("✿◕ ‿ ◕✿")
            emoticonFonts.add("೭੧(❛▿❛✿)੭೨")
            emoticonFonts.add("◎[▪‿▪]◎")
            emoticonFonts.add("☆(❁‿❁)☆")
            emoticonFonts.add("(✿◠‿◠) ")
            emoticonFonts.add("°˖✧◝(⁰▿⁰)◜✧˖°")
            emoticonFonts.add("≧◉◡◉≦")
            emoticonFonts.add("≧◠‿◠≦")
            emoticonFonts.add("٩(˘◡˘)۶")
            emoticonFonts.add("(✿ꈍ。 ꈍ✿)")
            emoticonFonts.add("( ๑ ᴖ ᴈ ᴖ)ᴖ ᴑ ᴖ๑)❣")
            emoticonFonts.add("( ͡° ͜ʖ ͡°)")
            emoticonFonts.add("┑(￣▽￣)┍")
            emoticonFonts.add("(❁´◡`❁)")
            emoticonFonts.add("(●⌒∇⌒●)")
            emoticonFonts.add("ಥ‿ಥ")
            emoticonFonts.add("(◕‿◕)")
            emoticonFonts.add("≖‿≖")
            emoticonFonts.add("(◠‿◠)")
            emoticonFonts.add("（⌒▽⌒）")
            emoticonFonts.add("(•ิ‿•ิ)")
            emoticonFonts.add("ʘ‿ʘ")
            emoticonFonts.add("o(∩_∩)o")
            emoticonFonts.add("ლ(╹◡╹ლ)")
            emoticonFonts.add("★MUSIC EMOTICONS★")
            emoticonFonts.add("♪(๑ᴖ◡ᴖ๑)♪")
            emoticonFonts.add("|̲̅̅●̲̅̅|̲̅̅=̲̅̅|̲̅̅●̲̅̅|")
            emoticonFonts.add("♫♪.ılılıll|̲̅̅●̲̅̅|̲̅̅=̲̅̅|̲̅̅●̲̅̅|llılılı.♫♪")
            emoticonFonts.add("Ϛ⃘๑•͡ .̫•๑꒜♬♫")
            emoticonFonts.add("(ღ˘⌣˘ღ) ♫･*:.｡. .｡.:*･")
            emoticonFonts.add("♪♪ｖ(⌒ｏ⌒)ｖ♪♪")
            emoticonFonts.add("♬♫♪◖(●。●)◗♪♫♬")
            emoticonFonts.add("♪٩(✿′ᗜ‵✿)۶♪")
            emoticonFonts.add("♬♩♫♪☻(●´∀｀●)☻♪♫♩♬")
            emoticonFonts.add("♬♪♫ ヾ(*・。・)ﾉ ♬♪♫")
            emoticonFonts.add("٩(ó｡ò۶ ♡)))♬")
            emoticonFonts.add("♪~♪ d(⌒o⌒)b♪~♪")
            emoticonFonts.add("♪♪(o*゜∇゜)o～♪♪")
            emoticonFonts.add("✌♫♪˙❤‿❤˙♫♪✌")
            emoticonFonts.add("(◦′ᆺ‵◦) ♬° ✧❥✧¸.•*¨*✧♡✧ ℒℴѵℯ ✧♡✧*¨*•.❥")
            emoticonFonts.add("✿♬ﾟ+.(｡◡‿◡)♪.+ﾟ♬✿。")
            emoticonFonts.add("♪ヽ( ⌒o⌒)人(⌒-⌒ )v ♪")
            emoticonFonts.add("ヽ(⌐■_■)ノ♪♬")
            emoticonFonts.add("★ANIMALS EMOTICONS★")
            emoticonFonts.add("(<●>ω<●>)✧")
            emoticonFonts.add("ฅ( ̳͒•ಲ• ̳͒)♪")
            emoticonFonts.add("ʕ •ᴥ•ʔ")
            emoticonFonts.add("ʕ•̫͡•ʔ❤ʕ•̫͡•ʔ")
            emoticonFonts.add("ʕつ ͡◔ ᴥ ͡◔ʔつ")
            emoticonFonts.add("U(⁎˃ᆺ˂)U")
            emoticonFonts.add("U(ㅇㅅㅇ❀)U")
            emoticonFonts.add("₍ᐢ•ﻌ•ᐢ₎*･ﾟ｡")
            emoticonFonts.add("₍˄·͈༝·͈˄*₎◞ ̑̑❤️くコ:≡")
            emoticonFonts.add("(•͈⌔•͈⑅)")
            emoticonFonts.add("╰༼ ∗ ಡ ▾ ಡ ∗ ༽╯")
            emoticonFonts.add("✿♬ﾟ+.(｡◡‿◡)♪.+ﾟ♬✿。")
            emoticonFonts.add("★ANGRY EMOTICONS★")
            emoticonFonts.add("凸ಠ益ಠ)凸")
            emoticonFonts.add("( ︶︿︶)_╭∩╮")
            emoticonFonts.add("┌∩┐(◣_◢)┌∩┐")
            emoticonFonts.add("ᕕ༼ ͠ຈ Ĺ̯ ͠ຈ ༽┌∩┐")
            emoticonFonts.add("ᕕ(˵•̀෴•́˵)ᕗ")
            emoticonFonts.add("{{{(>_<)}}}")
            emoticonFonts.add("ᕙ(⇀‸↼‶)ᕗ")
            emoticonFonts.add("★SAD EMOTICONS★")
            emoticonFonts.add("┏༼ ◉ ╭╮ ◉༽┓")
            emoticonFonts.add("(๑◕︵◕๑)")
            emoticonFonts.add("(︶︹︺)")
            emoticonFonts.add("(´°̥̥̥̥̥̥̥̥ω°̥̥̥̥̥̥̥̥｀)")
            emoticonFonts.add("╯﹏╰")
            emoticonFonts.add("~(｡☉︵ ಠ@)>")
            emoticonFonts.add("(▰︶︹︺▰)")
            emoticonFonts.add("( ⁍᷄⌢̻⁍᷅ )")
            emoticonFonts.add("‧º·(˚ ˃̣̣̥⌓˂̣̣̥ )‧º·˚")
            emoticonFonts.add("(╯︵╰,)")
            emoticonFonts.add("(இ﹏இ`｡)")
            emoticonFonts.add("★SLEEPING EMOTICONS★")
            emoticonFonts.add("(-, – )…zzzZZZ")
            emoticonFonts.add("✾꒡ .̮ ꒡✾")
            emoticonFonts.add("( ु⁎ᴗ_ᴗ⁎)ु.｡oO")
            emoticonFonts.add("(ृ ु⁎ᴗᵨᴗ⁎)ु.zZ")
            emoticonFonts.add("꒰ ꒡⌓꒡꒱ᏩɵɵᎴ ɳɩɠɧ✟")
            emoticonFonts.add("【☆sweet dream☆】(●ＵωU).zZZ")
            emoticonFonts.add("★EXCITED EMOTICONS★")
            emoticonFonts.add("(((o(*ﾟ▽ﾟ*)o)))")
            emoticonFonts.add("o((*^▽^*))o")
            emoticonFonts.add("⌒°(❛ᴗ❛)°⌒")
            emoticonFonts.add("(۶ꈨຶꎁꈨຶ )۶ʸᵉᵃʰᵎ")
            emoticonFonts.add("୧༼✿ ͡◕ д ◕͡ ༽୨")
            emoticonFonts.add("✧⁺⸜(●′▾‵●)⸝⁺✧")
            emoticonFonts.add("ヾ(o✪‿✪o)ｼ")
            emoticonFonts.add("★HUNGRY EMOTICONS★")
            emoticonFonts.add("(๑′ڡ‵๑)۶४४yϋᵐᵐӵ♡॰⋆̥")
            emoticonFonts.add("╰། ❛ ڡ ❛ །╯")
            emoticonFonts.add(" ԅ| . ͡° ڡ ͡° . |ᕤ")
            emoticonFonts.add("( ๑ ❛ ڡ ❛ ๑ )❤")
            emoticonFonts.add("(✽´ཫ`✽)")
            emoticonFonts.add("ʕっ˘ڡ˘ʔっ─∈")
            emoticonFonts.add("★SHY EMOTICONS★")
            emoticonFonts.add("ᕕ╏ ͡ ▾ ͡ ╏┐")
            emoticonFonts.add("(ง ´͈౪`͈)ว")
            emoticonFonts.add("(#^.^#)")
            emoticonFonts.add(" (๑•́‧̫•̀๑)")
            emoticonFonts.add("(๑￫‿￩๑)")
            emoticonFonts.add("(✿ꈍ。 ꈍ✿)")
            emoticonFonts.add("(∗ᵕ̴᷄◡ᵕ̴᷅∗)՞")
            emoticonFonts.add("★OTHER EMOTICONS★")
            emoticonFonts.add("☮▁▂▃▄☾ ♛ ◡ ♛ ☽▄▃▂▁☮")
            emoticonFonts.add(".₊̣̇.ෆ˟̑*̑˚̑*̑˟̑ෆ.₊̣̇.ෆ˟̑*̑˚̑*̑˟̑ෆ.₊̣̇.ෆ˟̑*̑˚̑*̑˟̑ෆ.₊̣̇.ෆ˟̑*̑˚̑*̑˟̑ෆ.₊̣̇.")
            emoticonFonts.add("♡*+:•*∴”:♡.•♬✧♡*+:•*∴”:♡.•♬✧")
            emoticonFonts.add("* ੈ✩‧₊˚* ੈ✩‧₊˚* ੈ✩‧₊˚")
            emoticonFonts.add("☆彡★彡☆彡★彡☆彡★彡☆彡★彡")
            emoticonFonts.add("♡հҽӀӀօ♡* ૂི•̮͡• ૂ ྀෆ⃛﹡೫٭ॢ*⋆♡⁎೨ ♡⃛ෆ͙⃛ ॢ٭ॢ*⋆♡⁎೨")
            emoticonFonts.add("★☆。.:*:･”ﾟ★βyёヾ(⌒∇⌒)ﾉβyё★｡.:*:･”☆★")
            emoticonFonts.add("㇏( ෆั ⌣ ෆั )ﾉցօօժ ʍօɾղíղց❣")
            emoticonFonts.add("☻⋆˚✩Ꮹ∞ძ ოǫɾлілϧ ༘*ೄ˚☻")
            emoticonFonts.add(".｡.:*･ﾟ☆ｓωεετ*･ﾟｄｒεαｍ☆.｡.:*･ﾟ”￡(｡･”･)-†")
            emoticonFonts.add("ヽ（≧ω≦）｛☆HAPPY★BIRTHDAY☆｝（≧ω≦）/")
            emoticonFonts.add("(ෆˊ͈ ु꒳ ूˋ͈ෆ) ˡºᵛᵉ❤⃛")
            emoticonFonts.add("✿*ﾟ¨ﾟ✎･ ✿.｡.:* *.:｡✿*ﾟ¨ﾟ✎･✿.｡.:* ♡LOVE♡LOVE♡ ✿*ﾟ¨ﾟ✎･ ✿.｡.:*")
            emoticonFonts.add("ෆ⃛ෆ⃛ෆ⃛ ♡♡[τ̲̅н̲̅a̲̅и̲̅κ̲̅ ч̲̅o̲̅u̲̅]ᴗ͈ₒᴗ͈♡")
            emoticonFonts.add("♬°⋆ɱUꑄյ͛ʗ⋆°♬")
            emoticonFonts.add("■■■■■■■■■■■□□□ NOWLOADING")

        } else {
            emoticonFonts.clear()
            emoticonFonts.add("★LOVE EMOTICONS★")
            emoticonFonts.add("★~(◠‿◕✿)")
            emoticonFonts.add("乂❤‿❤乂")
            emoticonFonts.add("༼♥ل͜♥༽")
            emoticonFonts.add("ლζ*♡ε♡*ζლ")
            emoticonFonts.add("⊂（❤⌂❤）⊃")
            emoticonFonts.add("٩(*❛⊰❛)ʓਡ～❤")
            emoticonFonts.add("♥╣[-_-]╠♥")
            emoticonFonts.add("( ･_･)♡")
            emoticonFonts.add("(●'◡'●)ﾉ♥")
            emoticonFonts.add("(* ˘⌣˘)◞[_]❤[_]ヽ(•‿• )")
            emoticonFonts.add("( ＾◡＾)っ✂❤")
            emoticonFonts.add("(Ɔ ˘⌣˘)♥(˘⌣˘ C) ")
            emoticonFonts.add("(乂ღ˘⌣˘)ノ❤ヽ(ˆ⌣ˆ)ヾ")
            emoticonFonts.add("(ღ˘⌣˘)♥ ℒ♡ⓥℯ ㄚ♡ⓤ")
            emoticonFonts.add("▂▃▄▅▆▇█▓▒░LoveYou░▒▓█▇▆▅▄▃▂")
            emoticonFonts.add("(。♡‿♡。)")
            emoticonFonts.add("♡o。.(✿ฺ。✿ฺ)")
            emoticonFonts.add("♡＾▽＾♡")
            emoticonFonts.add("(ღ˘⌣˘ღ)")
            emoticonFonts.add("웃❤유")
            emoticonFonts.add("{❤‿❤}")
            emoticonFonts.add("[̲̅ə̲̅٨̲̅٥̲̅٦̲̅]")
            emoticonFonts.add("┣┓웃┏♨❤♨┑유┏┥")
            emoticonFonts.add("(Ɔ ˘⌣˘)˘⌣˘ C) ")
            emoticonFonts.add("✨Lᵒᵛᵉᵧₒᵤ")
            emoticonFonts.add("★HAPPY EMOTICONS★")
            emoticonFonts.add("✿◕ ‿ ◕✿")
            emoticonFonts.add("೭੧(❛▿❛✿)੭೨")
            emoticonFonts.add("◎[▪‿▪]◎")
            emoticonFonts.add("☆(❁‿❁)☆")
            emoticonFonts.add("(✿◠‿◠) ")
            emoticonFonts.add("°˖✧◝(⁰▿⁰)◜✧˖°")
            emoticonFonts.add("≧◉◡◉≦")
            emoticonFonts.add("≧◠‿◠≦")
            emoticonFonts.add("٩(˘◡˘)۶")
            emoticonFonts.add("(✿ꈍ。 ꈍ✿)")
            emoticonFonts.add("( ๑ ᴖ ᴈ ᴖ)ᴖ ᴑ ᴖ๑)❣")
            emoticonFonts.add("( ͡° ͜ʖ ͡°)")
            emoticonFonts.add("┑(￣▽￣)┍")
            emoticonFonts.add("(❁´◡`❁)")
            emoticonFonts.add("(●⌒∇⌒●)")
            emoticonFonts.add("ಥ‿ಥ")
            emoticonFonts.add("(◕‿◕)")
            emoticonFonts.add("≖‿≖")
            emoticonFonts.add("(◠‿◠)")
            emoticonFonts.add("（⌒▽⌒）")
            emoticonFonts.add("(•ิ‿•ิ)")
            emoticonFonts.add("ʘ‿ʘ")
            emoticonFonts.add("o(∩_∩)o")
            emoticonFonts.add("ლ(╹◡╹ლ)")
            emoticonFonts.add("★MUSIC EMOTICONS★")
            emoticonFonts.add("♪(๑ᴖ◡ᴖ๑)♪")
            emoticonFonts.add("|̲̅̅●̲̅̅|̲̅̅=̲̅̅|̲̅̅●̲̅̅|")
            emoticonFonts.add("♫♪.ılılıll|̲̅̅●̲̅̅|̲̅̅=̲̅̅|̲̅̅●̲̅̅|llılılı.♫♪")
            emoticonFonts.add("Ϛ⃘๑•͡ .̫•๑꒜♬♫")
            emoticonFonts.add("(ღ˘⌣˘ღ) ♫･*:.｡. .｡.:*･")
            emoticonFonts.add("♪♪ｖ(⌒ｏ⌒)ｖ♪♪")
            emoticonFonts.add("♬♫♪◖(●。●)◗♪♫♬")
            emoticonFonts.add("♪٩(✿′ᗜ‵✿)۶♪")
            emoticonFonts.add("♬♩♫♪☻(●´∀｀●)☻♪♫♩♬")
            emoticonFonts.add("♬♪♫ ヾ(*・。・)ﾉ ♬♪♫")
            emoticonFonts.add("٩(ó｡ò۶ ♡)))♬")
            emoticonFonts.add("♪~♪ d(⌒o⌒)b♪~♪")
            emoticonFonts.add("♪♪(o*゜∇゜)o～♪♪")
            emoticonFonts.add("✌♫♪˙❤‿❤˙♫♪✌")
            emoticonFonts.add("(◦′ᆺ‵◦) ♬° ✧❥✧¸.•*¨*✧♡✧ ℒℴѵℯ ✧♡✧*¨*•.❥")
            emoticonFonts.add("✿♬ﾟ+.(｡◡‿◡)♪.+ﾟ♬✿。")
            emoticonFonts.add("♪ヽ( ⌒o⌒)人(⌒-⌒ )v ♪")
            emoticonFonts.add("ヽ(⌐■_■)ノ♪♬")
            emoticonFonts.add("★ANIMALS EMOTICONS★")
            emoticonFonts.add("(<●>ω<●>)✧")
            emoticonFonts.add("ฅ( ̳͒•ಲ• ̳͒)♪")
            emoticonFonts.add("ʕ •ᴥ•ʔ")
            emoticonFonts.add("ʕ•̫͡•ʔ❤ʕ•̫͡•ʔ")
            emoticonFonts.add("ʕつ ͡◔ ᴥ ͡◔ʔつ")
            emoticonFonts.add("U(⁎˃ᆺ˂)U")
            emoticonFonts.add("U(ㅇㅅㅇ❀)U")
            emoticonFonts.add("₍ᐢ•ﻌ•ᐢ₎*･ﾟ｡")
            emoticonFonts.add("₍˄·͈༝·͈˄*₎◞ ̑̑❤️くコ:≡")
            emoticonFonts.add("(•͈⌔•͈⑅)")
            emoticonFonts.add("╰༼ ∗ ಡ ▾ ಡ ∗ ༽╯")
            emoticonFonts.add("✿♬ﾟ+.(｡◡‿◡)♪.+ﾟ♬✿。")
            emoticonFonts.add("★ANGRY EMOTICONS★")
            emoticonFonts.add("凸ಠ益ಠ)凸")
            emoticonFonts.add("( ︶︿︶)_╭∩╮")
            emoticonFonts.add("┌∩┐(◣_◢)┌∩┐")
            emoticonFonts.add("ᕕ༼ ͠ຈ Ĺ̯ ͠ຈ ༽┌∩┐")
            emoticonFonts.add("ᕕ(˵•̀෴•́˵)ᕗ")
            emoticonFonts.add("{{{(>_<)}}}")
            emoticonFonts.add("ᕙ(⇀‸↼‶)ᕗ")
            emoticonFonts.add("★SAD EMOTICONS★")
            emoticonFonts.add("┏༼ ◉ ╭╮ ◉༽┓")
            emoticonFonts.add("(๑◕︵◕๑)")
            emoticonFonts.add("(︶︹︺)")
            emoticonFonts.add("(´°̥̥̥̥̥̥̥̥ω°̥̥̥̥̥̥̥̥｀)")
            emoticonFonts.add("╯﹏╰")
            emoticonFonts.add("~(｡☉︵ ಠ@)>")
            emoticonFonts.add("(▰︶︹︺▰)")
            emoticonFonts.add("( ⁍᷄⌢̻⁍᷅ )")
            emoticonFonts.add("‧º·(˚ ˃̣̣̥⌓˂̣̣̥ )‧º·˚")
            emoticonFonts.add("(╯︵╰,)")
            emoticonFonts.add("(இ﹏இ`｡)")
            emoticonFonts.add("★SLEEPING EMOTICONS★")
            emoticonFonts.add("(-, – )…zzzZZZ")
            emoticonFonts.add("✾꒡ .̮ ꒡✾")
            emoticonFonts.add("( ु⁎ᴗ_ᴗ⁎)ु.｡oO")
            emoticonFonts.add("(ृ ु⁎ᴗᵨᴗ⁎)ु.zZ")
            emoticonFonts.add("꒰ ꒡⌓꒡꒱ᏩɵɵᎴ ɳɩɠɧ✟")
            emoticonFonts.add("【☆sweet dream☆】(●ＵωU).zZZ")
            emoticonFonts.add("★EXCITED EMOTICONS★")
            emoticonFonts.add("(((o(*ﾟ▽ﾟ*)o)))")
            emoticonFonts.add("o((*^▽^*))o")
            emoticonFonts.add("⌒°(❛ᴗ❛)°⌒")
            emoticonFonts.add("(۶ꈨຶꎁꈨຶ )۶ʸᵉᵃʰᵎ")
            emoticonFonts.add("୧༼✿ ͡◕ д ◕͡ ༽୨")
            emoticonFonts.add("✧⁺⸜(●′▾‵●)⸝⁺✧")
            emoticonFonts.add("ヾ(o✪‿✪o)ｼ")
            emoticonFonts.add("★HUNGRY EMOTICONS★")
            emoticonFonts.add("(๑′ڡ‵๑)۶४४yϋᵐᵐӵ♡॰⋆̥")
            emoticonFonts.add("╰། ❛ ڡ ❛ །╯")
            emoticonFonts.add(" ԅ| . ͡° ڡ ͡° . |ᕤ")
            emoticonFonts.add("( ๑ ❛ ڡ ❛ ๑ )❤")
            emoticonFonts.add("(✽´ཫ`✽)")
            emoticonFonts.add("ʕっ˘ڡ˘ʔっ─∈")
            emoticonFonts.add("★SHY EMOTICONS★")
            emoticonFonts.add("ᕕ╏ ͡ ▾ ͡ ╏┐")
            emoticonFonts.add("(ง ´͈౪`͈)ว")
            emoticonFonts.add("(#^.^#)")
            emoticonFonts.add(" (๑•́‧̫•̀๑)")
            emoticonFonts.add("(๑￫‿￩๑)")
            emoticonFonts.add("(✿ꈍ。 ꈍ✿)")
            emoticonFonts.add("(∗ᵕ̴᷄◡ᵕ̴᷅∗)՞")
            emoticonFonts.add("★OTHER EMOTICONS★")
            emoticonFonts.add("☮▁▂▃▄☾ ♛ ◡ ♛ ☽▄▃▂▁☮")
            emoticonFonts.add(".₊̣̇.ෆ˟̑*̑˚̑*̑˟̑ෆ.₊̣̇.ෆ˟̑*̑˚̑*̑˟̑ෆ.₊̣̇.ෆ˟̑*̑˚̑*̑˟̑ෆ.₊̣̇.ෆ˟̑*̑˚̑*̑˟̑ෆ.₊̣̇.")
            emoticonFonts.add("♡*+:•*∴”:♡.•♬✧♡*+:•*∴”:♡.•♬✧")
            emoticonFonts.add("* ੈ✩‧₊˚* ੈ✩‧₊˚* ੈ✩‧₊˚")
            emoticonFonts.add("☆彡★彡☆彡★彡☆彡★彡☆彡★彡")
            emoticonFonts.add("♡հҽӀӀօ♡* ૂི•̮͡• ૂ ྀෆ⃛﹡೫٭ॢ*⋆♡⁎೨ ♡⃛ෆ͙⃛ ॢ٭ॢ*⋆♡⁎೨")
            emoticonFonts.add("★☆。.:*:･”ﾟ★βyёヾ(⌒∇⌒)ﾉβyё★｡.:*:･”☆★")
            emoticonFonts.add("㇏( ෆั ⌣ ෆั )ﾉցօօժ ʍօɾղíղց❣")
            emoticonFonts.add("☻⋆˚✩Ꮹ∞ძ ოǫɾлілϧ ༘*ೄ˚☻")
            emoticonFonts.add(".｡.:*･ﾟ☆ｓωεετ*･ﾟｄｒεαｍ☆.｡.:*･ﾟ”￡(｡･”･)-†")
            emoticonFonts.add("ヽ（≧ω≦）｛☆HAPPY★BIRTHDAY☆｝（≧ω≦）/")
            emoticonFonts.add("(ෆˊ͈ ु꒳ ूˋ͈ෆ) ˡºᵛᵉ❤⃛")
            emoticonFonts.add("✿*ﾟ¨ﾟ✎･ ✿.｡.:* *.:｡✿*ﾟ¨ﾟ✎･✿.｡.:* ♡LOVE♡LOVE♡ ✿*ﾟ¨ﾟ✎･ ✿.｡.:*")
            emoticonFonts.add("ෆ⃛ෆ⃛ෆ⃛ ♡♡[τ̲̅н̲̅a̲̅и̲̅κ̲̅ ч̲̅o̲̅u̲̅]ᴗ͈ₒᴗ͈♡")
            emoticonFonts.add("♬°⋆ɱUꑄյ͛ʗ⋆°♬")
            emoticonFonts.add("■■■■■■■■■■■□□□ NOWLOADING")
        }
        val adapter = CustomAdapter(requireContext(),emoticonFonts)
        listView.adapter = adapter
        listView.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                val desStr = emoticonFonts[position]
                val mainText = activity?.findViewById<TextView>(R.id.main_text)
                editText = activity?.findViewById(R.id.edit_text_main)
                mainText?.append(desStr)
                editText?.append(desStr)

            }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(requireContext())
        this.context = context as Activity?
    }
}