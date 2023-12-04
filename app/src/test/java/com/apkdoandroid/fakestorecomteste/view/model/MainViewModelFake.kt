package com.apkdoandroid.fakestorecomteste.view.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apkdoandroid.fakestorecomteste.domain.model.Produto
import com.apkdoandroid.fakestorecomteste.domain.usecase.ProdutoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModelFake( private val useCase: ProdutoUseCaseFake) : ViewModel() {

    private val _Produtos = MutableLiveData<List<Produto>>()
    var produtos : LiveData<List<Produto>> = _Produtos


    fun recuperarProdutos(){
        viewModelScope.launch(Dispatchers.IO) {
            val lista = useCase.recuperarProdutos()
            _Produtos.postValue(lista)
        }
    }
}