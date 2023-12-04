package com.apkdoandroid.fakestorecomteste.data.repository

import com.apkdoandroid.fakestorecomteste.data.dto.ProdutoResposta
import com.apkdoandroid.fakestorecomteste.data.remoto.FakeStoreAPI
import retrofit2.Response

class FakeStoreAPIFake : FakeStoreAPI{
    override suspend fun buscarProdutos(): Response<List<ProdutoResposta>> {
       return Response.success(
            listOf(ProdutoResposta("Rafa",10.0))
        )
    }
}