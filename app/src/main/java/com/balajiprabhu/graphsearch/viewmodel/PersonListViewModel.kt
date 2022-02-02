package com.balajiprabhu.graphsearch.viewmodel

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.balajiprabhu.graphsearch.model.GraphSearchResponse
import com.balajiprabhu.graphsearch.model.nodes.Nodes
import com.balajiprabhu.graphsearch.network.GraphSearchRepository
import com.balajiprabhu.graphsearch.network.Result
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class PersonListViewModel : ViewModel(), DefaultLifecycleObserver {

    val personList = MutableLiveData<List<Nodes>>()

    private val executorService: ExecutorService = Executors.newFixedThreadPool(4)
    private val graphSearchRepository = GraphSearchRepository(executorService)

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        getData(this)
    }

    private fun onError() {
        println("Something went wrong")
    }

    private fun setData(graphSearchResponse: GraphSearchResponse) {
        val filteredPersonList = mutableListOf<Nodes>()
        graphSearchResponse.nodes.forEach {
            if(it.data?.categories?.size == 1 && it.data?.categories?.contains("INVESTOR") == true){
                filteredPersonList.add(it)
            }
        }
        personList.postValue(filteredPersonList)
    }

    companion object {
        fun getData(personListViewModel: PersonListViewModel) {
            personListViewModel.graphSearchRepository.makeDataRequest {
                response -> when(response) {
                    is Result.Success<GraphSearchResponse> -> personListViewModel.setData(response.data)
                        else -> personListViewModel.onError()
                }
            }
        }
    }

}