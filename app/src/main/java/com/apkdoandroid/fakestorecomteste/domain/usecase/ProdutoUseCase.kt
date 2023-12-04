package com.apkdoandroid.fakestorecomteste.domain.usecase

import com.apkdoandroid.fakestorecomteste.data.repository.IFakeStoreRepository
import com.apkdoandroid.fakestorecomteste.domain.model.Produto

class ProdutoUseCase(private val iFakeStoreRepository: IFakeStoreRepository) {

    suspend fun recuperarProdutos(): List<Produto> {
        try {

            return iFakeStoreRepository.recuperarProdutos()

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return emptyList()
    }
}