package com.apkdoandroid.fakestorecomteste.view.model

import com.apkdoandroid.fakestorecomteste.domain.model.Produto

class ProdutoUseCaseFake {

    suspend fun recuperarProdutos(): List<Produto> {
        return listOf(Produto(1,""))
    }
}