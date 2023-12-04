package com.apkdoandroid.fakestorecomteste.view.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apkdoandroid.fakestorecomteste.domain.usecase.ProdutoUseCase

class ViewModelFactory (private val produtoUseCase: ProdutoUseCase) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            MainViewModel(produtoUseCase) as T
        }else{
            throw IllegalArgumentException("ViewModel não foi configurado corretamente")
        }
    }
}