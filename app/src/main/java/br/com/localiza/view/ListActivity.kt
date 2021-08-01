package br.com.localiza.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.localiza.databinding.ActivityListBinding
import br.com.localiza.model.MovieRepository

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()

        setupList()

    }

    private fun initLayout() {
        binding = ActivityListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun setupList() {
        val adapterMovie = MovieAdapter {
            val details = Intent(this, DetailsActivity::class.java)
            startActivity(details)
        }
        binding.popularMoviesListItens.adapter = adapterMovie
        MovieRepository.getPopular { listpop ->
            adapterMovie.addItemList(listpop)
        }
        binding.topRatedMoviesListItens.adapter = adapterMovie
        MovieRepository.topRated { listtop ->
            adapterMovie.addItemList(listtop)
        }
    }
}



