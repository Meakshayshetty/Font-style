package com.akshay.textstyle.adapter

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.akshay.textstyle.R
import com.akshay.textstyle.model.Font

class DecorationAdapter(private var decorationFonts: ArrayList<Font>?,
                        private val activity: Activity?)
    : RecyclerView.Adapter<DecorationAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val row: View =
            LayoutInflater.from(activity).inflate(R.layout.adapter_decoration, parent, false)
        return MyViewHolder(row)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val f: Font = decorationFonts!![position]
        //holder.title.text = f.getFontName()
        val strBld: StringBuilder = StringBuilder(f.getPreviewText())
        when (position) {
            0 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "★·.·´¯`·.·★")
                strBld.insert(strBld.length, "★·.·´¯`·.·★")
            } else if (!f.getPreviewText().contains("★·.·´¯`·.·★")) {
                strBld.insert(0, "★·.·´¯`·.·★")
                strBld.insert(strBld.length,"★·.·´¯`·.·★")
            }
            1 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "✦͙͙͙*͙*❥⃝∗⁎.ʚ")
                strBld.insert(strBld.length, "ɞ.⁎∗❥⃝**͙✦͙͙͙")
            } else if (!f.getPreviewText().contains("✦͙͙͙*͙*❥⃝∗⁎.ʚ")) {
                strBld.insert(0, "✦͙͙͙*͙*❥⃝∗⁎.ʚ")
                strBld.insert(strBld.length, "ɞ.⁎∗❥⃝**͙✦͙͙͙")
            }
            2 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "▁ ▂ ▄ ▅ ▆ ▇ █ ")
                strBld.insert(strBld.length, "█ ▇ ▆ ▅ ▄ ▂ ▁")
            } else if (!f.getPreviewText().contains("█ ▇ ▆ ▅ ▄ ▂ ▁")) {
                strBld.insert(0, "▁ ▂ ▄ ▅ ▆ ▇ █")
                strBld.insert(strBld.length, "█ ▇ ▆ ▅ ▄ ▂ ▁")
            }
            3 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "¸¸♬·¯·♩¸¸♪·¯·♫¸¸")
                strBld.insert(strBld.length, "¸¸♫·¯·♪¸¸♩·¯·♬¸¸")
            } else if (!f.getPreviewText().contains("¸¸♬·¯·♩¸¸♪·¯·♫¸¸")) {
                strBld.insert(0, "¸¸♬·¯·♩¸¸♪·¯·♫¸¸")
                strBld.insert(strBld.length, "¸¸♫·¯·♪¸¸♩·¯·♬¸¸")
            }
            4 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "{♥‿♥}")
                strBld.insert(strBld.length, "{♥‿♥}")
            } else if (!f.getPreviewText().contains("{♥‿♥}")) {
                strBld.insert(0, "{♥‿♥}")
                strBld.insert(strBld.length, "{♥‿♥}")
            }
            5 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "✿◕ ‿ ◕✿")
                strBld.insert(strBld.length, "✿◕ ‿ ◕✿")
            } else if (!f.getPreviewText().contains("✿◕ ‿ ◕✿")) {
                strBld.insert(0, "✿◕ ‿ ◕✿")
                strBld.insert(strBld.length, "✿◕ ‿ ◕✿")
            }
            6 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "웃❤유")
                strBld.insert(strBld.length, "유❤웃")
            } else if (!f.getPreviewText().contains("웃❤유")) {
                strBld.insert(0, "웃❤유")
                strBld.insert(strBld.length, "유❤웃")
            }
            7 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "✿.｡.:* ☆:**:.")
                strBld.insert(strBld.length, ".:**:.☆*.:｡.✿")
            } else if (!f.getPreviewText().contains("✿.｡.:* ☆:**:.")) {
                strBld.insert(0, "✿.｡.:* ☆:**:.")
                strBld.insert(strBld.length, ".:**:.☆*.:｡.✿")
            }
            8 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "¤¸¸.•´¯`•¸¸.•..>>")
                strBld.insert(strBld.length, "<<..•.¸¸•´¯`•.¸¸¤")
            } else if (!f.getPreviewText().contains("¤¸¸.•´¯`•¸¸.•..>>")) {
                strBld.insert(0, "¤¸¸.•´¯`•¸¸.•..>>")
                strBld.insert(strBld.length, "<<..•.¸¸•´¯`•.¸¸¤")
            }
            9 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "◦•●◉✿")
                strBld.insert(strBld.length, "✿◉●•◦")
            } else if (!f.getPreviewText().contains("◦•●◉✿")) {
                strBld.insert(0, "◦•●◉✿")
                strBld.insert(strBld.length, "✿◉●•◦")
            }
            10 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "▀▄▀▄▀▄")
                strBld.insert(strBld.length, "▄▀▄▀▄▀")
            } else if (!f.getPreviewText().contains("▀▄▀▄▀▄")) {
                strBld.insert(0, "▀▄▀▄▀▄")
                strBld.insert(strBld.length, "▄▀▄▀▄▀")
            }
            11 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, ".•°¤*(¯`★´¯)*¤°")
                strBld.insert(strBld.length, "°¤*(¯´★`¯)*¤°•.")
            } else if (!f.getPreviewText().contains(".•°¤*(¯`★´¯)*¤°")) {
                strBld.insert(0, ".•°¤*(¯`★´¯)*¤°")
                strBld.insert(strBld.length, "°¤*(¯´★`¯)*¤°•.")
            }
            12 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "☆(❁‿❁)☆")
                strBld.insert(strBld.length, "☆(❁‿❁)☆")
            } else if (!f.getPreviewText().contains("☆(❁‿❁)☆")) {
                strBld.insert(0, "☆(❁‿❁)☆")
                strBld.insert(strBld.length, "☆(❁‿❁)☆")
            }
            13 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "ღ(¯`◕‿◕´¯) ♫ ♪ ♫")
                strBld.insert(strBld.length, "♫ ♪ ♫ (¯`◕‿◕´¯)ღ")
            } else if (!f.getPreviewText().contains("ღ(¯`◕‿◕´¯) ♫ ♪ ♫")) {
                strBld.insert(0, "ღ(¯`◕‿◕´¯) ♫ ♪ ♫")
                strBld.insert(strBld.length, "♫ ♪ ♫ (¯`◕‿◕´¯)ღ")
            }
            14 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "«-(¯`v´¯)-«")
                strBld.insert(strBld.length, "»-(¯`v´¯)-»")
            } else if (!f.getPreviewText().contains("«-(¯`v´¯)-«")) {
                strBld.insert(0, "«-(¯`v´¯)-«")
                strBld.insert(strBld.length, "»-(¯`v´¯)-»")
            }
            15 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "=。:.ﾟ(●ö◡ö●):.｡+ﾟ")
                strBld.insert(strBld.length, "=。:.ﾟ(●ö◡ö●):.｡+ﾟ")
            } else if (!f.getPreviewText().contains("=。:.ﾟ(●ö◡ö●):.｡+ﾟ")) {
                strBld.insert(0, "=。:.ﾟ(●ö◡ö●):.｡+ﾟ")
                strBld.insert(strBld.length, "=。:.ﾟ(●ö◡ö●):.｡+ﾟ")
            }
            16 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "❤(｡◕‿◕｡)❤")
                strBld.insert(strBld.length, "❤(｡◕‿◕｡)❤")
            } else if (!f.getPreviewText().contains("❤(｡◕‿◕｡)❤")) {
                strBld.insert(0, "❤(｡◕‿◕｡)❤")
                strBld.insert(strBld.length, "❤(｡◕‿◕｡)❤")
            }
            17 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "ლ❣☆(❁‿❁)")
                strBld.insert(strBld.length, "(❁‿❁)☆❣ლ")
            } else if (!f.getPreviewText().contains("ლ❣☆(❁‿❁)")) {
                strBld.insert(0, "ლ❣☆(❁‿❁)")
                strBld.insert(strBld.length, "(❁‿❁)☆❣ლ")
            }
            18 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "๑۞๑,¸¸,ø¤º°`°๑۩")
                strBld.insert(strBld.length, "๑۩ ,¸¸,ø¤º°`°๑۞๑")
            } else if (!f.getPreviewText().contains("๑۞๑,¸¸,ø¤º°`°๑۩")) {
                strBld.insert(0, "๑۞๑,¸¸,ø¤º°`°๑۩")
                strBld.insert(strBld.length, "๑۩ ,¸¸,ø¤º°`°๑۞๑")
            }
            19 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "*:;,．★ ～☆・:.,;*")
                strBld.insert(strBld.length, "*:;,．☆ ～★・:.,;*")
            } else if (!f.getPreviewText().contains("*:;,．★ ～☆・:.,;*")) {
                strBld.insert(0, "*:;,．★ ～☆・:.,;*")
                strBld.insert(strBld.length, "*:;,．☆ ～★・:.,;*")
            }
            20 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "╚»★«╝")
                strBld.insert(strBld.length, "╚»★«╝")
            } else if (!f.getPreviewText().contains("╚»★«╝")) {
                strBld.insert(0, "╚»★«╝")
                strBld.insert(strBld.length, "╚»★«╝")
            }
            21 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "➶➶➶➶➶")
                strBld.insert(strBld.length, "➷➷➷➷➷")
            } else if (!f.getPreviewText().contains("➶➶➶➶➶")) {
                strBld.insert(0, "➶➶➶➶➶")
                strBld.insert(strBld.length, "➷➷➷➷➷")
            }
            22 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "(｡◕‿‿◕｡)")
                strBld.insert(strBld.length, "(｡◕‿‿◕｡)")
            } else if (!f.getPreviewText().contains("(｡◕‿‿◕｡)")) {
                strBld.insert(0, "(｡◕‿‿◕｡)")
                strBld.insert(strBld.length, "(｡◕‿‿◕｡)")
            }
            23 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "`•.¸¸.•´´¯`••._.•")
                strBld.insert(strBld.length, "•._.••`¯´´•.¸¸.•`")
            } else if (!f.getPreviewText().contains("`•.¸¸.•´´¯`••._.•")) {
                strBld.insert(0, "`•.¸¸.•´´¯`••._.•")
                strBld.insert(strBld.length, "•._.••`¯´´•.¸¸.•`")
            }
            24 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "☮▁▂▃▄☾ ♛")
                strBld.insert(strBld.length, "♛ ☽▄▃▂▁☮")
            } else if (!f.getPreviewText().contains("☮▁▂▃▄☾ ♛")) {
                strBld.insert(0, "☮▁▂▃▄☾ ♛")
                strBld.insert(strBld.length, "♛ ☽▄▃▂▁☮")
            }
            25 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "¸,ø¤º°`°º¤ø,¸¸,ø¤º°")
                strBld.insert(strBld.length, "°º¤ø,¸¸,ø¤º°`°º¤ø,¸")
            } else if (!f.getPreviewText().contains("¸,ø¤º°`°º¤ø,¸¸,ø¤º°")) {
                strBld.insert(0, "¸,ø¤º°`°º¤ø,¸¸,ø¤º°")
                strBld.insert(strBld.length, "°º¤ø,¸¸,ø¤º°`°º¤ø,¸")
            }
            26 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "╰☆☆")
                strBld.insert(strBld.length, "☆☆╮")
            } else if (!f.getPreviewText().contains("╰☆☆")) {
                strBld.insert(0, "╰☆☆")
                strBld.insert(strBld.length, "☆☆╮")
            }
            27 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "]|I{•------»")
                strBld.insert(strBld.length, "«------•}I|[")
            } else if (!f.getPreviewText().contains("]|I{•------»")) {
                strBld.insert(0, "]|I{•------»")
                strBld.insert(strBld.length, "«------•}I|[")
            }
            28 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "(ღ˘⌣˘ღ)")
                strBld.insert(strBld.length, "(ღ˘⌣˘ღ)")
            } else if (!f.getPreviewText().contains("(ღ˘⌣˘ღ)")) {
                strBld.insert(0, "(ღ˘⌣˘ღ)")
                strBld.insert(strBld.length, "(ღ˘⌣˘ღ)")
            }
            29 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "(¯`·.¸¸.·´¯`·.¸¸.->")
                strBld.insert(strBld.length, "<-.¸¸.·´¯`·.¸¸.·´¯)")
            } else if (!f.getPreviewText().contains("(¯`·.¸¸.·´¯`·.¸¸.->")) {
                strBld.insert(0, "(¯`·.¸¸.·´¯`·.¸¸.->")
                strBld.insert(strBld.length, "<-.¸¸.·´¯`·.¸¸.·´¯)")
            }
            30 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "↤↤❤↤↤")
                strBld.insert(strBld.length, "↦↦❤↦↦")
            } else if (!f.getPreviewText().contains("↤↤❤↤↤")) {
                strBld.insert(0, "↤↤❤↤↤")
                strBld.insert(strBld.length, "↦↦❤↦↦")
            }
            31 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "↫↫↫↫↫")
                strBld.insert(strBld.length, "↬↬↬↬↬")
            } else if (!f.getPreviewText().contains("↫↫↫↫↫")) {
                strBld.insert(0, "↫↫↫↫↫")
                strBld.insert(strBld.length, "↬↬↬↬↬")
            }
            32 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "【｡_｡】")
                strBld.insert(strBld.length, "【｡_｡】")
            } else if (!f.getPreviewText().contains("【｡_｡】")) {
                strBld.insert(0, "【｡_｡】")
                strBld.insert(strBld.length, "【｡_｡】")
            }
            33 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "░▒▓█►─═")
                strBld.insert(strBld.length, "═─◄█▓▒░")
            } else if (!f.getPreviewText().contains("░▒▓█►─═")) {
                strBld.insert(0, "░▒▓█►─═")
                strBld.insert(strBld.length, "═─◄█▓▒░")
            }
            34 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "|!¤*'~``~'*¤!|")
                strBld.insert(strBld.length, "|!¤*'~``~'*¤!|")
            } else if (!f.getPreviewText().contains("|!¤*'~``~'*¤!|")) {
                strBld.insert(0, "|!¤*'~``~'*¤!|")
                strBld.insert(strBld.length, "|!¤*'~``~'*¤!|")
            }
            35 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "._|.<(+_+)>.|_.")
                strBld.insert(strBld.length, "._|.<(+_+)>.|_.")
            } else if (!f.getPreviewText().contains("._|.<(+_+)>.|_.")) {
                strBld.insert(0, "._|.<(+_+)>.|_.")
                strBld.insert(strBld.length, "._|.<(+_+)>.|_.")
            }
            36 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "❤(❁´◡`❁)❤")
                strBld.insert(strBld.length, "❤(❁´◡`❁)❤")
            } else if (!f.getPreviewText().contains("❤(❁´◡`❁)❤")) {
                strBld.insert(0, "❤(❁´◡`❁)❤")
                strBld.insert(strBld.length, "❤(❁´◡`❁)❤")
            }
            37 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "-漫~*'¨¯¨'*·舞~")
                strBld.insert(strBld.length, "~舞*'¨¯¨'*·~漫-")
            } else if (!f.getPreviewText().contains("-漫~*'¨¯¨'*·舞~")) {
                strBld.insert(0, "-漫~*'¨¯¨'*·舞~")
                strBld.insert(strBld.length, "~舞*'¨¯¨'*·~漫-")
            }
            38 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, ".•°¤*(¯`★´¯)*¤°")
                strBld.insert(strBld.length, "°¤*(¯´★`¯)*¤°•.")
            } else if (!f.getPreviewText().contains(".•°¤*(¯`★´¯)*¤°")) {
                strBld.insert(0, ".•°¤*(¯`★´¯)*¤°")
                strBld.insert(strBld.length, "°¤*(¯´★`¯)*¤°•.")
            }
            39 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "⊂◉‿◉つ")
                strBld.insert(strBld.length, "⊂◉‿◉つ")
            } else if (!f.getPreviewText().contains("⊂◉‿◉つ")) {
                strBld.insert(0, "⊂◉‿◉つ")
                strBld.insert(strBld.length, "⊂◉‿◉つ")
            }
            40 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "●▬▬▬▬๑۩")
                strBld.insert(strBld.length, "۩๑▬▬▬▬▬●")
            } else if (!f.getPreviewText().contains("●▬▬▬▬๑۩")) {
                strBld.insert(0, "●▬▬▬▬๑۩")
                strBld.insert(strBld.length, "۩๑▬▬▬▬▬●")
            }
            41 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "╚═| ~ ಠ ₒ ಠ ~ |═╝")
                strBld.insert(strBld.length, "╚═| ~ ಠ ₒ ಠ ~ |═╝")
            } else if (!f.getPreviewText().contains("╚═| ~ ಠ ₒ ಠ ~ |═╝")) {
                strBld.insert(0, "╚═| ~ ಠ ₒ ಠ ~ |═╝")
                strBld.insert(strBld.length, "╚═| ~ ಠ ₒ ಠ ~ |═╝")
            }
            42 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "✿◡‿◡")
                strBld.insert(strBld.length, "◡‿◡✿")
            } else if (!f.getPreviewText().contains("✿◡‿◡")) {
                strBld.insert(0, "✿◡‿◡")
                strBld.insert(strBld.length, "◡‿◡✿")
            }
            43 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "<(▰˘◡˘▰)>")
                strBld.insert(strBld.length, "<(▰˘◡˘▰)>")
            } else if (!f.getPreviewText().contains("<(▰˘◡˘▰)>")) {
                strBld.insert(0, "<(▰˘◡˘▰)>")
                strBld.insert(strBld.length, "<(▰˘◡˘▰)>")
            }
            44 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "ლ༼ ▀̿ Ĺ̯ ▀̿ ლ༽")
                strBld.insert(strBld.length, "ლ༼ ▀̿ Ĺ̯ ▀̿ ლ༽")
            } else if (!f.getPreviewText().contains("ლ༼ ▀̿ Ĺ̯ ▀̿ ლ༽")) {
                strBld.insert(0, "ლ༼ ▀̿ Ĺ̯ ▀̿ ლ༽")
                strBld.insert(strBld.length, "ლ༼ ▀̿ Ĺ̯ ▀̿ ლ༽")
            }
            45 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "乁། ˵ ◕ – ◕ ˵ །ㄏ")
                strBld.insert(strBld.length, "乁། ˵ ◕ – ◕ ˵ །ㄏ")
            } else if (!f.getPreviewText().contains("乁། ˵ ◕ – ◕ ˵ །ㄏ")) {
                strBld.insert(0, "乁། ˵ ◕ – ◕ ˵ །ㄏ")
                strBld.insert(strBld.length, "乁། ˵ ◕ – ◕ ˵ །ㄏ")
            }
            46 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "❤☆(◒‿◒)☆❤")
                strBld.insert(strBld.length, "❤☆(◒‿◒)☆❤")
            } else if (!f.getPreviewText().contains("❤☆(◒‿◒)☆❤")) {
                strBld.insert(0, "❤☆(◒‿◒)☆❤")
                strBld.insert(strBld.length, "❤☆(◒‿◒)☆❤")
            }
            47 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "╰། ◉ ◯ ◉ །╯")
                strBld.insert(strBld.length, "╰། ◉ ◯ ◉ །╯")
            } else if (!f.getPreviewText().contains("╰། ◉ ◯ ◉ །╯")) {
                strBld.insert(0, "╰། ◉ ◯ ◉ །╯")
                strBld.insert(strBld.length, "╰། ◉ ◯ ◉ །╯")
            }
            48 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "⋋⁞ ◔ ﹏ ◔ ⁞⋌")
                strBld.insert(strBld.length, "⋋⁞ ◔ ﹏ ◔ ⁞⋌")
            } else if (!f.getPreviewText().contains("⋋⁞ ◔ ﹏ ◔ ⁞⋌")) {
                strBld.insert(0, "⋋⁞ ◔ ﹏ ◔ ⁞⋌")
                strBld.insert(strBld.length, "⋋⁞ ◔ ﹏ ◔ ⁞⋌")
            }
            49 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "ᕕ༼✪ل͜✪༽ᕗ")
                strBld.insert(strBld.length, "ᕗ༼✪ل͜✪༽ᕕ")
            } else if (!f.getPreviewText().contains("ᕕ༼✪ل͜✪༽ᕗ")) {
                strBld.insert(0, "ᕕ༼✪ل͜✪༽ᕗ")
                strBld.insert(strBld.length, "ᕗ༼✪ل͜✪༽ᕕ")
            }
            50 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "(Ɔ ˘⌣˘)♥")
                strBld.insert(strBld.length, "♥(˘⌣˘ C)")
            } else if (!f.getPreviewText().contains("(Ɔ ˘⌣˘)♥")) {
                strBld.insert(0, "(Ɔ ˘⌣˘)♥")
                strBld.insert(strBld.length, "♥(˘⌣˘ C)")
            }
            51 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "*•.¸♡")
                strBld.insert(strBld.length, "♡¸.•*")
            } else if (!f.getPreviewText().contains("*•.¸♡")) {
                strBld.insert(0, "*•.¸♡")
                strBld.insert(strBld.length, "♡¸.•*")
            }
            52 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "(❁´◡`❁)")
                strBld.insert(strBld.length, "(❁´◡`❁)")
            } else if (!f.getPreviewText().contains("(❁´◡`❁)")) {
                strBld.insert(0, "(❁´◡`❁)")
                strBld.insert(strBld.length, "(❁´◡`❁)")
            }
            53 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "☜♡☞")
                strBld.insert(strBld.length, "☜♡☞")
            } else if (!f.getPreviewText().contains("☜♡☞")) {
                strBld.insert(0, "☜♡☞")
                strBld.insert(strBld.length, "☜♡☞")
            }
            54 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "-`ღ´--`ღ´-")
                strBld.insert(strBld.length, "-`ღ´--`ღ´-")
            } else if (!f.getPreviewText().contains("-`ღ´--`ღ´-")) {
                strBld.insert(0, "-`ღ´--`ღ´-")
                strBld.insert(strBld.length, "-`ღ´--`ღ´-")
            }
            55 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "♡＾▽＾♡")
                strBld.insert(strBld.length, "♡＾▽＾♡")
            } else if (!f.getPreviewText().contains("♡＾▽＾♡")) {
                strBld.insert(0, "♡＾▽＾♡")
                strBld.insert(strBld.length, "♡＾▽＾♡")
            }
            56 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "(。♡‿♡。)")
                strBld.insert(strBld.length, "(。♡‿♡。)")
            } else if (!f.getPreviewText().contains("(。♡‿♡。)")) {
                strBld.insert(0, "(。♡‿♡。)")
                strBld.insert(strBld.length, "(。♡‿♡。)")
            }
            57 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "♥‿♥")
                strBld.insert(strBld.length, "♥‿♥")
            } else if (!f.getPreviewText().contains("♥‿♥")) {
                strBld.insert(0, "♥‿♥")
                strBld.insert(strBld.length, "♥‿♥")
            }
            58 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "♥╣[-_-]╠♥")
                strBld.insert(strBld.length, "♥╣[-_-]╠♥")
            } else if (!f.getPreviewText().contains("♥╣[-_-]╠♥")) {
                strBld.insert(0, "♥╣[-_-]╠♥")
                strBld.insert(strBld.length, "♥╣[-_-]╠♥")
            }
            59 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "(✿◠‿◠✿)")
                strBld.insert(strBld.length, "(✿◠‿◠✿)")
            } else if (!f.getPreviewText().contains("(✿◠‿◠✿)")) {
                strBld.insert(0, "(✿◠‿◠✿)")
                strBld.insert(strBld.length, "(✿◠‿◠✿)")
            }
            60 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "❣♥(｡◕‿◕｡)♥❣")
                strBld.insert(strBld.length, "❣♥(｡◕‿◕｡)♥❣")
            } else if (!f.getPreviewText().contains("❣♥(｡◕‿◕｡)♥❣")) {
                strBld.insert(0, "❣♥(｡◕‿◕｡)♥❣")
                strBld.insert(strBld.length, "❣♥(｡◕‿◕｡)♥❣")
            }
            61 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "ლ❣☆(❁‿❁)☆❣ლ")
                strBld.insert(strBld.length, "ლ❣☆(❁‿❁)☆❣ლ")
            } else if (!f.getPreviewText().contains("ლ❣☆(❁‿❁)☆❣ლ")) {
                strBld.insert(0, "ლ❣☆(❁‿❁)☆❣ლ")
                strBld.insert(strBld.length, "ლ❣☆(❁‿❁)☆❣ლ")
            }
            62 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "✿❀❁(◠‿◠)❁❀✿")
                strBld.insert(strBld.length, "✿❀❁(◠‿◠)❁❀✿")
            } else if (!f.getPreviewText().contains("✿❀❁(◠‿◠)❁❀✿")) {
                strBld.insert(0, "✿❀❁(◠‿◠)❁❀✿")
                strBld.insert(strBld.length, "✿❀❁(◠‿◠)❁❀✿")
            }
            63 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "✌✌(•ิ‿•ิ)✌✌")
                strBld.insert(strBld.length, "✌✌(•ิ‿•ิ)✌✌")
            } else if (!f.getPreviewText().contains("✌✌(•ิ‿•ิ)✌✌")) {
                strBld.insert(0, "✌✌(•ิ‿•ิ)✌✌")
                strBld.insert(strBld.length, "✌✌(•ิ‿•ิ)✌✌")
            }
            64 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "❆❆≧◠‿◠≦❆❆")
                strBld.insert(strBld.length, "❆❆≧◠‿◠≦❆❆")
            } else if (!f.getPreviewText().contains("❆❆≧◠‿◠≦❆❆")) {
                strBld.insert(0, "❆❆≧◠‿◠≦❆❆")
                strBld.insert(strBld.length, "❆❆≧◠‿◠≦❆❆")
            }
            65 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "❤❣♥‿♥❣❤")
                strBld.insert(strBld.length, "❤❣♥‿♥❣❤")
            } else if (!f.getPreviewText().contains("❤❣♥‿♥❣❤")) {
                strBld.insert(0, "❤❣♥‿♥❣❤")
                strBld.insert(strBld.length, "❤❣♥‿♥❣❤")
            }
            66 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "【★】【★】")
                strBld.insert(strBld.length, "【★】【★】")
            } else if (!f.getPreviewText().contains("【★】【★】")) {
                strBld.insert(0, "【★】【★】")
                strBld.insert(strBld.length, "【★】【★】")
            }
            67 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "☜☆☞")
                strBld.insert(strBld.length, "☜☆☞")
            } else if (!f.getPreviewText().contains("☜☆☞")) {
                strBld.insert(0, "☜☆☞")
                strBld.insert(strBld.length, "☜☆☞")
            }
            68 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "●♡▬▬♡")
                strBld.insert(strBld.length, "♡▬▬♡●")
            } else if (!f.getPreviewText().contains("●♡▬▬♡")) {
                strBld.insert(0, "●♡▬▬♡")
                strBld.insert(strBld.length, "♡▬▬♡●")
            }
            69 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "❣❤---» [")
                strBld.insert(strBld.length, "] «---❤❣")
            } else if (!f.getPreviewText().contains("❣❤---» [")) {
                strBld.insert(0, "❣❤---» [")
                strBld.insert(strBld.length, "] «---❤❣")
            }
            70 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "(▰˘◡˘▰)")
                strBld.insert(strBld.length, "(▰˘◡˘▰)")
            } else if (!f.getPreviewText().contains("(▰˘◡˘▰)")) {
                strBld.insert(0, "(▰˘◡˘▰)")
                strBld.insert(strBld.length, "(▰˘◡˘▰)")
            }
            71 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "☀(ღ˘⌣˘ღ)☀")
                strBld.insert(strBld.length, "☀(ღ˘⌣˘ღ)☀")
            } else if (!f.getPreviewText().contains("☀(ღ˘⌣˘ღ)☀")) {
                strBld.insert(0, "☀(ღ˘⌣˘ღ)☀")
                strBld.insert(strBld.length, "☀(ღ˘⌣˘ღ)☀")
            }
            72 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "☀❤◕ ‿ ◕❤☀")
                strBld.insert(strBld.length, "☀❤◕ ‿ ◕❤☀")
            } else if (!f.getPreviewText().contains("☀❤◕ ‿ ◕❤☀")) {
                strBld.insert(0, "☀❤◕ ‿ ◕❤☀")
                strBld.insert(strBld.length, "☀❤◕ ‿ ◕❤☀")
            }
            73 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "❤╰། ◉ ◯ ◉ །╯❤")
                strBld.insert(strBld.length, "❤╰། ◉ ◯ ◉ །╯❤")
            } else if (!f.getPreviewText().contains("❤╰། ◉ ◯ ◉ །╯❤")) {
                strBld.insert(0, "❤╰། ◉ ◯ ◉ །╯❤")
                strBld.insert(strBld.length, "❤╰། ◉ ◯ ◉ །╯❤")
            }
            74 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "❄♥‿♥❄")
                strBld.insert(strBld.length, "❄♥‿♥❄")
            } else if (!f.getPreviewText().contains("❄♥‿♥❄")) {
                strBld.insert(0, "❄♥‿♥❄")
                strBld.insert(strBld.length, "❄♥‿♥❄")
            }
            75 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "☀☀｡◕‿‿◕｡☀☀")
                strBld.insert(strBld.length, "☀☀｡◕‿‿◕｡☀☀")
            } else if (!f.getPreviewText().contains("☀☀｡◕‿‿◕｡☀☀")) {
                strBld.insert(0, "☀☀｡◕‿‿◕｡☀☀")
                strBld.insert(strBld.length, "☀☀｡◕‿‿◕｡☀☀")
            }
            76 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "↫❣(◕ω◕)❣↬")
                strBld.insert(strBld.length, "↫❣(◕ω◕)❣↬")
            } else if (!f.getPreviewText().contains("↫❣(◕ω◕)❣↬")) {
                strBld.insert(0, "↫❣(◕ω◕)❣↬")
                strBld.insert(strBld.length, "↫❣(◕ω◕)❣↬")
            }
            77 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "☜☆☞(◠‿◠)")
                strBld.insert(strBld.length, "(◠‿◠)☜☆☞")
            } else if (!f.getPreviewText().contains("☜☆☞(◠‿◠)")) {
                strBld.insert(0, "☜☆☞(◠‿◠)")
                strBld.insert(strBld.length, "(◠‿◠)☜☆☞")
            }
            78 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "☀웃❤유☀")
                strBld.insert(strBld.length, "☀웃❤유☀")
            } else if (!f.getPreviewText().contains("☀웃❤유☀")) {
                strBld.insert(0, "☀웃❤유☀")
                strBld.insert(strBld.length, "☀웃❤유☀")
            }
            79 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "❤ᶫᵒᵛᵉᵧₒᵤ❤")
                strBld.insert(strBld.length, "❤ᶫᵒᵛᵉᵧₒᵤ❤")
            } else if (!f.getPreviewText().contains("❤ᶫᵒᵛᵉᵧₒᵤ❤")) {
                strBld.insert(0, "❤ᶫᵒᵛᵉᵧₒᵤ❤")
                strBld.insert(strBld.length, "❤ᶫᵒᵛᵉᵧₒᵤ❤")
            }
            80 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "❤ℐɕℎ ℒ℩ℯɓℯ ɗ℩ɕℎ❤")
                strBld.insert(strBld.length, "❤ℐɕℎ ℒ℩ℯɓℯ ɗ℩ɕℎ❤")
            } else if (!f.getPreviewText().contains("❤ℐɕℎ ℒ℩ℯɓℯ ɗ℩ɕℎ❤")) {
                strBld.insert(0, "❤ℐɕℎ ℒ℩ℯɓℯ ɗ℩ɕℎ❤")
                strBld.insert(strBld.length, "❤ℐɕℎ ℒ℩ℯɓℯ ɗ℩ɕℎ❤")
            }
            81 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "➳♥➳♥➳")
                strBld.insert(strBld.length, "➳♥➳♥➳")
            } else if (!f.getPreviewText().contains("➳♥➳♥➳")) {
                strBld.insert(0, "➳♥➳♥➳")
                strBld.insert(strBld.length, "➳♥➳♥➳")
            }
            82 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "✿◡‿◡✿")
                strBld.insert(strBld.length, "✿◡‿◡✿")
            } else if (!f.getPreviewText().contains("✿◡‿◡✿")) {
                strBld.insert(0, "✿◡‿◡✿")
                strBld.insert(strBld.length, "✿◡‿◡✿")
            }
            83 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "●▬ൠൠ▬")
                strBld.insert(strBld.length, "▬ൠൠ▬●")
            } else if (!f.getPreviewText().contains("●▬ൠൠ▬")) {
                strBld.insert(0, "●▬ൠൠ▬")
                strBld.insert(strBld.length, "▬ൠൠ▬●")
            }
            84 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "[̲̅ə̲̅٨̲̅٥̲̅٦̲̅]")
                strBld.insert(strBld.length, "[̲̅ə̲̅٨̲̅٥̲̅٦̲̅]")
            } else if (!f.getPreviewText().contains("[̲̅ə̲̅٨̲̅٥̲̅٦̲̅]")) {
                strBld.insert(0, "[̲̅ə̲̅٨̲̅٥̲̅٦̲̅]")
                strBld.insert(strBld.length, "[̲̅ə̲̅٨̲̅٥̲̅٦̲̅]")
            }
            85 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "✰(❤˘⌣˘❤)✰")
                strBld.insert(strBld.length, "✰(❤˘⌣˘❤)✰")
            } else if (!f.getPreviewText().contains("✰(❤˘⌣˘❤)✰")) {
                strBld.insert(0, "✰(❤˘⌣˘❤)✰")
                strBld.insert(strBld.length, "✰(❤˘⌣˘❤)✰")
            }
            86 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "❤◉◡◉❤")
                strBld.insert(strBld.length, "❤◉◡◉❤")
            } else if (!f.getPreviewText().contains("❤◉◡◉❤")) {
                strBld.insert(0, "❤◉◡◉❤")
                strBld.insert(strBld.length, "❤◉◡◉❤")
            }
            87 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "✬✬（⌒▽⌒）✬✬")
                strBld.insert(strBld.length, "✬✬（⌒▽⌒）✬✬")
            } else if (!f.getPreviewText().contains("✬✬（⌒▽⌒）✬✬")) {
                strBld.insert(0, "✬✬（⌒▽⌒）✬✬")
                strBld.insert(strBld.length, "✬✬（⌒▽⌒）✬✬")
            }
            88 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "❣⍣◕‿◕⍣❣")
                strBld.insert(strBld.length, "❣⍣◕‿◕⍣❣")
            } else if (!f.getPreviewText().contains("❣⍣◕‿◕⍣❣")) {
                strBld.insert(0, "❣⍣◕‿◕⍣❣")
                strBld.insert(strBld.length, "❣⍣◕‿◕⍣❣")
            }
            89 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "☀☀♡♡")
                strBld.insert(strBld.length, "♡♡☀☀")
            } else if (!f.getPreviewText().contains("☀☀♡♡")) {
                strBld.insert(0, "☀☀♡♡")
                strBld.insert(strBld.length, "♡♡☀☀")
            }
            90 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "ღღ(∩_∩)ღღ")
                strBld.insert(strBld.length, "ღღ(∩_∩)ღღ")
            } else if (!f.getPreviewText().contains("ღღ(∩_∩)ღღ")) {
                strBld.insert(0, "ღღ(∩_∩)ღღ")
                strBld.insert(strBld.length, "ღღ(∩_∩)ღღ")
            }
            91 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "☃（*^_^*）☃")
                strBld.insert(strBld.length, "☃（*^_^*）☃")
            } else if (!f.getPreviewText().contains("☃（*^_^*）☃")) {
                strBld.insert(0, "☃（*^_^*）☃")
                strBld.insert(strBld.length, "☃（*^_^*）☃")
            }
            92 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "✮{◕ ◡ ◕}✮")
                strBld.insert(strBld.length, "✮{◕ ◡ ◕}✮")
            } else if (!f.getPreviewText().contains("✮{◕ ◡ ◕}✮")) {
                strBld.insert(0, "✮{◕ ◡ ◕}✮")
                strBld.insert(strBld.length, "✮{◕ ◡ ◕}✮")
            }
            93 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "⁑☾˙❀‿❀˙☽⁑")
                strBld.insert(strBld.length, "⁑☾˙❀‿❀˙☽⁑")
            } else if (!f.getPreviewText().contains("⁑☾˙❀‿❀˙☽⁑")) {
                strBld.insert(0, "⁑☾˙❀‿❀˙☽⁑")
                strBld.insert(strBld.length, "⁑☾˙❀‿❀˙☽⁑")
            }
            94 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "♥♡◙‿◙♡♥")
                strBld.insert(strBld.length, "♥♡◙‿◙♡♥")
            } else if (!f.getPreviewText().contains("♥♡◙‿◙♡♥")) {
                strBld.insert(0, "♥♡◙‿◙♡♥")
                strBld.insert(strBld.length, "♥♡◙‿◙♡♥")
            }
            95 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "❄｡◕ ‿ ◕｡❄")
                strBld.insert(strBld.length, "❄｡◕ ‿ ◕｡❄")
            } else if (!f.getPreviewText().contains("❄｡◕ ‿ ◕｡❄")) {
                strBld.insert(0, "❄｡◕ ‿ ◕｡❄")
                strBld.insert(strBld.length, "❄｡◕ ‿ ◕｡❄")
            }
            96 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "❣ლʘ‿ʘლ❣")
                strBld.insert(strBld.length, "❣ლʘ‿ʘლ❣")
            } else if (!f.getPreviewText().contains("❣ლʘ‿ʘლ❣")) {
                strBld.insert(0, "❣ლʘ‿ʘლ❣")
                strBld.insert(strBld.length, "❣ლʘ‿ʘლ❣")
            }
            97 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "❤(●'◡'●)❤")
                strBld.insert(strBld.length, "❤(●'◡'●)❤")
            } else if (!f.getPreviewText().contains("❤(●'◡'●)❤")) {
                strBld.insert(0, "❤(●'◡'●)❤")
                strBld.insert(strBld.length, "❤(●'◡'●)❤")
            }
            98 -> if ("Preview text" == f.getPreviewText()) {
                strBld.insert(0, "♪┏(°.°)┛")
                strBld.insert(strBld.length, "♪┏(°.°)┛")
            } else if (!f.getPreviewText().contains("♪┏(°.°)┛")) {
                strBld.insert(0, "♪┏(°.°)┛")
                strBld.insert(strBld.length, "♪┏(°.°)┛")
            }
        }

        f.setPreviewText(strBld.toString())
        holder.description.text = f.getPreviewText()
        holder.cardView.setOnClickListener {
            val desStr = holder.description.text.toString()
            val mainText = activity!!.findViewById<TextView>(R.id.main_text)
            mainText.text = desStr

           /* activity.findViewById<ImageButton>(R.id.mainBtn).setOnClickListener {
                Toast.makeText(activity,
                    "Copied to clipboard! Your copied text is $desStr",
                    Toast.LENGTH_SHORT).show()
                saveToClipboard(desStr)
            }*/
        }
    }

 /*   fun saveToClipboard(desStr:String){
        val clipboard =
            activity?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("simple text", desStr)
        clipboard.setPrimaryClip(clip)
    }*/

    override fun getItemCount(): Int {
        return decorationFonts!!.size
    }

    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        //var title:TextView = itemView.findViewById(R.id.title_text_view_DF)
        var description:TextView=itemView.findViewById(R.id.description_text_view_DF)
        var cardView:CardView = itemView.findViewById(R.id.card_view_DF)
    }
}