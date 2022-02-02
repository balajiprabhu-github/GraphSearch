package com.balajiprabhu.graphsearch.network

import com.balajiprabhu.graphsearch.model.GraphSearchResponse
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper

class GraphSearchResponseParser {

    fun parse(jsonString: String): GraphSearchResponse {
        val mapper = ObjectMapper()
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        return mapper.readValue(jsonString, GraphSearchResponse::class.java)
    }

}