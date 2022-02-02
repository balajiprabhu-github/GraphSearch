package com.balajiprabhu.graphsearch.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.balajiprabhu.graphsearch.R
import com.balajiprabhu.graphsearch.databinding.ActivityPersonListBinding
import com.balajiprabhu.graphsearch.viewmodel.PersonListViewModel
import com.balajiprabhu.graphsearch.views.adapters.ListAdapter

class PersonListActivity : AppCompatActivity(), LifecycleOwner {

    lateinit var personListViewModel : PersonListViewModel

    var personListAdapter  = ListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityPersonListBinding = DataBindingUtil.setContentView(this,R.layout.activity_person_list)
        personListViewModel = ViewModelProvider(this).get(PersonListViewModel::class.java)
        binding.viewModel = personListViewModel
        lifecycle.addObserver(personListViewModel)

        binding.personRecyclerView.adapter = personListAdapter

        personListViewModel.personList.observe(this, Observer {
            personListAdapter.setList(it)
        })

        PersonListViewModel.getData(personListViewModel)

    }
}