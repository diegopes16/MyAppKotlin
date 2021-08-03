package br.com.localiza.model

data class GenreModel(
    val id:Int,
    val name:String
){
    override fun toString(): String {
        return name
    }
}
