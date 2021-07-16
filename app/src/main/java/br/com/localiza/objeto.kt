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