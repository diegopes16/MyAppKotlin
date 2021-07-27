package br.com.localiza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.localiza.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()

        setupList()

    }
    private fun initLayout(){
        binding = ActivityListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun setupList(){
        val adapterMovie = MovieAdapter {
            val details = Intent(this, MainActivity::class.java)
            startActivity(details)
        }
        binding.moviesListItens.adapter = adapterMovie
        val list:List<String> = List(10){
            "Loki ${it}"
        }
        adapterMovie.addItemList(list)
    }

}



