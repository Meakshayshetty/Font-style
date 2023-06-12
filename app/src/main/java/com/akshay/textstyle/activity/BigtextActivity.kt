package com.akshay.textstyle.activity

import android.content.ClipData
import android.content.ClipboardManager
import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.akshay.textstyle.R
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class BigtextActivity : AppCompatActivity() {

    val characters = mapOf(
        'A' to listOf(
            "   ██████",
            " ██          ██",
            " ██          ██",
            " ████████ ",
            " ██          ██ ",
            " ██          ██ ",
            " ██          ██ "
        ),
        'B' to listOf(
            " ███████  ",
            " ██          ██",
            " ██          ██",
            " ███████  ",
            " ██          ██",
            " ██          ██",
            " ███████  "
        ),
        'C' to listOf(
            "  ██████  ",
            " ██       ██ ",
            " ██       ",
            " ██       ",
            " ██       ",
            " ██       ██ ",
            "  ██████  "
        ),
        'D' to listOf(
            " ███████  ",
            " ██          ██ ",
            " ██          ██ ",
            " ██          ██ ",
            " ██          ██ ",
            " ██          ██ ",
            " ███████  "
        ),
        'E' to listOf(
            " ████████ ",
            " ██       ",
            " ██       ",
            " ███████  ",
            " ██       ",
            " ██       ",
            " ████████ "
        ),
        'F' to listOf(
            " ████████ ",
            " ██       ",
            " ██       ",
            " ██████   ",
            " ██       ",
            " ██       ",
            " ██       "
        ),
        'G' to listOf(
            "  ██████  ",
            " ██        ██ ",
            " ██       ",
            " ██   ███ ",
            " ██        ██ ",
            " ██        ██ ",
            "  ██████  "
        ),
        'H' to listOf(
            " ██        ██ ",
            " ██        ██ ",
            " ██        ██ ",
            " ███████ ",
            " ██        ██ ",
            " ██        ██ ",
            " ██        ██ "
        ),
        'I' to listOf(
            " ███████ ",
            "       ██    ",
            "       ██    ",
            "       ██    ",
            "       ██    ",
            "       ██    ",
            " ███████ "
        ),
        'J' to listOf(
            " ████████ ",
            "         ██    ",
            "         ██    ",
            "         ██    ",
            "         ██    ",
            " ██    ██    ",
            "  ███     "
        ),
        'K' to listOf(
            " ██     ██  ",
            " ██    ██   ",
            " ██   ██    ",
            " ████     ",
            " ██   ██    ",
            " ██    ██   ",
            " ██     ██  "
        ),
        'L' to listOf(
            " ██       ",
            " ██       ",
            " ██       ",
            " ██       ",
            " ██       ",
            " ██       ",
            " ████████ "
        ),
        'M' to listOf(
            " ██       ██ ",
            " ███    █ ██ ",
            " ██ ██    ██  ",
            " ██ ██    ██  ",
            " ██          ██ ",
            " ██          ██ ",
            " ██          ██ "
        ),
        'N' to listOf(
            " ██         ██ ",
            " ███       ██ ",
            " ███       ██ ",
            " ██ ██    ██ ",
            " ██  ██   ██ ",
            " ██    █   ██ ",
            " ██      █ ██ "
        ),
        'O' to listOf(
            "  ██████  ",
            " ██       ██ ",
            " ██       ██ ",
            " ██       ██ ",
            " ██       ██ ",
            " ██       ██ ",
            "  ██████  "
        ),
        'P' to listOf(
            " ███████  ",
            " ██         ██ ",
            " ██         ██ ",
            " ███████  ",
            " ██       ",
            " ██       ",
            " ██       "
        ),
        'Q' to listOf(
            "  ██████  ",
            " ██       ██ ",
            " ██       ██ ",
            " ██       ██ ",
            " ██  █   ██ ",
            " ██   █  ██ ",
            "  ██████  "
        ),
        'R' to listOf(
            " ███████  ",
            " ██         ██ ",
            " ██         ██ ",
            " ███████  ",
            " ██       ██   ",
            " ██         ██  ",
            " ██          ██ "
        ),
        'S' to listOf(
            "  ██████  ",
            " ██       ██ ",
            " ██       ",
            "  ██████  ",
            "            ██ ",
            " ██       ██ ",
            "  ██████  "
        ),
        'T' to listOf(
            " ████████ ",
            "        ██    ",
            "        ██    ",
            "        ██    ",
            "        ██    ",
            "        ██    ",
            "        ██    "
        ),
        'U' to listOf(
            " ██        ██ ",
            " ██        ██ ",
            " ██        ██ ",
            " ██        ██ ",
            " ██        ██ ",
            " ██        ██ ",
            "  ██████  "
        ),
        'V' to listOf(
            " ██               ██ ",
            "  ██             ██ ",
            "   ██           ██ ",
            "    ██         ██ ",
            "     ██       ██ ",
            "      ██    ██  ",
            "        ████   "
        ),
        'W' to listOf(
            " ██                   ██",
            " ██                   ██",
            " ██                   ██",
            " ██      ██        ██ ",
            " ██  ██     ██  ██ ",
            " ███              ███ ",
            " ██                    ██"
        ),
        'X' to listOf(
            "██        ██ ",
            " ██      ██ ",
            "  ██    ██  ",
            "      ██   ",
            "  ██    ██  ",
            " ██      ██ ",
            "██        ██ "
        ),
        'Y' to listOf(
            " ██      ██ ",
            " ██      ██ ",
            " ██      ██ ",
            "   ██   ██  ",
            "    ████   ",
            "      ██    ",
            "      ██    "
        ),
        'Z' to listOf(
            " ████████ ",
            "                 ██   ",
            "            ██    ",
            "         ██    ",
            "      ██      ",
            "  ██       ",
            " ████████ "
        )
    )

    private lateinit var editTxtMain: EditText
    private lateinit var mainText: TextView

    private lateinit var generateBigChar: ImageButton
    private lateinit var resetBtn: ImageButton

    private lateinit var copyBtn: Button

    private lateinit var adView: AdView
    private lateinit var clearBtn :ImageButton

    private var mInterstitialAd: InterstitialAd?=null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bigtext)

        editTxtMain = findViewById(R.id.editText_main_big)
        mainText = findViewById(R.id.main_text_big)

        generateBigChar = findViewById(R.id.generate_btn_big)
        resetBtn = findViewById(R.id.reset_btn_big)

        copyBtn = findViewById(R.id.big_copy)

        adView = findViewById(R.id.bigtext_adView)
        clearBtn =findViewById(R.id.big_main_clear)

        MobileAds.initialize(this)

        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        clearBtn.setOnClickListener {
            editTxtMain.setText("")
        }


        InterstitialAd.load(this,getString(R.string.text_repeater_interstitial_uniid),adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                adError.toString().let { Log.d(ContentValues.TAG, it) }
                Log.d("not load", "error loading.")

                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                Log.d("load", "ad loaded.")
                mInterstitialAd = interstitialAd

                mInterstitialAd?.fullScreenContentCallback = object: FullScreenContentCallback() {
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

        generateBigChar.setOnClickListener {
            val text = editTxtMain.text.toString().toUpperCase()

            val charArray = text.toCharArray()
            val bigCharacters = mutableListOf<String>()

            for(char in charArray){
                val bigText = getBigAlphabet(char)
                bigCharacters.addAll(bigText)
                bigCharacters.add("  ")
            }

            val bigAlphabetText = bigCharacters.joinToString("\n")
            mainText.text = bigAlphabetText
            /*val bigText = getBigAlphabet('A')
            val bigAlphabetText = bigText.joinToString("\n")
            mainText.text = bigAlphabetText*/
        }


        copyBtn.setOnClickListener {
            saveToClipboard(mainText.text.toString())
            showInterstitialAdDelayed()
        }

        resetBtn.setOnClickListener {
            editTxtMain.setText("")
            mainText.text = ""
        }
    }
    private fun showInterstitialAdDelayed() {
        val delayMillis = 1000L // Delay between each check in milliseconds
        val maxAttempts = 10 // Maximum number of attempts

        var currentAttempt = 0

        val runnable = object : Runnable {
            override fun run() {
                if (mInterstitialAd != null) {
                    mInterstitialAd?.show(this@BigtextActivity)
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

    fun getBigAlphabet(char: Char): List<String> {
        return characters[char] ?: emptyList()
    }
}