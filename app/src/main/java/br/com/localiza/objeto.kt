package br.com.localiza

abstract class  Animal {

}

class  Gato:Animal(){}
class  Cachorro:Animal(){}

class MaeDePet {
    var meusPets:Array<Animal?> = Array(5){null}
}

//when
//idade in 0..17 -> print(nome)
// for (item in collection) print(item)
// for (item: Int in ints){}
// for (i in 1..10){}
// for (i in 12 downTo 6){}
//eu.meusPets.forEach{} Pra cada item ele faz uma ação
//while (x>0){}