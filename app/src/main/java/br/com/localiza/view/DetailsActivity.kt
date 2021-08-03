package br.com.localiza.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.localiza.databinding.ActivityDetailsBinding
import br.com.localiza.model.MovieRepository
import br.com.localiza.view.ListActivity.Companion.ID_MOVIE
import com.bumptech.glide.Glide


class DetailsActivity : AppCompatActivity() {

    private lateinit var bindingDetails: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingDetails = ActivityDetailsBinding.inflate(layoutInflater)
        val view = bindingDetails.root
        setContentView(view)

        val idMovieDetails = intent.getIntExtra(ID_MOVIE,-1)

        MovieRepository.getMovieById(idMovieDetails){
            item ->
            bindingDetails.detailstitle.text = item.title
            bindingDetails.textoSinopse.text = item.overview
            Glide.with(bindingDetails.root).load("https://image.tmdb.org/t/p/w500${item.poster_path}").
            into(bindingDetails.detailsPosterImage)
            bindingDetails.detailsgenre.text = item.genres.toString()
            val runningTimeString = "${item.runtime/60}h and ${item.runtime%60} minutes"
            bindingDetails.runtime.text = runningTimeString
            bindingDetails.yearMovie.text = item.release_date



        }


        bindingDetails.botaoVoltar.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
//        Glide.with(bindingMain.root).load("https://image.tmdb.org/t/p/w500${item.poster_path}")
//            .into(bindingMain.poster)


    }
}
