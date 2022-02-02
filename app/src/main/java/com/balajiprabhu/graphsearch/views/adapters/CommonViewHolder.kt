package com.balajiprabhu.graphsearch.views.adapters

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.balajiprabhu.graphsearch.BR

class CommonViewHolder(private val viewDataBinding: ViewDataBinding) : RecyclerView.ViewHolder(viewDataBinding.root) {

    fun <VM> bind(viewModel : VM){
        viewDataBinding.setVariable(BR.viewModel,viewModel)
        viewDataBinding.executePendingBindings()
    }

}