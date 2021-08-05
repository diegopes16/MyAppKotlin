package br.com.localiza.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.localiza.databinding.MovieItemBinding
import br.com.localiza.databinding.MovieSearchitemBinding
import br.com.localiza.model.MovieModel
import com.bumptech.glide.Glide


class SearchMoviesViewHolder(val binding: MovieSearchitemBinding) : RecyclerView.ViewHolder(binding.root)


class SearchMovieAdapter(val movieClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<SearchMoviesViewHolder>() {
    val listMoviesItens: MutableList<MovieModel> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMoviesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieSearchitemBinding.inflate(inflater, parent, false)
        return SearchMoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchMoviesViewHolder, position: Int) {
        val item = listMoviesItens[position]
        Glide.with(holder.binding.root).load("https://image.tmdb.org/t/p/w500${item.poster_path}")
            .into(holder.binding.searchPoster)
        holder.binding.searchItemBackground.setOnClickListener {
            movieClickListener(item.id)
        }
    }

    override fun getItemCount(): Int {
        return listMoviesItens.size
    }

    fun searchAddItemList(list: List<MovieModel>) {
        listMoviesItens.clear()
        listMoviesItens.addAll(list)
        notifyDataSetChanged()
    }

}