package br.com.localiza.view

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
            bindingDetails.detailsgenre.text = item.genres[0].toString()
            val runningTimeString = "${item.runtime/60}h ${item.runtime%60} min"
            bindingDetails.runtime.text = runningTimeString
            val yearMovieRelease:String = item.release_date.take(4)
            bindingDetails.yearMovie.text = yearMovieRelease

        }


        bindingDetails.botaoVoltar.setOnClickListener {
            onBackPressed()
        }

    }
}
