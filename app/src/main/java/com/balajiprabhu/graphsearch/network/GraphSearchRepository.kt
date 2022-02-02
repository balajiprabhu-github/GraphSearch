package com.balajiprabhu.graphsearch.network

import com.balajiprabhu.graphsearch.model.GraphSearchResponse
import java.io.*
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executor

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

class GraphSearchRepository(private val executor: Executor){

    private val graphSearchResponseParser = GraphSearchResponseParser()

    fun makeDataRequest(
        callback: (Result<GraphSearchResponse>) -> Unit
    ) {
        executor.execute {
            try {
                val response = getDataSet()
                callback(response)
            } catch (e: Exception) {
                val errorResult = Result.Error(e)
                callback(errorResult)
            }
        }
    }

    private fun getDataSet(): Result<GraphSearchResponse> {

        val sb = StringBuilder()
        val url = URL(baseURL)
        (url.openConnection() as? HttpURLConnection)?.run {
            try {
                val `in`: InputStream = BufferedInputStream(inputStream)
                val bin = BufferedReader(InputStreamReader(`in`))
                var inputLine: String?
                while (bin.readLine().also { inputLine = it } != null) {
                    sb.append(inputLine)
                }
            } finally {
                disconnect()
            }

            return Result.Success(graphSearchResponseParser.parse(sb.toString()))
        }
        return Result.Error(Exception("Cannot open HttpURLConnection"))
    }

    companion object {
        private const val baseURL = "https://doc.linkurio.us/ogma/latest/resources/files/solarCity.json"
    }

}