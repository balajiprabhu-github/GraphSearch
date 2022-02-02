package com.balajiprabhu.graphsearch.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.balajiprabhu.graphsearch.R
import com.balajiprabhu.graphsearch.databinding.ActivityOrganisationListBinding
import com.balajiprabhu.graphsearch.viewmodel.OrganisationListViewModel
import com.balajiprabhu.graphsearch.views.adapters.ListAdapter

class OrganisationListActivity : AppCompatActivity() {

    lateinit var organisationListViewModel : OrganisationListViewModel

    var listAdapter  = ListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityOrganisationListBinding = DataBindingUtil.setContentView(this,R.layout.activity_organisation_list)
        organisationListViewModel = ViewModelProvider(this).get(OrganisationListViewModel::class.java)
        binding.viewModel = organisationListViewModel
        lifecycle.addObserver(organisationListViewModel)

        binding.organisationRecyclerView.adapter = listAdapter

        organisationListViewModel.organisationList.observe(this, Observer {
            listAdapter.setList(it)
        })

        OrganisationListViewModel.getData(organisationListViewModel)

    }
}