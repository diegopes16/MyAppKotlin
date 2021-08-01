package br.com.localiza.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.localiza.databinding.MovieItemBinding
import br.com.localiza.model.MovieModel
import com.bumptech.glide.Glide


class MoviesViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)


class MovieAdapter(val movieClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<MoviesViewHolder>() {
    val listMoviesItens: MutableList<MovieModel> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(inflater, parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val item = listMoviesItens[position]
        holder.binding.tituloFilme = item.title
        Glide.with(holder.binding.root).load("https://image.tmdb.org/t/p/w500${item.poster_path}")
            .into(holder.binding.poster)
        holder.binding.itemBackground.setOnClickListener {
            movieClickListener(item.id)
//            movieClickListener()
        }
    }

    override fun getItemCount(): Int {
        return listMoviesItens.size
    }

    fun addItemList(list: List<MovieModel>) {
        listMoviesItens.clear()
        listMoviesItens.addAll(list)
        notifyDataSetChanged()
    }

}