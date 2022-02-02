package com.balajiprabhu.graphsearch.model.edges

import com.balajiprabhu.graphsearch.model.Attributes
import com.balajiprabhu.graphsearch.model.Data
import com.google.gson.annotations.SerializedName


data class Edges (

  @SerializedName("id"         ) var id         : Int?        = null,
  @SerializedName("source"     ) var source     : Int?        = null,
  @SerializedName("target"     ) var target     : Int?        = null,
  @SerializedName("data"       ) var data       : Data?       = Data(),
  @SerializedName("attributes" ) var attributes : Attributes? = Attributes()

)