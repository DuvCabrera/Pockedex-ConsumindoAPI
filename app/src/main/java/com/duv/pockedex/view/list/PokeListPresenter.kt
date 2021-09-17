package com.duv.pockedex.view.list

import android.util.Log
import com.duv.pockedex.BASE_URL
import com.duv.pockedex.data.PokeRepository
import com.duv.pockedex.model.PokeListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokeListPresenter(private val view: PokeListView, private val pokeRepository: PokeRepository) {

   val callback = object: Callback<PokeListModel> {
       override fun onResponse(
       call: Call<PokeListModel>,
       response: Response<PokeListModel>
   ) {
       if (response.code() == 200){
           val pokeResponse = response.body()!!.results
           view.initPokeList(pokeResponse)
       }
       else{
           Log.e("Lista não Recebida", "Aconteceu algo errado")
       }
   }

       override fun onFailure(call: Call<PokeListModel>, t: Throwable) {
           t.message?.let { Log.e("onFailure error", it) }
       }
   }

    fun getPokeList(){
        pokeRepository.getApiList(BASE_URL, callback)
    }
}