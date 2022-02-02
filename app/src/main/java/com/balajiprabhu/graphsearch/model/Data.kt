package com.balajiprabhu.graphsearch.model

import com.google.gson.annotations.SerializedName


data class Data (

  @SerializedName("type" ) var type : String? = null,
  @SerializedName("properties" ) var properties : Properties? = null,
  @SerializedName("categories" ) var categories : ArrayList<String> = arrayListOf()

)