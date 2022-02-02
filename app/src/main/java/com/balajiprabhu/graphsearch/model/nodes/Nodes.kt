package com.balajiprabhu.graphsearch.model.nodes

import com.balajiprabhu.graphsearch.model.Attributes
import com.balajiprabhu.graphsearch.model.Data
import com.google.gson.annotations.SerializedName


data class Nodes (

  @SerializedName("id"         ) var id         : Int?        = null,
  @SerializedName("data"       ) var data       : Data?       = Data(),
  @SerializedName("attributes" ) var attributes : Attributes? = Attributes()

)