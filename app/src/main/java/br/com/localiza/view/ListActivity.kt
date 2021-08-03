package br.com.localiza.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import br.com.localiza.databinding.ActivityListBinding
import br.com.localiza.model.MovieRepository
import br.com.localiza.viewmodel.MovieListViewModel

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    companion object{
        const val ID_MOVIE = "br.com.localiza.view.ListActivity.idMovie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()

        setupListPopular()

        setupListTop()

        setupListRecent()

    }


    private fun initLayout() {
        binding = ActivityListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun setupListPopular() {
        val adapterMovie = MovieAdapter {
            val details = Intent(this, DetailsActivity::class.java)
            details.putExtra(ID_MOVIE,it)
            startActivity(details)
        }

        binding.popularMoviesListItens.adapter = adapterMovie
        MovieRepository.getPopular { listPopular ->
            adapterMovie.addItemList(listPopular)
        }
    }

    private fun setupListTop() {
        val adapterMovieTop = MovieAdapter {
            val details = Intent(this, DetailsActivity::class.java)
            details.putExtra(ID_MOVIE,it)
            startActivity(details)
        }
        binding.topRatedMoviesListItens.adapter = adapterMovieTop
        MovieRepository.topRated { listTop ->
            adapterMovieTop.addItemList(listTop)
        }
    }

    private fun setupListRecent() {
        val adapterMovieRecent = MovieAdapter {
            val details = Intent(this, DetailsActivity::class.java)
            details.putExtra(ID_MOVIE,it)
            startActivity(details)
        }
        binding.upcomingMoviesListItens.adapter = adapterMovieRecent
        MovieRepository.upcomingMovies { listUpcoming ->
            adapterMovieRecent.addItemList(listUpcoming)
        }
    }



}



