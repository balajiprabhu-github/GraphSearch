package com.balajiprabhu.graphsearch.model

import com.google.gson.annotations.SerializedName


data class Attributes (

  @SerializedName("x"      ) var x      : Double? = null,
  @SerializedName("y"      ) var y      : Double? = null,
  @SerializedName("text"   ) var text   : String? = null,
  @SerializedName("color"  ) var color  : String? = null,
  @SerializedName("radius" ) var radius : Int?    = null,
  @SerializedName("icon"   ) var icon   : Icon?   = Icon()

)