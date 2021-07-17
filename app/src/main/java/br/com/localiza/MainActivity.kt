package br.com.localiza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println(ehUmBomFilme("Vingadores: Endgame"))
        criarNumeros()
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