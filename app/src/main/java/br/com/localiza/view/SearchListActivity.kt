package br.com.localiza.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.localiza.R
import br.com.localiza.databinding.ActivityListBinding
import br.com.localiza.databinding.ActivitySearchListBinding

class SearchListActivity : AppCompatActivity() {
    private lateinit var bindingSearch: ActivitySearchListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()

    }

    private fun initLayout() {
        bindingSearch = ActivitySearchListBinding.inflate(layoutInflater)
        val view = bindingSearch.root
        setContentView(view)
    }

    val txtBusca = bindingSearch.searchBar.query
}