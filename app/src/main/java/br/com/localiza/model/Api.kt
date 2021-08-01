package br.com.localiza.model

import br.com.localiza.model.ApiConsts.API_KEY
import br.com.localiza.model.ApiConsts.PATH_MOVIE_ID
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMoviesApi {

    @GET("3/movie/popular?api_key=${API_KEY}&language=en-US&page=1")
    fun listPopular(): Call<MovieList>

    @GET("3/movie/{$PATH_MOVIE_ID}?api_key=${API_KEY}&language=en-US")
    fun getMovieById(@Path(PATH_MOVIE_ID) id:Int): Call<MovieModel>

    @GET("3/movie/top_rated?api_key=${API_KEY}&language=en-US&page=1")
    fun topRated(): Call<MovieList>


}

object ApiConsts {
    const val API_KEY = "ad2a7707d4536c5a488c5c927f7f38b1"
    //val REQ_API = "https://api.themoviedb.org/3/movie/550?api_key=ad2a7707d4536c5a488c5c927f7f38b1"
    const val PATH_MOVIE_ID = "id"
    const val DEFAULT_QUERY = "api_key=$API_KEY&language=en-US&page=1"
}

class MovieList(val page: Int, val results: List<MovieModel>)

