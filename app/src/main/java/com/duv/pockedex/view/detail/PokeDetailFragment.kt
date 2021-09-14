package com.duv.pockedex.view.detail

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
import com.duv.pockedex.view.list.PokeClickItemListener
import com.duv.pockedex.view.list.PokeListPresenter
import com.duv.pockedex.view.list.PokeListView
import kotlinx.android.synthetic.main.fragment_poke_list.*

class PokeDetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_poke_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}