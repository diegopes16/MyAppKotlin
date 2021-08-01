package br.com.localiza.model

import br.com.localiza.model.ApiConsts.API_KEY
import br.com.localiza.model.ApiConsts.BUSCA_STRING
import br.com.localiza.model.ApiConsts.DEFAULT_QUERY
import br.com.localiza.model.ApiConsts.LANGUAGE
import br.com.localiza.model.ApiConsts.PATH_MOVIE_ID
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMoviesApi {

    @GET("3/movie/popular?${DEFAULT_QUERY}")
    fun listPopular(): Call<MovieList>

    @GET("3/movie/{$PATH_MOVIE_ID}?api_key=${API_KEY}&language=${LANGUAGE}")
    fun getMovieById(@Path(PATH_MOVIE_ID) id:Int): Call<MovieModel>

    @GET("3/movie/top_rated?${DEFAULT_QUERY}")
    fun topRated(): Call<MovieList>

    @GET("3/search/movie?api_key=${API_KEY}&language=${LANGUAGE}&query={$BUSCA_STRING}&page=1&include_adult=false")
    fun searchMovie(@Path(BUSCA_STRING) txtBusca:String): Call<MovieList>

    @GET("3/movie/upcoming?${DEFAULT_QUERY}")
    fun upcomingMovies(): Call<MovieList>


}

object ApiConsts {
    const val API_KEY = "ad2a7707d4536c5a488c5c927f7f38b1"
    const val  LANGUAGE = "en-US"
    const val PATH_MOVIE_ID = "id"
    const val BUSCA_STRING = "BuscaString"
    const val DEFAULT_QUERY = "api_key=$API_KEY&language=${LANGUAGE}&page=1"
}

class MovieList(val page: Int, val results: List<MovieModel>)

