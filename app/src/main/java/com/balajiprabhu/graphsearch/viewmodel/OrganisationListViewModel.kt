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

class OrganisationListViewModel : ViewModel(), DefaultLifecycleObserver {

    val organisationList = MutableLiveData<List<Nodes>>()

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
        val filteredOrganisationList = mutableListOf<Nodes>()
        graphSearchResponse.nodes.forEach {
            if(it.data?.categories?.size == 2 && it.data?.categories?.contains("INVESTOR") == true || it.data?.categories?.contains("COMPANY") == true){
                filteredOrganisationList.add(it)
            }
        }
        organisationList.postValue(filteredOrganisationList)
    }

    companion object {
        fun getData(organisationListViewModel: OrganisationListViewModel) {
            organisationListViewModel.graphSearchRepository.makeDataRequest {
                response -> when(response) {
                    is Result.Success<GraphSearchResponse> -> organisationListViewModel.setData(response.data)
                        else -> organisationListViewModel.onError()
                }
            }
        }
    }

}