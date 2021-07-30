package br.com.localiza.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.localiza.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var bindingmain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            bindingmain = ActivityMainBinding.inflate(layoutInflater)
            val view = bindingmain.root
            setContentView(view)

        bindingmain.botaoVoltar.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }

//            bindingmain.posterId.setOnClickListener {
//                val intent = Intent(this, ListActivity::class.java)
//                startActivity(intent)
//            }
        }
    }
