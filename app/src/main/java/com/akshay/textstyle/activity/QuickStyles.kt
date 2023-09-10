package com.akshay.textstyle.activity

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshay.textstyle.adapter.QuickChatAdapter
import com.akshay.textstyle.databinding.ActivityQuickStylesBinding

class QuickStyles : AppCompatActivity() {

    private val quickStyles: ArrayList<String> = arrayListOf(
        "𝓱𝓪𝓱𝓪𝓱𝓪𝓱𝓪",
        "♡•𝓱𝓮𝓵𝓵𝓸•♡",
        "✿✧✰Ꮋᵉ𝑙𝑙ᵒ✰✧✿",
        "Ꭵ°᭄ᶫᵒᵛᵉᵧₒᵤ࿐♥",
        "🅷🅰🅷🅰🅷🅰🅷🅰",
        "Ꭵ ᭄ᶫᵒᵛᵉ☠︎︎ᵧₒᵤ࿐♥",
        "🇮  🇱 🇴 🇻 🇪  🇾 🇴 🇺  ♥️",
        "🌟ƓⰙⰙƊ 𐒄ⰙⱤƝƖƝƓ🌟",
        "𝓰𝓸𝓸𝓭 𝓷𝓲𝓰𝓱𝓽💕",
        "💢☣G͢o͢o͢d͢ M͢o͢r͢n͢i͢n͢g͢☣💢",
        "☛♥️♦ǤØØĐ ΜØŘŇƗŇ♦♥️☚",
        "🧡😇Gₒₒd ₘₒᵣₙᵢₙg😇🧡",
        "●🔷❤G͟o͟o͟d͟ ͟M͟o͟r͟n͟i͟n͟g͟ ͟ ❤️🔷●",
        "◥꧁ད 𝕘Ｏ𝕠Ⓓ ⓜσ𝐑𝕟ƗภᎶ ཌ꧂◤",
        "💋★❍★❍Ꮹoo₫ ₥oԻӣ♙ӣᏩ ❍★❍💋",
        "🦋🌺♢ 𝐆Ỗⓞ∂ 𝐌ᵒℝⓃίⓝg 🌺🦋",
        "🌞🌻♜◀̶G̶o̶o̶d̶ ̶M̶o̶r̶n̶i̶n̶g̶▶♜️🌻🌞",
        "★彡 Gσσԃ Mσɾɳιɳɠ 彡★",
        "❤️❀♰♛₲ØØĐ ₥ØⱤ₦ł₦₲ ♛♰❀❤️",
        "🌞❂𐂷 ƓⰙⰙƊ 𐒄ⰙⱤƝƖƝƓ 𐂷❂🌞",
        "꧁🥀ᎶᎾᎾⅅ ℳᎾℛℕℐℕᎶ 🥀꧂",
        "♥ﮩ٨ـﮩﮩ٨ـﮩﮩ gσσ∂♡мσяηιηg ﮩﮩـ٨ﮩﮩـ٨ﮩ♥",
        "🦚😍Ğ𝐎𝐎∂ ϻ𝐎𝕣ⓝ𝕀ⓝ𝑔😍🦚",
        "❀💋 GOOᗪ ᗰOᖇᑎIᑎG 💋❀",
        "⚔️ 🔥𝔾𝕠𝕠𝕕 𝕄𝕠𝕣𝕟𝕚𝕟🔥 ⚔️",
        "G͛⦚o͛⦚o͛⦚d͛⦚ M͛⦚o͛⦚r͛⦚n͛⦚i͛⦚n͛⦚g͛⦚",
        "❤️💙💚ĞŐŐĎ МŐŔŃĨŃ❤️💙💚",
        "💙▇☆₲ØØĐ ₥ØⱤ₦ł₦☆▇💙",
        "ıllıllı 🍄🌅Ğ𝕠σ𝔡 𝕞𝓸𝕣ภ𝕚ｎ🌅🍄 ıllıllı",
        "█▓▒▒░░░Good morning░░░▒▒▓█",
        "✩░▒▓▆▅▃▂▁\uD835\uDC06\uD835\uDC28\uD835\uDC28\uD835\uDC1D \uD835\uDC26\uD835\uDC28\uD835\uDC2B\uD835\uDC27\uD835\uDC22\uD835\uDC27\uD835\uDC20▁▂▃▅▆▓▒░✩",
        "✴.·´¯`·.·★  \uD83C\uDF80\uD835\uDCD6\uD835\uDCF8\uD835\uDCF8\uD835\uDCED \uD835\uDCF6\uD835\uDCF8\uD835\uDCFB\uD835\uDCF7\uD835\uDCF2\uD835\uDCF7\uD835\uDCF0\uD83C\uDF80  ★·.·`¯´·.✴",
        "❚█══Good morning══█❚",
        "\uD835\uDD72\uD835\uDD94\uD835\uDD94\uD835\uDD89 \uD835\uDD92\uD835\uDD94\uD835\uDD97\uD835\uDD93\uD835\uDD8E\uD835\uDD93\uD835\uDD8C✍",
        "\uD83D\uDE0D\uD83D\uDC9E\uD83D\uDC98 \uD835\uDCD6\uD835\uDCF8\uD835\uDCF8\uD835\uDCED \uD835\uDCF6\uD835\uDCF8\uD835\uDCFB\uD835\uDCF7\uD835\uDCF2\uD835\uDCF7\uD835\uDCF0 \uD83D\uDC94\uD83D\uDC8F\uD83D\uDC96",
        "∙∙·▫▫ᵒᴼᵒ▫ₒₒ▫ᵒᴼⒼⓞⓞⓓ ⓜⓞⓡⓝⓘⓝⓖᴼᵒ▫ₒₒ▫ᵒᴼᵒ▫▫·∙∙",
        "¸¸♬·¯·♪·¯·♫¸¸ \uD835\uDCD6\uD835\uDCF8\uD835\uDCF8\uD835\uDCED \uD835\uDCF6\uD835\uDCF8\uD835\uDCFB\uD835\uDCF7\uD835\uDCF2\uD835\uDCF7\uD835\uDCF0¸¸♫·¯·♪¸♩·¯·♬¸¸",
        "\uD83C\uDF53\uD83D\uDC7A  \uD835\uDD24Ｏόđ м\uD835\uDD60\uD835\uDC2Bภιⓝ\uD835\uDCD6  \uD83D\uDC09\uD83D\uDC3B\n",
        "ミミ◦❧◦°˚°◦.¸¸◦°´❤*•.¸♥ Good night ♥¸.•*❤´°◦¸¸.◦°˚°◦☙◦彡彡",
        "◦•●❤♡ Good night ♡❤●•◦",
        "𝖌𝖔𝖔𝖉𝖓𝖎𝖌𝖍𝖙 🔪",
        "Gud nyt 🌃💤😴",
        "♡✨ǤØØĐ ŇƗǤĦŦ✨♡",
        "✨\uD835\uDD3E\uD835\uDD60\uD835\uDD60\uD835\uDD55 ℕ\uD835\uDD5A\uD835\uDD58\uD835\uDD59\uD835\uDD65 ☽⋆✨",
        "━╬٨ـﮩ\uD834\uDD1E⃝\uD835\uDCD1\uD835\uDCEA\uD835\uDCEB\uD835\uDD02✿ﮩﮩـ╬━༺❤️❥❥✯",
        "Night ❤️\uD83D\uDC95\uD83E\uDD70",
        "ミ\uD83D\uDC96 Good night \uD83D\uDC96彡",
        "ɢȏȏԀ ṅıɢһṭ",
        "❀\uD83D\uDC8B GOOᗪ ᑎIGᕼT \uD83D\uDC8B❀",
        "\uD83C\uDF38ꗥ～ꗥ\uD83C\uDF38 \uD835\uDC06\uD835\uDC28\uD835\uDC28\uD835\uDC1D \uD835\uDC27\uD835\uDC22\uD835\uDC20\uD835\uDC21\uD835\uDC2D \uD83C\uDF38ꗥ～ꗥ\uD83C\uDF38",
        "꧁༺ \uD835\uDCD6\uD835\uDCF8\uD835\uDCF8\uD835\uDCED \uD835\uDCF7\uD835\uDCF2\uD835\uDCF0\uD835\uDCF1\uD835\uDCFD ༻꧂",
        "" +
                "꧁•⊹٭Good night٭⊹•꧂",
        "❡✺✺ᖱ ℵ!❡ℏт",
        "✿༺ \uD835\uDCA2\uD835\uDC5C\uD835\uDC5C\uD835\uDCB9 \uD835\uDCC3\uD835\uDCBE\uD835\uDC54\uD835\uDCBD\uD835\uDCC9 ༻✿",
        "ꁅꂦꂦꀸ ꈤꀤꁅꃅƬ",
        "꧁༺ \uD835\uDCD6\uD835\uDCF8\uD835\uDCF8\uD835\uDCED \uD835\uDCF6\uD835\uDCF8\uD835\uDCFB\uD835\uDCF7\uD835\uDCF2\uD835\uDCF7\uD835\uDCF0 ༻꧂",
        "ⲯ﹍︿﹍︿﹍ \uD835\uDE76\uD835\uDE98\uD835\uDE98\uD835\uDE8D \uD835\uDE96\uD835\uDE98\uD835\uDE9B\uD835\uDE97\uD835\uDE92\uD835\uDE97\uD835\uDE90 ﹍ⲯ﹍ⲯ﹍︿﹍☼",
        "ミ\uD83D\uDC96 Good morning \uD83D\uDC96彡",
        "ミ\uD83D\uDC96 Love you \uD83D\uDC96彡",
        "✿༺ \uD835\uDC3F\uD835\uDC5C\uD835\uDCCB\uD835\uDC52 \uD835\uDCCE\uD835\uDC5C\uD835\uDCCA ༻✿",
        "෴❤️෴ ෴❤️෴ Love you ෴❤️෴ ෴❤️෴",
        "ℓ✺ṽḙ ⑂✺ṳ",
        "◦•●❤♡ Love you ♡❤●•◦",
        "꧁༺ \uD835\uDCDB\uD835\uDCF8\uD835\uDCFF\uD835\uDCEE \uD835\uDD02\uD835\uDCF8\uD835\uDCFE ༻꧂",
        "❀\uD83D\uDC8B ᒪOᐯE YOᑌ \uD83D\uDC8B❀",
        "\uD83C\uDF38ꗥ～ꗥ\uD83C\uDF38 \uD835\uDC1C\uD835\uDC28\uD835\uDC27\uD835\uDC20\uD835\uDC2B\uD835\uDC1A\uD835\uDC2D\uD835\uDC2E\uD835\uDC25\uD835\uDC1A\uD835\uDC2D\uD835\uDC22\uD835\uDC28\uD835\uDC27 \uD83C\uDF38ꗥ～ꗥ\uD83C\uDF38",
        "❝\uD835\uDC1C\uD835\uDC28\uD835\uDC27\uD835\uDC20\uD835\uDC2B\uD835\uDC1A\uD835\uDC2D\uD835\uDC2E\uD835\uDC25\uD835\uDC1A\uD835\uDC2D\uD835\uDC22\uD835\uDC28\uD835\uDC27❞",
        "\uD808\uDD9Cƈօռɢʀǟȶʊʟǟȶɨօռ \uD808\uDD9C",
        "ミ\uD83D\uDC96 congratulation \uD83D\uDC96彡",
        "❤꧁ღ⊱♥ congratulation ♥⊱ღ꧂❤",
        "\uD835\uDE57\uD835\uDE56\uD835\uDE57\uD835\uDE57\uD835\uDE6E",
        "꧁☠︎\uD83C\uDD7C\uD83C\uDD70\uD83C\uDD81\uD83C\uDD7B\uD83C\uDD71\uD83C\uDD70\uD83C\uDD71\uD83C\uDD88☠︎꧂,",
        "..\uD835\uDC69\uD835\uDC82\uD835\uDC83\uD835\uDC9A..\uD835\uDC69\uD835\uDC90\uD835\uDC9A\uD83E\uDD40\uD83E\uDDF8",
        "..\uD835\uDC69\uD835\uDC82\uD835\uDC83\uD835\uDC9A..\uD835\uDC69\uD835\uDC90\uD835\uDC9A\uD83E\uDD40\uD83E\uDDF8",
        "\uD835\uDCD1\uD835\uDCEA\uD835\uDCEB\uD835\uDD02",
        "ʙᴀʙʏ ღ",
        "⇶✴☞\uD835\uDE3D\uD835\uDCEAḅ\uD835\uDCCE❈",
        "My \uD835\uDCD1\uD835\uDCEA\uD835\uDCEB\uD835\uDD02",
        "\uD835\uDC70 \uD835\uDC73\uD835\uDC76\uD835\uDC7D\uD835\uDC6C \uD835\uDC80\uD835\uDC76\uD835\uDC7C❤️✨",
        "I love you & sorry -sorry",
        "♡☽ \uD835\uDD26 \uD835\uDD29\uD835\uDD2C\uD835\uDD33\uD835\uDD22 \uD835\uDD36\uD835\uDD2C\uD835\uDD32.☺︎✧"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityQuickStylesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = binding.rvQuickChat
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val adapter = QuickChatAdapter(quickStyles) { selectedString ->
            // Handle the selected icon
            saveToClipboard(selectedString)

        }
        recyclerView.adapter = adapter
    }
    private fun saveToClipboard(desStr: String) {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("simple text", desStr)
        clipboard.setPrimaryClip(clip)

        Toast.makeText(
            this,
            "$desStr Copied to clipboard!",
            Toast.LENGTH_SHORT
        ).show()
    }

}