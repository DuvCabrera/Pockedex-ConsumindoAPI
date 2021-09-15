package com.duv.pockedex.view.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.duv.pockedex.R
import com.duv.pockedex.model.PokeListModel
import com.duv.pockedex.view.list.PokeClickItemListener
import kotlinx.android.synthetic.main.poke_list_item.view.*

class PokeListAdapter(private val data: List<PokeListModel>, private val listener: PokeClickItemListener) :RecyclerView.Adapter<PokeListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.poke_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindItem( item: PokeListModel?) {
            if (item != null) {
                itemView.tv_pokeName.text = item.name
            }

            itemView.setOnClickListener {
                if (item != null) {
                    listener.onClickListener(item.name)
                }
            }


        }
    }


}