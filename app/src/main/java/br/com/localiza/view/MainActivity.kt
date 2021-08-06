package br.com.localiza.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.localiza.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()

        binding.botaoSearchMain.setOnClickListener {
            val search = Intent(this, SearchListActivity::class.java)
            startActivity(search)
        }

        binding.botaoMovieList.setOnClickListener{
            val listact = Intent(this, ListActivity::class.java)
            startActivity(listact)
        }


    }

    private fun initLayout() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }


}

