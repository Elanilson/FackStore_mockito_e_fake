package com.apkdoandroid.fakestorecomteste.data.repository

import com.apkdoandroid.fakestorecomteste.domain.model.Produto

class FakeStoreRepositoryImplFake : IFakeStoreRepository {

    override suspend fun recuperarProdutos(): List<Produto> {
        return  listOf(Produto(1,""))
    }
}