package br.com.localiza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.localiza.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println(ehUmBomFilme("Vingadores: Endgame"))
        criarNumeros()

//        private  var binding: ActivityMainBinding
//
//        ActivityMainBinding  binding = ActivityMainBinding.inflate(layoutInflater)
//    val view = binding.root
//    setContentView(view)

    }



    fun ehUmBomFilme(filme: String?):String{
        return when (filme?.length){
            null,0 ->  "Erro, preciso de um nome pra avaliar"
            in 1..4 ->  "Um nome tão curto não pode ser bom"
            else ->  "É, talvez seja bom"
        }
    }

    fun criarNumeros(){
        val lista = List(10){it+1}
        var listamutavel = mutableListOf<String>()
        lista.forEach(){
            listamutavel.add(if(it%2==0) it.toString() else "-")
        }
        println(listamutavel)
    }
 }