package br.com.localiza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.localiza.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


 fun openDetailsActivity(id:Int){
    val intent = Intent(this,DetailsActivity::class.java)
        //.apply {
        //putExtra(DetailsActivity.EXTRA_ID,id)
    //}
    startActivity(intent)
}

    }
 }