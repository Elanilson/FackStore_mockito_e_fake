package com.apkdoandroid.fakestorecomteste.domain.model

class Usuario {
    var nome : String? = null
    var sobre_nome : String? = null
    var idade : Int = 0



    private constructor()

    public class Builder{
        private var usuario : Usuario? = null

         constructor(nome : String){
            usuario = Usuario()
            usuario?.nome = nome
        }
        constructor(nome : String, sobre_nome : String){
            usuario = Usuario()
            usuario?.nome = nome
            usuario?.sobre_nome = sobre_nome
        }
        fun setIdade(idade : Int) : Builder{
            usuario?.idade = idade

            return this;
        }

        fun build() : Usuario? {
            return usuario
        }
    }

    override fun toString(): String {
        return "Usuario(nome=$nome, sobre_nome=$sobre_nome, idade=$idade)"
    }
}