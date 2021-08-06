package br.com.localiza.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
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
        setupList()
        setupQuery()


    }

    private fun setupList() {
        adapterMovie = SearchMovieAdapter {
            val details = Intent(this, DetailsActivity::class.java)
            details.putExtra(ID_MOVIE,it)
            startActivity(details)
        }
        bindingSearch.searchMoviesList.adapter = adapterMovie
    }

    private fun setupQuery() {
        bindingSearch.searchBar.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                bindingSearch.searchBar.clearFocus()
                if(query.isNullOrBlank()){
                    return false
                }
                filterList(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
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