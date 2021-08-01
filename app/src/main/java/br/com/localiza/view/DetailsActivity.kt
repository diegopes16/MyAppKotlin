package br.com.localiza.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.localiza.databinding.ActivityDetailsBinding
import com.bumptech.glide.Glide


class DetailsActivity : AppCompatActivity() {

    private lateinit var bindingMain: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityDetailsBinding.inflate(layoutInflater)
        val view = bindingMain.root
        setContentView(view)

        bindingMain.botaoVoltar.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
//        Glide.with(bindingMain.root).load("https://image.tmdb.org/t/p/w500${item.poster_path}")
//            .into(bindingMain.poster)


    }
}
