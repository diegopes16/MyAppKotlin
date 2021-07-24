package br.com.localiza

import androidx.recyclerview.widget.RecyclerView
import br.com.localiza.databinding.MovieItemBinding

abstract class Animal {

}

class Gato : Animal() {}
class Cachorro : Animal() {}

class MaeDePet {
    var meusPets: Array<Animal?> = Array(5) { null }
}

//when
//idade in 0..17 -> print(nome)
// for (item in collection) print(item)
// for (item: Int in ints){}
// for (i in 1..10){}
// for (i in 12 downTo 6){}
//eu.meusPets.forEach{} Pra cada item ele faz uma ação
//while (x>0){}

data class Movie(val title:String,val id:Int, val img:String ){

}

//class MoviesViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)
//
//class MoviesAdapter :
//    RecyclerView.Adapter<MoviesViewHolder>() {
//    val movieList: MutableList<Movie> = mutableListOf()
//
//    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MoviesViewHolder {
//        val inflater = LayoutInflater.from(viewGroup.context)
//        val binding = MovieItemBinding.inflate(inflater, viewGroup, false)
//        return MoviesViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(viewHolder: MoviesViewHolder, position: Int) {
//        val item:Movie = movieList[position]
//        viewHolder.binding.titulo = item.title
//    }
//
//    override fun getItemCount() = movieList.size
//
//    fun setItems(list: List<Movie>) {
//        movieList.clear()
//        movieList.addAll(list)
//        notifyDataSetChanged()
//    }
//}
//val adapter = MoviesAdapter()
//binding.moviesRV.adapter = adapter
//
//
////data class Movie(val title: String, val id: Int, val posterPath: String)
//interface MoviesApi {
//    fun getAllMovies(): List<Movie>
//}
//class TheMoviesDbApi : MoviesApi{
//    override fun getAllMovies(): List<Movie> {
//        return List(10) { Movie(title = "Vingadores $it", id = it, posterPath = "") }
//    }}

//val adapter = MoviesAdapter()
//binding.moviesRV.adapter = adapter
//val api = TheMoviesDbApi()
//adapter.setItems(api.getAllMovies())
