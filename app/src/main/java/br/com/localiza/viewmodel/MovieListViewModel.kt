package br.com.localiza.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.localiza.model.MovieModel
import br.com.localiza.model.MovieRepository

class MovieListViewModel: ViewModel() {
    private val liveDatalist: MutableLiveData<List<MovieModel>?> = MutableLiveData(null)

    fun getPopular() {
        MovieRepository.getPopular { listPopular ->
            liveDatalist.postValue(listPopular)
        }
    }
    fun getLiveDataList(): LiveData<List<MovieModel>?> {
        return liveDatalist
    }
}