package br.com.localiza.model

import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieRepository {
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.themoviedb.org/")
        .build()
    private val moviesApi: TheMoviesApi = retrofit.create(TheMoviesApi::class.java)

    fun getPopular(callback: (List<MovieModel>) -> Unit) {
        CoroutineScope(GlobalScope.coroutineContext).launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                val callApi = moviesApi.listPopular()
                callApi.enqueue(object : Callback<MovieList> {
                    override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                        callback(response.body()?.results ?: mutableListOf())
                    }

                    override fun onFailure(call: Call<MovieList>, t: Throwable) {

                    }
                })
            }
        }
    }

    fun topRated(callback: (List<MovieModel>) -> Unit) {
        CoroutineScope(GlobalScope.coroutineContext).launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                val callApi = moviesApi.topRated()
                callApi.enqueue(object : Callback<MovieList> {
                    override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                        callback(response.body()?.results ?: mutableListOf())
                    }

                    override fun onFailure(call: Call<MovieList>, t: Throwable) {
                        //TODO
                    }
                })
            }
        }
    }

    fun upcomingMovies(callback: (List<MovieModel>) -> Unit) {
        CoroutineScope(GlobalScope.coroutineContext).launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                val callApi = moviesApi.upcomingMovies()
                callApi.enqueue(object : Callback<MovieList> {
                    override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                        callback(response.body()?.results ?: mutableListOf())
                    }

                    override fun onFailure(call: Call<MovieList>, t: Throwable) {
                        //TODO
                    }
                })
            }
        }
    }

    fun getMovieById(id: Int, callback: (MovieModel) -> Unit) {
        CoroutineScope(GlobalScope.coroutineContext).launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                val call = moviesApi.getMovieById(id)
                call.enqueue(object : Callback<MovieModel> {
                    override fun onResponse(
                        call: Call<MovieModel>,
                        response: Response<MovieModel>
                    ) {
                        callback(response.body() ?: dummyMovie)
                    }

                    override fun onFailure(call: Call<MovieModel>, t: Throwable) {

                    }

                })
            }
        }

    }

    fun searchMovie(query: String, callback: (List<MovieModel>) -> Unit) {
        CoroutineScope(GlobalScope.coroutineContext).launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                val call = moviesApi.searchMovie(searchqueryapi= query)
                call.enqueue(object : Callback<MovieList> {
                    override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                        callback(response.body()?.results ?: mutableListOf())
                    }

                    override fun onFailure(call: Call<MovieList>, t: Throwable) {
                        //TODO
                    }

                })
            }
        }

    }

    val dummyMovie: MovieModel = MovieModel(
        "Teste", 999, "", "", mutableListOf(), "", "", 0,
    )
}

//class MeuCallBack(val callback: (List<MovieModel>)) : Callback<MovieList> {
//    override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
//        callback(response.body()?.results ?: mutableListOf())
//    }
//
//    override fun onFailure(call: Call<MovieList>, t: Throwable) {
//        //
//    }
//}