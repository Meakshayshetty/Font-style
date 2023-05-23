package com.akshay.textstyle.model

class Font {
   private var previewText = "hey!"

   @JvmName("getPreviewText1")
   fun getPreviewText(): String {
      return previewText
   }

   @JvmName("setPreviewText1")
   fun setPreviewText(previewText: String) {
      this.previewText = previewText
   }
}