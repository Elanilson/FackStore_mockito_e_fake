package com.apkdoandroid.fakestorecomteste.data.remoto

import com.apkdoandroid.fakestorecomteste.data.dto.ProdutoResposta
import retrofit2.Response
import retrofit2.http.GET

interface FakeStoreAPI {
    @GET("products")
    suspend fun buscarProdutos() : Response<List<ProdutoResposta>>
}