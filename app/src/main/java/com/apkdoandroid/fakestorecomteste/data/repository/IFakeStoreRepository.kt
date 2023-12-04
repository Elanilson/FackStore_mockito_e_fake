package com.apkdoandroid.fakestorecomteste.data.repository

import com.apkdoandroid.fakestorecomteste.data.dto.ProdutoResposta
import com.apkdoandroid.fakestorecomteste.domain.model.Produto

interface IFakeStoreRepository {
    suspend fun  recuperarProdutos() : List<Produto>
}