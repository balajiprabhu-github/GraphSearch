package com.balajiprabhu.graphsearch.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.balajiprabhu.graphsearch.databinding.ItemPersonListBinding
import com.balajiprabhu.graphsearch.model.nodes.Nodes

class ListAdapter : RecyclerView.Adapter<CommonViewHolder>()  {

    private var nodeList = mutableListOf<Nodes>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPersonListBinding.inflate(inflater,parent,false)
        return CommonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommonViewHolder, position: Int) {
        holder.bind(nodeList[position])
    }

    override fun getItemCount(): Int = nodeList.size

    fun setList(personList : List<Nodes>){
        this.nodeList.clear()
        this.nodeList.addAll(personList)
        notifyDataSetChanged()
    }

}