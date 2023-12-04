package com.apkdoandroid.fakestorecomteste.data.dto

import com.apkdoandroid.fakestorecomteste.domain.model.Produto

data class ProdutoResposta(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
){
    // Construtor secundário para criar instâncias com apenas title e price
    constructor(title: String, price: Double) : this(
        category = "",
        description = "",
        id = 0,
        image = "",
        price = price,
        rating = Rating(),  // Substitua isso pelo valor padrão desejado para Rating
        title = title
    )
}




fun ProdutoResposta.ToProduto() : Produto{
    return Produto(
        this.category,
        this.description,
        this.id,
        this.image,
        this.price,
        this.title
    )
}