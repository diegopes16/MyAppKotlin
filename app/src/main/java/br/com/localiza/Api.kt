package br.com.localiza

import br.com.localiza.ApiConsts.API_KEY
import retrofit2.Call
import retrofit2.http.GET

interface TheMoviesApi {

    @GET("3/movie/popular?api_key=${API_KEY}&language=en-US&page=1")
    fun listPopular(): Call<MovieList>

}

object ApiConsts {
    const val API_KEY = "ad2a7707d4536c5a488c5c927f7f38b1"
    //val REQ_API = "https://api.themoviedb.org/3/movie/550?api_key=ad2a7707d4536c5a488c5c927f7f38b1"
    const val PATH_MOVIE_ID = "id"
    const val DEFAULT_QUERY = "api_key=$API_KEY&language=en-US&page=1"
}

class MovieList(val page: Int, val results: List<MovieModel>)

data class MovieModel(
    val title: String,
    val id: Int,
    val poster_path: String,
    val overview: String
) // colocar em arquivo diferente e adicionar resultados que vao vim da api