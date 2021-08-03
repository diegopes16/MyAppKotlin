package br.com.localiza.model

data class MovieModel(
    val title: String,
    val id: Int,
    val poster_path: String,
    val overview: String,
    val genres: List<GenreModel>,
    val release_date: String,
    val status: String,
    val runtime: Int

)

