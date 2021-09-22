package com.duv.pockedex.view.detail

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.duv.pockedex.POKE_NAME
import com.duv.pockedex.R
import com.duv.pockedex.data.PokeRepository
import com.duv.pockedex.model.PokeModel
import com.duv.pockedex.view.list.PokeDataBinding
import kotlinx.android.synthetic.main.fragment_poke_detail.*

class PokeDetailFragment : Fragment(), PokeDetailView , PokeDataBinding{

    private val presenter = PokeDetailPresenter(this, PokeRepository(), this)
    private var pokeName: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_poke_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let{
            pokeName =it.getString(POKE_NAME)
        }
        presenter.getPokemon(pokeName)


    }

    override fun initPokemon(pokemon: PokeModel) {
        presenter.getPokeImage(pokemon.sprites.front_default)
        tv_pokeName.text = pokemon.name
        tv_pokeHeight.text = pokemon.height.toString()
        tv_pokeWeight.text = pokemon.weight.toString()
        pokemon.types.let{
            var pokeType: String = ""
            for (type in it){
                pokeType += type.type.name + " | "
            }
            tv_pokeType.text = pokeType
        }
        pokemon.stats.let{
            var pokeStats: String = ""
            for (stat in it) {
                pokeStats += stat.stat.name + " = "  + stat.base_stat.toString() + "\n"
            }
            tv_pokeStatus.text = pokeStats
        }
    }

    override fun bindingPoke(bitmap: Bitmap?) {
        iv_pokePhoto.setImageBitmap(bitmap)
    }
}