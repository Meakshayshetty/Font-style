package com.akshay.textstyle.model

class Font(private val fontName: String) {
   private var previewText = "Preview text"

   fun getFontName(): String {
      return fontName
   }

   @JvmName("getPreviewText1")
   fun getPreviewText(): String {
      return previewText
   }

   @JvmName("setPreviewText1")
   fun setPreviewText(previewText: String) {
      this.previewText = previewText
   }
}