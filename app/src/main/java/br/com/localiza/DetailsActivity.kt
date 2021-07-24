package br.com.localiza

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.localiza.databinding.ActivityDetailsBinding

class  DetailsActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lateinit var binding: ActivityDetailsBinding
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //val context = holder.view.context

        //val intent = Intent(context,DetailsActivity::class.java)
        //intent.putExtra()
    }
    }
