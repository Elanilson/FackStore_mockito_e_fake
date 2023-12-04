package com.apkdoandroid.fakestorecomteste.data.repository

import com.apkdoandroid.fakestorecomteste.data.dto.ToProduto
import com.apkdoandroid.fakestorecomteste.data.remoto.FakeStoreAPI
import com.apkdoandroid.fakestorecomteste.domain.model.Produto

class FakeStoreRepositoryImpl (private val fakeStoreAPI: FakeStoreAPI) : IFakeStoreRepository{

    override suspend fun recuperarProdutos(): List<Produto> {

        try{
            val retorno = fakeStoreAPI.buscarProdutos()
            if(retorno.isSuccessful && retorno.body() != null){
                val resposta = retorno.body()
                if(resposta != null){
                  val lista = resposta.map { it.ToProduto() }
                    return lista
                }

            }
        }catch (e : Exception){
            e.printStackTrace()
        }

        return emptyList()
    }
}