package com.duv.pockedex.view.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.duv.pockedex.POKE_NAME
import com.duv.pockedex.R
import com.duv.pockedex.data.PokeRepository
import com.duv.pockedex.model.PokeListModel
import com.duv.pockedex.view.list.adapter.PokeListAdapter
import kotlinx.android.synthetic.main.fragment_poke_list.*

class PokeListFragment: Fragment(), PokeListView, PokeClickItemListener{

    private val presenter : PokeListPresenter = PokeListPresenter(this, PokeRepository())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_poke_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.getPokeList()


    }

    override fun initPokeList(list: List<PokeListModel>?) {
        val adapter = PokeListAdapter(list, this)
        rv_pokeList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_pokeList.adapter = adapter

    }

    override fun onClickListener(name: String) {
        findNavController().navigate(R.id.action_fragmentPokeList_to_fragmentPokeDetail, Bundle().apply {
            putString(POKE_NAME, name)
        })
    }
}