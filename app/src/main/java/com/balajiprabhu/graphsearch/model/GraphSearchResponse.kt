package com.balajiprabhu.graphsearch.model

import com.balajiprabhu.graphsearch.model.edges.Edges
import com.balajiprabhu.graphsearch.model.nodes.Nodes
import com.google.gson.annotations.SerializedName


data class GraphSearchResponse (

  @SerializedName("nodes" ) var nodes : ArrayList<Nodes> = arrayListOf(),
  @SerializedName("edges" ) var edges : ArrayList<Edges> = arrayListOf()

)