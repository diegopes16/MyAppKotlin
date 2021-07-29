package br.com.localiza

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieRepository {
    val retrofit: Retrofit
    val moviesApi: TheMoviesApi

    init {
        retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.themoviedb.org/").build()
        moviesApi = retrofit.create(TheMoviesApi::class.java)
    }



}
