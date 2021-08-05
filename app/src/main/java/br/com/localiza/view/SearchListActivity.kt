package br.com.localiza.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.localiza.databinding.ActivitySearchListBinding
import br.com.localiza.model.MovieRepository

class SearchListActivity : AppCompatActivity() {
    private lateinit var bindingSearch: ActivitySearchListBinding
    private lateinit var adapterMovie: SearchMovieAdapter

    companion object {
        const val ID_MOVIE = "br.com.localiza.view.ListActivity.idMovie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()
        setupQuery()


    }

    private fun setupQuery() {
        bindingSearch.searchButton.setOnClickListener{
            val searchItem:String = bindingSearch.searchBar.query.toString()
            if(searchItem.isNullOrBlank())return@setOnClickListener

            adapterMovie = SearchMovieAdapter {
                val details = Intent(this, DetailsActivity::class.java)
                details.putExtra(ID_MOVIE,it)
                startActivity(details)
            }
            bindingSearch.searchMoviesList.adapter = adapterMovie
            filterList(searchItem)
        }
    }

    private fun filterList(searchItem: String) {
        MovieRepository.searchMovie(searchItem) { listSearch ->
            adapterMovie.searchAddItemList(listSearch)
        }
    }


    private fun initLayout() {
        bindingSearch = ActivitySearchListBinding.inflate(layoutInflater)
        val view = bindingSearch.root
        setContentView(view)
    }



}