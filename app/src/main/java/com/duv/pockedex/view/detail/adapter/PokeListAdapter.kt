package com.duv.pockedex.view.detail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.duv.pockedex.R
import com.duv.pockedex.model.PokeModel

class PokeListAdapter(private val data: List<PokeModel>) :RecyclerView.Adapter<PokeListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.poke_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindItem( item: PokeModel) {

        }
    }


}