package com.balajiprabhu.graphsearch.model

import com.google.gson.annotations.SerializedName


data class Icon (

  @SerializedName("font"    ) var font    : String? = null,
  @SerializedName("content" ) var content : String? = null,
  @SerializedName("color"   ) var color   : String? = null,
  @SerializedName("style"   ) var style   : String? = null

)