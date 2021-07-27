package br.com.localiza

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.localiza.databinding.MovieItemBinding

data class Movie(val title:String,val id:Int, val img:String ){

}

class MoviesViewHolder(val binding: MovieItemBinding):RecyclerView.ViewHolder(binding.root)


class MovieAdapter(val movieClickListener:()->Unit):
    RecyclerView.Adapter<MoviesViewHolder>() {
    val listMoviesItens: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(inflater,parent,false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val item = listMoviesItens[position]
        holder.binding.tituloFilme = item
        holder.binding.itemBackground.setOnClickListener {
            movieClickListener()
        }
    }

    override fun getItemCount(): Int {
        return listMoviesItens.size
    }

    fun addItemList(list:List<String>){
        listMoviesItens.clear()
        listMoviesItens.addAll(list)
        notifyDataSetChanged()
    }

}